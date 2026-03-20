from dataclasses import dataclass
from enum import Enum
from typing import Any
from PIL import Image
from ClassesShared import HeightType, GameType
from ClassesIntermedial import MapIntermedial, LineIntermedial, DoorIntermedial
from actorsGeneration import ( generateDecorationSpriteName, generateDecorationClassName, generateDecorationZScript,
    generateEdnum, generateLampSpriteName, generateLampClassName, generateLampZScript, generateFoeClassName,
    generateFoeSpriteName, generateFoeZScript, generateFoeTexturesDef, generateFriendlyClassName, generateFriendlyZScript,
    generateNpcSpriteName, generateCrateClassName, generateCrateSpriteName, generateCrateZScript, generateCrateModeldef,
    generateCrateObj, generateModelReplacementTextureDef, generateGenericPatchTextureDef, generateBarrelSpriteName,
    generateBarrelClassName, generateBarrelModeldef, generateBarrelObj, generateBarrelZScript,
)
from tools import LEVEL_CEILING, LEVEL_FLOOR, SCALE_FACTOR
from fixes import CRATE_TOP_TEXTURES, SPRITE_SCALE_OVERRIDE, NO_LAMP_LIGHT_SPOT_LEVELS, BARREL_TOP_TEXTURES

@dataclass
class SectorGZD:
    heightFloor: int
    heightCeiling: int

class TextureMode(Enum):
    MIDDLE = 0
    TOP_AND_BOTTOM = 1
    NO_TEXTURES = 2

@dataclass
class SideGZD:
    sectorIdx: int
    mode: TextureMode
    offset: float
    stretch: float
    textureTop: str = None
    textureBottom: str = None
    textureMiddle: str = None

@dataclass
class VertexGZD:
    x: float
    y: float

@dataclass
class PolObjectGZD:
    number: int
    soundSeq: int

@dataclass
class LineGZD:
    v1: int
    v2: int
    sideFrontIdx: int
    sideBackIdx: int|None = None
    doNotPeg: bool = False
    polyObjectDef: PolObjectGZD|None = None
    b3dDoorSpeed: float = None
    b3dDoorBroken: bool = None
    b3dDoorPONum: int = None
    b3dDoorPOx: float = None
    b3dDoorPOy: float = None
    b3dDoorBackSide: bool = None
    b3dDoorPOMirrorNum: bool = None
    b3dAltTextureName: str = None
    b3dAltTextureType: str = None


@dataclass
class ThingGZD:
    x: int
    y: int
    type: int
    angle: int
    arg0: int|None = None
    arg1: int|None = None


@dataclass
class EdnumGZD:
    num: int
    className: str


@dataclass
class ActorGZD:
    ednum: EdnumGZD
    zscript: str


@dataclass
class ModelGZD:
    modelPath: str
    modelObj: str
    modelDef: str


