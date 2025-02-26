from dataclasses import dataclass
from PIL import Image
from typing import Any
from ClassesShared import Vertex, HeightType, Animation
from tools import generateTextureLumpName, generateTextureMirroredLumpName
from enum import Enum


@dataclass
class CrateB3D:
    startLineIdx : int
    angle : int
    content : int
    textureName : str

@dataclass
class LineB3D:
    v1 : Vertex
    v2 : Vertex
    height : HeightType
    texturesNames : list[str]

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


class MapB3D:
    def __init__(self, rawLines: list[list[int]], rawHeight: list[int],
            cratesStartLineIdx: list[int], cratesContent: list[int], cratesAngles: list[int],
            textures: list[Image.Image], linesTextures: list[list[int]],
            circles: list[list[int]], textureMirroring: list[int],
            animatedFrames: list[list[int]], animatedLines: list[list[int]], sprites: list[list[Image.Image]],
            foeSprites: list[list[Image.Image]],
            thingsPos: list[list[int]], thingsSprites: list[int], thingsColors: list[int],
            thingsVisible: list[int], thingsSpecials: list[int],
    ):
        self.circles = circles

        self.textures: dict[str, Image.Image] = {}
        for texture in textures:
            self.textures[generateTextureLumpName()] = texture

        self.sprites = sprites
        self.foeSprites = foeSprites

        self.lines: list[LineB3D] = []

        for i in range(len(rawLines[0])):
            texturesNames: list[str] = []
            for index in linesTextures[i]:
                keys = list(self.textures.keys())
                if index >= len(keys):
                    texturesNames.append(f"NONE_{index}")
                else:
                    texturesNames.append(keys[index])

            self.lines.append(
                LineB3D(
                    v1=Vertex(rawLines[0][i], rawLines[1][i]),
                    v2=Vertex(rawLines[2][i], rawLines[3][i]),
                    height=HeightType(rawHeight[i]),
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
            ))

        self._removeRepeatingTexturesTale()
        self.mirroredDict = {}
        self._applyAnimation(animatedFrames, animatedLines, textureMirroring)
        self._applyMirroring(textureMirroring)

        self.things: list[ThingB3D] = []
        for i in range(48):
            if not thingsVisible[i]:
                continue
            if i >= 0 and i < 16:
                category = ThingCategory.NPC
            elif i >= 16 and i < 32:
                category = ThingCategory.LAMP
            elif i >= 32 and i < 48:
                category = ThingCategory.DECORATION
            else:
                raise Exception("Can't be here")

            if category == ThingCategory.DECORATION:
                special = None
            else:
                special = thingsSpecials[i]

            if category == ThingCategory.NPC:
                sprite = thingsSprites[i]
            else:
                sprite = thingsSprites[i] - 16

            self.things.append(ThingB3D(pos=Vertex(*thingsPos[i]), category=category,
                    color=thingsColors[i], special=special, sprite=sprite, index=i))




    def _applyMirroring(self, mirroringData: list[int]):
        for line, mirroring in zip(self.lines, mirroringData):
            needMirrorIdx = None
            if mirroring in [3, 15]:
                needMirrorIdx = 0
            if mirroring in [5, 10]:
                needMirrorIdx = 1
            if needMirrorIdx is not None:
                if len(line.texturesNames) == 1:
                    while len(line.texturesNames) < 10:
                        line.texturesNames.append(line.texturesNames[0])
                textureName = line.texturesNames[needMirrorIdx]
                if textureName not in self.mirroredDict.keys():
                    mirroredName = generateTextureMirroredLumpName()
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


    def _applyAnimation(self, animatedFramesList: list[list[int]], animatedLinesList: list[list[int]],
                        textureMirroring: list[int]):
        self.animations: list[Animation] = []
        for animatedFrames, animatedLines in zip(animatedFramesList, animatedLinesList):
            if not animatedFrames: continue
            frames: list[str] = []
            if animatedFrames[-1] == animatedFrames[-2]:
                animatedFrames = animatedFrames[:-1]
                duration = 4
            else:
                duration = 2
            for frameIdx in animatedFrames:
                frames.append(list(self.textures.keys())[frameIdx])
            animation = Animation(name=frames[0], frames=frames, duration=duration)
            self.animations.append(animation)
            if any([textureMirroring[x] == 5 for x in animatedLines]):
                mirroredFrames = []
                for frame in frames:
                    mirroredName = generateTextureMirroredLumpName()
                    self.mirroredDict[frame] = mirroredName
                    self.textures[mirroredName] = self.textures[frame].transpose(Image.FLIP_LEFT_RIGHT)
                    self.textures[mirroredName].nonMirroredName = frame
                    mirroredFrames.append(mirroredName)
                self.animations.append(Animation(name=mirroredFrames[0], frames=mirroredFrames, duration=duration))

            for animatedLineIdx in animatedLines:
                self.lines[animatedLineIdx].texturesNames = [animation.name]
