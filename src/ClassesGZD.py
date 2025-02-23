from dataclasses import dataclass
from enum import Enum
from typing import Any
from PIL import Image
from ClassesShared import HeightType, Vertex
from ClassesInterim import MapInterim, LineInterim, DoorInterim, TextureInterim
from actorsGeneration import ( generateSpriteName, generateDecorationClassName, generateDecorationZScript,
    generateEdnum,
)
from tools import LEVEL_CEILING, LEVEL_FLOOR, SCALE_FACTOR
from algebraFunctions import vertexWithOffset, segmentLength, findFourthVertex

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

@dataclass
class LineGZD:
    v1: int
    v2: int
    sideFrontIdx: int
    sideBackIdx: int|None = None
    polyObjectDef: PolObjectGZD|None = None
    b3dDoorSpeed: float = None
    b3dDoorBroken: bool = None
    b3dDoorPONum: int = None
    b3dDoorPOx: float = None
    b3dDoorPOy: float = None
    b3dDoorBackSide: bool = None
    b3dDoorPOMirrorNum: bool = None


@dataclass
class ThingGZD:
    x: int
    y: int
    type: int
    angle: int


@dataclass
class EdnumGZD:
    num: int
    className: str


@dataclass
class ActorGZD:
    ednum: EdnumGZD
    zscript: str


class MapGZD:
    SECTOR_FULL_IDX = 0
    SECTOR_BOTTOM_IDX = 1

    def __init__(self, mapInterim: MapInterim, spawnPos: list[int], spawnAngle: int):
        self.vertexes: list[VertexGZD] = []
        self.sectorFull: SectorGZD = None
        self.sectorBottom: SectorGZD = None
        self.sectors: list[SectorGZD] = []
        self.sides: list[SideGZD] = []
        self.lines: list[LineGZD] = []
        self.things: list[ThingGZD] = []
        self.actors: list[ActorGZD] = []
        self._lastPolyObjectNum = 0

        self.sectorFull = SectorGZD(heightFloor=LEVEL_FLOOR, heightCeiling=LEVEL_CEILING)
        self.sectorBottom = SectorGZD(heightFloor=(LEVEL_CEILING+LEVEL_FLOOR)//2, heightCeiling=LEVEL_CEILING)
        self.sectors.extend([self.sectorFull, self.sectorBottom])

        self.lines.extend(self._convertLines(mapInterim.lines))
        self._convertDoors(mapInterim.doors)

        self.things.append(ThingGZD(spawnPos[0], spawnPos[1], 1, spawnAngle+90)) # starting pos

        self.sprites: dict[str, Image.Image] = {}
        self._keysToActor: dict[tuple[int], ActorGZD] = dict()
        for decoration in mapInterim.decorations:
            key = (decoration.spriteIdx, decoration.colorIdx)
            if key not in self._keysToActor:
                spriteName = generateSpriteName()
                className = generateDecorationClassName()
                sprite = mapInterim.sprites[decoration.colorIdx][decoration.spriteIdx]
                zscript = generateDecorationZScript(className, spriteName, sprite)
                ednum = EdnumGZD(num=generateEdnum(), className=className)
                spriteFileName = spriteName + "A0"
                self.sprites[spriteFileName] = sprite
                self.actors.append(ActorGZD(ednum=ednum, zscript=zscript))
                self._keysToActor[key] = self.actors[-1]
            self.things.append(ThingGZD(
                x = decoration.pos.x,
                y = decoration.pos.y,
                type = self._keysToActor[key].ednum.num,
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

    def _convertDoors(self, doors: list[DoorInterim]):
        prevLines: list[LineGZD] = None
        prevDoorPolyObjectDef: PolObjectGZD = None

        for i in range(len(doors)):
            doorB3D = doors[i]
            prevDoorB3D = doors[i-1] if i > 0 else None
            polyObjectDef = self._genNewPolyObject()

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


    def _convertLines(self, liesInterim: list[LineInterim], forcedSector: int|None = None):
        linesGZD: list[LineGZD] = []
        for line in liesInterim:
            v1Idx = self._addVertex(*line.v1.pair())
            v2Idx = self._addVertex(*line.v2.pair())
            sideFrontIdx = None
            sideBackIdx = None
            if line.height == HeightType.FULL:
                sector = forcedSector if forcedSector is not None else self.SECTOR_FULL_IDX
                sideFrontIdx = self._addSide(sector, TextureMode.MIDDLE, line.texture.names[0], line.texture.offset)
            elif line.height == HeightType.BOTTOM:
                sideFrontIdx = self._addSide(self.SECTOR_FULL_IDX, TextureMode.TOP_AND_BOTTOM, line.texture.names[0], line.texture.offset)
                sideBackIdx = self._addSide(self.SECTOR_BOTTOM_IDX, TextureMode.NO_TEXTURES, None, None)
            elif line.height == HeightType.TOP:
                sideFrontIdx = self._addSide(self.SECTOR_BOTTOM_IDX, TextureMode.MIDDLE, line.texture.names[0], line.texture.offset)
            linesGZD.append(LineGZD(v1=v1Idx, v2=v2Idx,
                                      sideFrontIdx=sideFrontIdx, sideBackIdx=sideBackIdx))
        return linesGZD

    def _addVertex(self, x, y) -> int:
        newVertex = VertexGZD(x=float(x), y=float(y))
        for i in range(len(self.vertexes)):
            if self.vertexes[i] == newVertex:
                return i
        self.vertexes.append(newVertex)
        return len(self.vertexes) - 1

    def _addSide(self, sectorIdx: int, mode: TextureMode, texture: str, offset: float):
        if texture is None:
            texture = "NONE"
        newSide = SideGZD(sectorIdx=sectorIdx, mode=mode, offset=offset)
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

    def _genNewPolyObject(self):
        self._lastPolyObjectNum += 1
        return PolObjectGZD(number=self._lastPolyObjectNum)