class MapGZD:
    SECTOR_FULL_IDX = 0
    SECTOR_ONLY_BOTTOM_IDX = 1
    SECTOR_ONLY_TOP_IDX = 2

    def __init__(self, mapIntermedial: MapIntermedial, spawnPos: list[int], spawnAngle: int, mapIndex: int, gameType: GameType):
        self.vertexes: list[VertexGZD] = []
        self.sectorFull: SectorGZD = None
        self.sectorBottom: SectorGZD = None
        self.sectors: list[SectorGZD] = []
        self.sides: list[SideGZD] = []
        self.lines: list[LineGZD] = []
        self.things: list[ThingGZD] = []
        self.actors: list[ActorGZD] = []
        self.models: list[ModelGZD] = []
        self._lastPolyObjectNum = 0

        self.sectorFull = SectorGZD(heightFloor=LEVEL_FLOOR, heightCeiling=LEVEL_CEILING)
        self.sectorOnlyBottom = SectorGZD(heightFloor=(LEVEL_CEILING+LEVEL_FLOOR)//2, heightCeiling=LEVEL_CEILING)
        self.sectorOnlyTop = SectorGZD(heightFloor=0, heightCeiling=(LEVEL_CEILING+LEVEL_FLOOR)//2)
        self.sectors.extend([self.sectorFull, self.sectorOnlyBottom, self.sectorOnlyTop])

        self.altTextures = mapIntermedial.altTextures
        self.lines.extend(self._convertLines(mapIntermedial.lines))
        self._convertDoors(mapIntermedial.doors)

        self.things.append(ThingGZD(spawnPos[0], spawnPos[1], 1, spawnAngle+90)) # starting pos

        self.sprites: dict[str, Image.Image] = {}
        self.patches: dict[str, Image.Image] = {}
        self.texturesDefs: dict[str, str] = dict()
        self.texturesDefs2x: dict[str, str] = dict()

        self._keysToDecoration: dict[tuple[int], ActorGZD] = dict()
        for decoration in mapIntermedial.decorations:
            key = (decoration.spriteIdx, decoration.colorIdx)
            if key not in self._keysToDecoration:
                spriteName = generateDecorationSpriteName()
                className = generateDecorationClassName()
                if decoration.spriteIdx >= 0:
                    sprite = mapIntermedial.sprites[decoration.colorIdx][decoration.spriteIdx]
                    scaleOverrideFix = SPRITE_SCALE_OVERRIDE.get((gameType, mapIndex, decoration.spriteIdx))
                else:
                    sprite = mapIntermedial.foeSprites[decoration.colorIdx][decoration.spriteIdx]
                    scaleOverrideFix = 1.3
                zscript = generateDecorationZScript(className, spriteName, sprite, scaleOverrideFix)
                ednum = EdnumGZD(num=generateEdnum(), className=className)
                self.sprites[spriteName + "A0"] = sprite
                self.actors.append(ActorGZD(ednum=ednum, zscript=zscript))
                self._keysToDecoration[key] = self.actors[-1]
            self.things.append(ThingGZD(
                x = decoration.pos.x,
                y = decoration.pos.y,
                type = self._keysToDecoration[key].ednum.num,
                angle = 0,
            ))

        self._keysToLamp: dict[tuple[int], ActorGZD] = dict()
        for lamp in mapIntermedial.lamps:
            key = (lamp.spriteIdx, lamp.colorIdx)
            if key not in self._keysToLamp:
                spriteName = generateLampSpriteName()
                className = generateLampClassName()
                spriteA = mapIntermedial.sprites[lamp.colorIdx][lamp.spriteIdx]
                spriteB = mapIntermedial.sprites[lamp.colorIdx][lamp.spriteIdx+1]
                spriteC = mapIntermedial.sprites[lamp.colorIdx][lamp.spriteIdx+2]
                scaleOverrideFix = SPRITE_SCALE_OVERRIDE.get((gameType, mapIndex, lamp.spriteIdx))
                isFloor = False
                if gameType == GameType.L3D and mapIndex == 9:
                    isFloor = True
                needLightSpot = not isFloor and ((gameType, mapIndex) not in NO_LAMP_LIGHT_SPOT_LEVELS)
                zscript = generateLampZScript(className, spriteName, spriteA, scaleOverrideFix, isFloor, needLightSpot)
                ednum = EdnumGZD(num=generateEdnum(), className=className)
                self.sprites[spriteName + "A0"] = spriteA
                self.sprites[spriteName + "B0"] = spriteB
                self.sprites[spriteName + "C0"] = spriteC
                self.actors.append(ActorGZD(ednum=ednum, zscript=zscript))
                self._keysToLamp[key] = self.actors[-1]
            self.things.append(ThingGZD(
                x = lamp.pos.x,
                y = lamp.pos.y,
                type = self._keysToLamp[key].ednum.num,
                angle = 0,
                arg0 = lamp.special.value,
            ))

        self._keysToFoe: dict[tuple[int], ActorGZD] = dict()
        for foe in mapIntermedial.foes:
            key = (foe.colorIdx)
            if key not in self._keysToFoe:
                spriteName = generateFoeSpriteName()
                className = generateFoeClassName()
                ednum = EdnumGZD(num=generateEdnum(), className=className)
                patches_names = ["A_front", "B_front", "A_left", "B_left", "A_back", "B_back",
                                "A_right", "B_right"]
                sprite_names = ["C0", "D0", "E0", "F0", "G0", "H0", "I0", "J0"]
                for i, name in enumerate(patches_names):
                    patchName = spriteName + name
                    patch = mapIntermedial.foeSprites[foe.colorIdx][i]
                    self.patches[patchName] = patch
                    if name.startswith('A'):
                        texturesName = spriteName+'A'
                    else:
                        texturesName = spriteName+'B'
                    if texturesName not in self.texturesDefs:
                        self.texturesDefs[texturesName] = ""
                        self.texturesDefs2x[texturesName] = ""
                    self.texturesDefs[texturesName] += generateFoeTexturesDef(patchName, patch, mapIndex, gameType, False) + '\n'
                    self.texturesDefs2x[texturesName] += generateFoeTexturesDef(patchName, patch, mapIndex, gameType, True) + '\n'
                for i, name in enumerate(sprite_names):
                    if gameType == GameType.L3D and i >= 5:
                        self.sprites[spriteName+name] = mapIntermedial.sprites[foe.colorIdx][11+i-5]
                    else:
                        self.sprites[spriteName+name] = mapIntermedial.foeSprites[foe.colorIdx][len(patches_names)+i]
                zscript = generateFoeZScript(className, spriteName, self.sprites[spriteName+"C0"], self.sprites[spriteName+"G0"])
                self.actors.append(ActorGZD(ednum=ednum, zscript=zscript))
                self._keysToFoe[key] = self.actors[-1]
            self.things.append(ThingGZD(
                x = foe.pos.x,
                y = foe.pos.y,
                type = self._keysToFoe[key].ednum.num,
                angle = (foe.angle+90)%360,
                arg0 = foe.walkDistance,
                arg1 = foe.health,
            ))

        self._keysToFriendly: dict[tuple[int], ActorGZD] = dict()
        for friendly in mapIntermedial.friendlies:
            key = (friendly.spriteIdx, friendly.colorIdx, friendly.isSecond)
            if key not in self._keysToFriendly:
                spriteName = generateNpcSpriteName()
                className = generateFriendlyClassName()
                if not friendly.isSecond:
                    spriteA = mapIntermedial.sprites[friendly.colorIdx][friendly.spriteIdx]
                    spriteB = mapIntermedial.sprites[friendly.colorIdx][friendly.spriteIdx+1]
                else:
                    spriteA = mapIntermedial.sprites[friendly.colorIdx][friendly.spriteIdx+4]
                    spriteB = mapIntermedial.sprites[friendly.colorIdx][friendly.spriteIdx+5]
                spriteC = mapIntermedial.sprites[friendly.colorIdx][friendly.spriteIdx+2]
                spriteD = mapIntermedial.sprites[friendly.colorIdx][friendly.spriteIdx+3]
                scaleOverrideFix = SPRITE_SCALE_OVERRIDE.get((gameType, mapIndex, friendly.spriteIdx))
                zscript = generateFriendlyZScript(className, spriteName, spriteA, spriteD, scaleOverrideFix)
                ednum = EdnumGZD(num=generateEdnum(), className=className)
                self.sprites[spriteName+"A0"] = spriteA
                self.sprites[spriteName+"B0"] = spriteB
                self.sprites[spriteName+"C0"] = spriteC
                self.sprites[spriteName+"D0"] = spriteD
                self.actors.append(ActorGZD(ednum=ednum, zscript=zscript))
                self._keysToFriendly[key] = self.actors[-1]
            self.things.append(ThingGZD(
                x = friendly.pos.x,
                y = friendly.pos.y,
                type = self._keysToFriendly[key].ednum.num,
                angle = 0,
            ))


        self._keysToCratesFrames: set[tuple[int]] = set()
        def getPatchBaseName(colorIdx):
            return f"crate_color_{colorIdx}"
        for crate in mapIntermedial.crates:
            key = (crate.spriteIdx, crate.colorIdx)
            if key not in self._keysToCratesFrames:
                patchNameBase = getPatchBaseName(crate.colorIdx)
                self.patches[patchNameBase+"_frame_B"] = mapIntermedial.sprites[crate.colorIdx][crate.spriteIdx+1]
                self.patches[patchNameBase+"_frame_C"] = mapIntermedial.sprites[crate.colorIdx][crate.spriteIdx+2]
                self.patches[patchNameBase+"_frame_D"] = mapIntermedial.sprites[crate.colorIdx][crate.spriteIdx+3] # None
                self.patches[patchNameBase+"_frame_E"] = mapIntermedial.sprites[crate.colorIdx][crate.spriteIdx+4] # Ammo
                self.patches[patchNameBase+"_frame_F"] = mapIntermedial.sprites[crate.colorIdx][crate.spriteIdx+5] # Health
                self.patches[patchNameBase+"_frame_G"] = mapIntermedial.sprites[crate.colorIdx][crate.spriteIdx+6] # Both
                if gameType != GameType.B3D:
                    self.patches[patchNameBase+"_frame_H"] = mapIntermedial.sprites[crate.colorIdx][crate.spriteIdx+7] # Alt Ammo
                self._keysToCratesFrames.add(key)

        self._keysToCrates: dict[tuple[int], ActorGZD] = dict()
        for crate in mapIntermedial.crates:
            key = (crate.spriteIdx, crate.colorIdx, crate.textureName)
            if key not in self._keysToCrates:
                spriteName = generateCrateSpriteName()
                className = generateCrateClassName()
                zscript = generateCrateZScript(className, spriteName)
                ednum = EdnumGZD(num=generateEdnum(), className=className)
                modelPath = f"models/{spriteName}A0.obj"
                model = ModelGZD(
                    modelPath=modelPath,
                    modelObj=generateCrateObj(crate.textureName, CRATE_TOP_TEXTURES[gameType][mapIndex][crate.topTextureIndex]),
                    modelDef=generateCrateModeldef(spriteName, className, modelPath),
                )
                self.models.append(model)
                textureDef = generateModelReplacementTextureDef(spriteName+"A0", crate.textureName,
                        mapIntermedial.textures[crate.textureName], mapIndex, gameType) + "\n"
                textureDef2x = ""
                patchNameBase = getPatchBaseName(crate.colorIdx)
                frameLetters = ['B', 'C', 'D', "E", "F", "G"]
                if gameType != GameType.B3D: frameLetters.append('H')
                for frameLetter in frameLetters:
                    patchName = patchNameBase + "_frame_" + frameLetter
                    spriteNameFull = spriteName + frameLetter + "0"
                    patch = self.patches[patchName]
                    textureDef += generateGenericPatchTextureDef(patchName, spriteNameFull, patch, mapIndex, gameType, False) + "\n"
                    textureDef2x += generateGenericPatchTextureDef(patchName, spriteNameFull, patch, mapIndex, gameType, True) + "\n"
                self.texturesDefs[spriteName] = textureDef
                self.texturesDefs2x[spriteName] = textureDef2x
                self.actors.append(ActorGZD(ednum=ednum, zscript=zscript))
                self._keysToCrates[key] = self.actors[-1]
            self.things.append(ThingGZD(
                x = crate.pos.x,
                y = crate.pos.y,
                type = self._keysToCrates[key].ednum.num,
                angle = crate.angle,
                arg0=crate.content.value,
            ))

        self._keysToBarrels: dict[tuple[int], ActorGZD] = dict()
        for barrel in mapIntermedial.barrels:
            key = (barrel.textureName)
            if key not in self._keysToBarrels:
                spriteName = generateBarrelSpriteName()
                className = generateBarrelClassName()
                zscript = generateBarrelZScript(className, spriteName)
                ednum = EdnumGZD(num=generateEdnum(), className=className)
                modelPath = f"models/{spriteName}A0.obj"
                model = ModelGZD(
                    modelPath=modelPath,
                    modelObj=generateBarrelObj(barrel.textureName, BARREL_TOP_TEXTURES[(gameType, mapIndex)]),
                    modelDef=generateBarrelModeldef(spriteName, className, modelPath),
                )
                self.models.append(model)
                textureDef = generateModelReplacementTextureDef(spriteName+"A0", barrel.textureName,
                        mapIntermedial.textures[barrel.textureName], mapIndex, gameType) + "\n"
                self.texturesDefs[spriteName] = textureDef
                self.actors.append(ActorGZD(ednum=ednum, zscript=zscript))
                self._keysToBarrels[key] = self.actors[-1]
            self.things.append(ThingGZD(
                x = barrel.pos.x,
                y = barrel.pos.y,
                type = self._keysToBarrels[key].ednum.num,
                angle = 0,
            ))


        for i in range(len(self.vertexes)):
            self.vertexes[i].x *= SCALE_FACTOR
            self.vertexes[i].y *= SCALE_FACTOR

        for i in range(len(self.things)):
            self.things[i].x *= SCALE_FACTOR
            self.things[i].y *= SCALE_FACTOR


    def _genPOSector(self):
        self.sectors.append(SectorGZD(heightCeiling=LEVEL_CEILING, heightFloor=LEVEL_FLOOR))
        return len(self.sectors) - 1

    def _convertDoors(self, doors: list[DoorIntermedial]):
        prevLines: list[LineGZD] = None
        prevDoorPolyObjectDef: PolObjectGZD = None

        for i in range(len(doors)):
            doorB3D = doors[i]
            prevDoorB3D = doors[i-1] if i > 0 else None
            polyObjectDef = self._genNewPolyObject(doorB3D.speed)

            startingSpot = ThingGZD(type=9301,
                x = doorB3D.startingSpot.x,
                y = doorB3D.startingSpot.y,
                angle=polyObjectDef.number,
            )
            self.things.append(startingSpot)

            poSector = self._genPOSector()
            lines = self._convertLines(doorB3D.lines, forcedSector=poSector)
            lines[0].polyObjectDef = polyObjectDef
            boxLines = self._convertLines(doorB3D.boxLines, forcedSector=poSector)

            for line in (lines[0], lines[2]):
                line.b3dDoorBroken = False
                if doorB3D.speed == -1:
                    line.b3dDoorSpeed = 0.0
                elif doorB3D.speed == 8:
                    line.b3dDoorSpeed = 25.4
                elif doorB3D.speed == 2:
                    line.b3dDoorSpeed = 25.4
                    line.b3dDoorBroken = True
                elif doorB3D.speed == 24:
                    line.b3dDoorSpeed = 5.7
                else:
                    print("warning: unknown door speed", doorB3D.speed)
                    break
                line.b3dDoorPONum = polyObjectDef.number
                line.b3dDoorPOx = startingSpot.x * SCALE_FACTOR
                line.b3dDoorPOy = startingSpot.y * SCALE_FACTOR
            lines[2].b3dDoorBackSide = True

            self.things.append(ThingGZD(type=9300, # anchor
                x = (self.vertexes[lines[0].v1].x + self.vertexes[lines[2].v1].x) // 2,
                y = (self.vertexes[lines[0].v1].y + self.vertexes[lines[2].v1].y) // 2,
                angle=polyObjectDef.number,
            ))

            if prevDoorB3D and prevDoorB3D.nextIsMirror:
                for line in lines:
                    line.b3dDoorPOMirrorNum = prevDoorPolyObjectDef.number
                for prevLine in prevLines:
                    prevLine.b3dDoorPOMirrorNum = polyObjectDef.number
            prevLines = lines
            prevDoorPolyObjectDef = polyObjectDef
            self.lines.extend(lines)
            self.lines.extend(boxLines)


    def _convertLines(self, liesIntermedial: list[LineIntermedial], forcedSector: int|None = None):
        linesGZD: list[LineGZD] = []
        for line in liesIntermedial:
            v1Idx = self._addVertex(*line.v1.pair())
            v2Idx = self._addVertex(*line.v2.pair())
            sideFrontIdx = None
            sideBackIdx = None
            doNotPeg = False
            texture = line.texture.names[0]
            _altTexture = self.altTextures.get(texture)
            altTextureName = None
            altTextureType = None
            if _altTexture:
                altTextureName = _altTexture.name
                altTextureType = _altTexture.type.value
            if line.height == HeightType.FULL:
                sector = forcedSector if forcedSector is not None else self.SECTOR_FULL_IDX
                sideFrontIdx = self._addSide(sector, TextureMode.MIDDLE, texture, line.texture.offset, line.texture.stretch)
            elif line.height == HeightType.ONLY_BOTTOM:
                sideFrontIdx = self._addSide(self.SECTOR_FULL_IDX, TextureMode.TOP_AND_BOTTOM, texture, line.texture.offset, line.texture.stretch)
                sideBackIdx = self._addSide(self.SECTOR_ONLY_BOTTOM_IDX, TextureMode.NO_TEXTURES, None, None, 1.0)
            elif line.height == HeightType.ONLY_TOP:
                sideFrontIdx = self._addSide(self.SECTOR_FULL_IDX, TextureMode.TOP_AND_BOTTOM, texture, line.texture.offset, line.texture.stretch)
                sideBackIdx = self._addSide(self.SECTOR_ONLY_TOP_IDX, TextureMode.NO_TEXTURES, None, None, 1.0)
                doNotPeg = True
            elif line.height == HeightType.BOTTOM:
                sideFrontIdx = self._addSide(self.SECTOR_ONLY_TOP_IDX, TextureMode.MIDDLE, texture, line.texture.offset, line.texture.stretch)
                doNotPeg = True
            elif line.height == HeightType.TOP:
                sideFrontIdx = self._addSide(self.SECTOR_ONLY_BOTTOM_IDX, TextureMode.MIDDLE, texture, line.texture.offset, line.texture.stretch)
            linesGZD.append(LineGZD(v1=v1Idx, v2=v2Idx, doNotPeg=doNotPeg, b3dAltTextureName=altTextureName, b3dAltTextureType=altTextureType,
                                      sideFrontIdx=sideFrontIdx, sideBackIdx=sideBackIdx))
        return linesGZD

    def _addVertex(self, x, y) -> int:
        newVertex = VertexGZD(x=float(x), y=float(y))
        for i in range(len(self.vertexes)):
            if self.vertexes[i] == newVertex:
                return i
        self.vertexes.append(newVertex)
        return len(self.vertexes) - 1

    def _addSide(self, sectorIdx: int, mode: TextureMode, texture: str, offset: float, stretch: float):
        if texture is None:
            texture = "NONE"
        newSide = SideGZD(sectorIdx=sectorIdx, mode=mode, offset=offset, stretch=stretch)
        if mode == TextureMode.MIDDLE:
            newSide.textureMiddle = texture
        elif mode == TextureMode.TOP_AND_BOTTOM:
            newSide.textureBottom = texture
            newSide.textureTop = texture
        for i in range(len(self.sides)):
            side = self.sides[i]
            if side == newSide:
                return i

        self.sides.append(newSide)
        return len(self.sides) - 1

    def _genNewPolyObject(self, speed: int):
        self._lastPolyObjectNum += 1
        soundSeq = 0
        if speed == 24:
            soundSeq = 1
        return PolObjectGZD(number=self._lastPolyObjectNum, soundSeq=soundSeq)


