from dataclasses import dataclass
from PIL import Image
import math
from ClassesShared import Vertex, HeightType, Animation, GameType
from tools import generateTextureLumpName, generateTextureModifiedLumpName, WALL_WIDTH, list_get
from enum import Enum
from fixes import (BROKEN_THINGS, B3D_TEXTURES_OVERRIDES, ALT_TEXTURE_VARIANT, AltTextureType,
    TEXTURE_INDEX_TO_ANIMATION_DURATIONS, SPRITE_INDEX_FIXES, MAP_WIDE_SPRITE_INDEX_FIXES, MapWideSpriteIndexFix,
)


@dataclass
class CrateB3D:
    startLineIdx: int
    angle: int
    content: int
    textureName: str
    spriteIdx: int

@dataclass
class LineB3D:
    v1: Vertex
    v2: Vertex
    height: HeightType
    texturesNames: list[str]

class ThingCategory(Enum):
    NPC = 0
    LAMP = 1
    DECORATION = 2

@dataclass
class ThingB3D:
    pos: Vertex
    category: ThingCategory
    color: int
    special: int|None
    sprite: int|None
    index: int

@dataclass
class AltTextureData:
    name: str
    type: AltTextureType


class MapB3D:
    def __init__(self, rawLines: list[list[int]], rawHeight: list[int],
            cratesStartLineIdx: list[int], cratesContent: list[int], cratesAngles: list[int],
            textures: list[Image.Image], linesTextures: list[list[int]],
            circles: list[list[int]], textureMirroring: list[int],
            animatedFrames: list[list[list[int]]], animatedLines: list[list[int]], sprites: list[list[Image.Image]],
            foeSprites: list[list[Image.Image]], gameType: GameType, mapIndex: int,
            thingsPos: list[list[int]], thingsSprites: list[int], thingsColors: list[int],
            thingsVisibleFlag: list[int], thingsSpecials: list[int],
            visibleThingSets: list[list[int]], triggers: list[list[int]], triggerVisibleThingSet : list[int]

    ):
        self.gameType = gameType
        self.mapIndex = mapIndex
        self.triggers: list[Vertex] = []
        for cluster in triggers:
            self.triggers.append(Vertex(cluster[0], cluster[1]))
        visibleThingsByTrigger = set()
        for lineNum in range(len(triggerVisibleThingSet)):
            visibleThingsByTrigger.update(visibleThingSets[triggerVisibleThingSet[lineNum]])
            # print(f"{i}: [{visibleThingSets[triggerVisibleThingSet[i]]}]")
        self.circles = circles

        self.textures: dict[str, Image.Image] = {}
        for texture in textures:
            self.textures[generateTextureLumpName()] = texture

        self.sprites = sprites
        self.foeSprites = foeSprites

        self.lines: list[LineB3D] = []

        for lineNum in range(len(rawLines[0])):
            texturesNames: list[str] = []
            for index in linesTextures[lineNum]:
                keys = list(self.textures.keys())
                if index >= len(keys):
                    texturesNames.append(f"NONE_{index}")
                else:
                    texturesNames.append(keys[index])
            self.lines.append(
                LineB3D(
                    v1=Vertex(rawLines[0][lineNum], rawLines[1][lineNum]),
                    v2=Vertex(rawLines[2][lineNum], rawLines[3][lineNum]),
                    height=HeightType(rawHeight[lineNum]),
                    texturesNames=texturesNames,
                )
            )

        self.crates: list[CrateB3D] = []
        for idx in range(len(cratesStartLineIdx)):
            self.crates.append(CrateB3D(
                startLineIdx=cratesStartLineIdx[idx],
                content=cratesContent[idx],
                angle=cratesAngles[idx],
                textureName=self.lines[cratesStartLineIdx[idx]].texturesNames[0],
                spriteIdx=thingsSprites[48]-16,
            ))

        self._repeatShortTextures()
        self._removeRepeatingTexturesTale()
        self.mirroredDict = {}
        self._applyAnimation(animatedFrames, animatedLines, textureMirroring)
        self._applyMirroring(textureMirroring)
        self.altTextures: dict[str, AltTextureData] = {}
        self._initAltTextures()

        for lineNum, line in enumerate(self.lines):
            override = B3D_TEXTURES_OVERRIDES.get((gameType, mapIndex), {}).get(lineNum)
            if override:
                line.texturesNames = [f"NONE_{override}"]

        if gameType == GameType.B3D:
            NPC_LAST_IDX = 16
            LAMP_LAST_IDX = 32
            DECORATION_LAST_IDX = 48
        elif gameType == GameType.L3D:
            NPC_LAST_IDX = 32
            LAMP_LAST_IDX = 64
            DECORATION_LAST_IDX = 106
        elif gameType == GameType.C3D:
            NPC_LAST_IDX = 32
            LAMP_LAST_IDX = 64
            DECORATION_LAST_IDX = 190

        self.things: list[ThingB3D] = []

        for thingIndex in range(DECORATION_LAST_IDX):
            # print(f"MapB3D thing index={thingIndex}, sprite={list_get(thingsSprites, thingIndex)}, "
            #                 f"special={list_get(thingsSpecials, thingIndex)}, "
            #                 f"visible_flag={list_get(thingsVisibleFlag, thingIndex)}")
            if not list_get(thingsVisibleFlag, thingIndex, False):
                continue
            if thingIndex not in visibleThingsByTrigger:
                # print("removed thing by trigger:", i)
                continue
            if thingIndex in (BROKEN_THINGS.get((gameType, mapIndex)) or []):
                continue
            if gameType == GameType.L3D and thingIndex in (64, 65): # explosion sprites for RPG
                continue
            if thingIndex >= 0 and thingIndex < NPC_LAST_IDX:
                category = ThingCategory.NPC
            elif thingIndex >= NPC_LAST_IDX and thingIndex < LAMP_LAST_IDX:
                category = ThingCategory.LAMP
            elif thingIndex >= LAMP_LAST_IDX and thingIndex < DECORATION_LAST_IDX:
                category = ThingCategory.DECORATION
            else:
                raise Exception("Can't be here")

            if thingIndex >= len(thingsSpecials):
                special = None
            else:
                special = thingsSpecials[thingIndex]

            sprite = None
            spriteFix = SPRITE_INDEX_FIXES.get((gameType, mapIndex), {}).get(thingsSprites[thingIndex])
            if spriteFix is not None:
                sprite = spriteFix
            else:
                mapWideFix = MAP_WIDE_SPRITE_INDEX_FIXES.get((gameType, mapIndex))
                if mapWideFix:
                    if thingsSprites[thingIndex] > mapWideFix.threshold:
                        sprite = thingsSprites[thingIndex] - mapWideFix.threshold + mapWideFix.offset
            if not sprite:
                if category == ThingCategory.NPC:
                    sprite = thingsSprites[thingIndex]
                else:
                    if gameType == GameType.B3D:
                        sprite = thingsSprites[thingIndex] - 16
                    elif gameType == GameType.L3D:
                        sprite = thingsSprites[thingIndex] - 13
                    elif gameType == GameType.C3D:
                        sprite = thingsSprites[thingIndex] - 16
            self.things.append(ThingB3D(pos=Vertex(*thingsPos[thingIndex]), category=category,
                    color=thingsColors[thingIndex], special=special, sprite=sprite, index=thingIndex))


    def _applyMirroring(self, mirroringData: list[int]):
        for line, mirroring in zip(self.lines, mirroringData):
            needMirrorIdx = None
            if mirroring in [3, 15]:
                needMirrorIdx = 0
            if mirroring in [5, 10]:
                needMirrorIdx = 1
            if mirroring not in [0, 3, 5, 10, 15]:
                print(f"warning, unknown mirroring {mirroring} on line {self.lines.index(line)}")
            if needMirrorIdx is not None:
                if len(line.texturesNames) == 1:
                    while len(line.texturesNames) < 10:
                        line.texturesNames.append(line.texturesNames[0])
                textureName = line.texturesNames[needMirrorIdx]
                if textureName.startswith("NONE"):
                    print(f"*** warning, can't apply mirroring on {textureName}")
                    continue
                if textureName not in self.mirroredDict.keys():
                    mirroredName = generateTextureModifiedLumpName()
                    self.mirroredDict[textureName] = mirroredName
                    self.textures[mirroredName] = self.textures[textureName].transpose(Image.FLIP_LEFT_RIGHT)
                    self.textures[mirroredName].nonMirroredName = textureName
                line.texturesNames[needMirrorIdx] = self.mirroredDict[textureName]


    def _removeRepeatingTexturesTale(self):
        for line in self.lines:
            i = len(line.texturesNames) - 1
            while i > 0 and line.texturesNames[i] == line.texturesNames[i-1]:
                i -= 1
            line.texturesNames = line.texturesNames[:i+1]


    def _applyAnimation(self, animatedFramesList: list[list[list[int]]], animatedLinesList: list[list[int]],
                        textureMirroring: list[int]):
        self.animations: list[Animation] = []
        self.keyToAnimation: dict[tuple, Animation] = dict()
        for animatedFramesWall, animatedLines in zip(animatedFramesList, animatedLinesList):
            if not animatedFramesWall: continue
            for textureIndex, animatedFrames in enumerate(animatedFramesWall):
                if len(set(animatedFrames)) >= 2:
                    key = (tuple(animatedFrames))
                    if key not in self.keyToAnimation:
                        firstFrame = animatedFrames[0]

                        if firstFrame in ALT_TEXTURE_VARIANT.get((self.gameType, self.mapIndex), {}):
                            for animatedLineIdx in animatedLines:
                                self.lines[animatedLineIdx].texturesNames[textureIndex] = list(self.textures.keys())[firstFrame]
                            continue

                        frames: list[str] = []
                        duration = TEXTURE_INDEX_TO_ANIMATION_DURATIONS.get((self.gameType, self.mapIndex), {}).get(firstFrame)
                        if not duration:
                            if animatedFrames[-1] == animatedFrames[-2]:
                                duration = 4
                            else:
                                duration = 2
                            if self.gameType == GameType.L3D:
                                duration *= 2

                        if animatedFrames[-1] == animatedFrames[-2]:
                            animatedFrames = animatedFrames[:-1]
                        if self.gameType == GameType.L3D and self.mapIndex in (1, 2): # train
                            animatedFrames = animatedFrames * 2 + [animatedFrames[-1]] * 6

                        for frameIdx in animatedFrames:
                            if frameIdx >= len(list(self.textures.keys())):
                                frameIdx = 0
                            frameOldName = list(self.textures.keys())[frameIdx]
                            frameNewName = generateTextureModifiedLumpName()
                            self.textures[frameNewName] = self.textures[frameOldName]
                            frames.append(frameNewName)

                        animation = Animation(name=frames[0], frames=frames, duration=duration)

                        self.animations.append(animation)
                        self.keyToAnimation[key] = animation
                        if any([textureMirroring[x] == 5 for x in animatedLines]):
                            mirroredFrames = []
                            for frame in frames:
                                mirroredName = generateTextureModifiedLumpName()
                                self.mirroredDict[frame] = mirroredName
                                self.textures[mirroredName] = self.textures[frame].transpose(Image.FLIP_LEFT_RIGHT)
                                self.textures[mirroredName].nonMirroredName = frame
                                mirroredFrames.append(mirroredName)
                            self.animations.append(Animation(name=mirroredFrames[0], frames=mirroredFrames, duration=duration))
                    else:
                        animation = self.keyToAnimation[key]

                    for animatedLineIdx in animatedLines:
                        if len(self.lines[animatedLineIdx].texturesNames) == textureIndex:
                            self.lines[animatedLineIdx].texturesNames.append(None)
                        self.lines[animatedLineIdx].texturesNames[textureIndex] = animation.name
                elif len(set(animatedFrames)) == 1:
                    for animatedLineIdx in animatedLines:
                        if len(self.lines[animatedLineIdx].texturesNames) == textureIndex:
                            self.lines[animatedLineIdx].texturesNames.append(None)
                        self.lines[animatedLineIdx].texturesNames[textureIndex] = list(self.textures.keys())[animatedFrames[0]]
                else:
                    raise Exception("Empty animated frames")


    def _repeatShortTextures(self):
        for line in self.lines:
            newNames = []
            for name in line.texturesNames:
                if name in self.textures:
                    textureW = self.textures[name].width
                    number = math.floor(WALL_WIDTH/textureW)
                    newNames.extend([name]*number)
                else:
                    newNames.append(name)
            line.texturesNames = newNames


    def _initAltTextures(self):
        for textureIndex, altTextureRawData in ALT_TEXTURE_VARIANT.get((self.gameType, self.mapIndex), {}).items():
            textureName = list(self.textures.keys())[textureIndex]
            altTextureName = list(self.textures.keys())[altTextureRawData.index]
            if altTextureRawData.mirror and altTextureName not in self.mirroredDict.keys():
                mirroredName = generateTextureModifiedLumpName()
                self.mirroredDict[altTextureName] = mirroredName
                self.textures[mirroredName] = self.textures[altTextureName].transpose(Image.FLIP_LEFT_RIGHT)
                self.textures[mirroredName].nonMirroredName = altTextureName
                altTextureName = mirroredName
            self.altTextures[textureName] = AltTextureData(name=altTextureName, type=altTextureRawData.type)
            for animation in self.animations:
                if textureName in animation.frames:
                    self.altTextures[animation.name] = self.altTextures[textureName]

