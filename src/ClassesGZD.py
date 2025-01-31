from dataclasses import dataclass
from enum import Enum
from typing import Any
from ClassesShared import HeightType
from ClassesInterim import MapInterim, LineInterim
from tools import LEVEL_CEILING, LEVEL_FLOOR, SCALE_FACTOR

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
    mirror: int = None

@dataclass
class LineGZD:
    v1: int
    v2: int
    sideFrontIdx: int
    sideBackIdx: int|None = None
    polyObjectDef: PolObjectGZD|None = None
    b3dDoorSpeed: float = None
    b3dDoorBroken: bool = None
    b3dDoorPOStartLine: int = None


@dataclass
class ThingGZD:
    x: int
    y: int
    type: int


class MapGZD:
    SECTOR_FULL_IDX = 0
    SECTOR_BOTTOM_IDX = 1

    def __init__(self, mapInterim: MapInterim):
        self.vertexes: list[VertexGZD] = []
        self.sectorFull: SectorGZD = None
        self.sectorBottom: SectorGZD = None
        self.sides: list[SideGZD] = []
        self.lines: list[LineGZD] = []
        self.things: list[ThingGZD] = []
        self._lastPolyObjectNum = 0

        self.sectorFull = SectorGZD(heightFloor=LEVEL_FLOOR, heightCeiling=LEVEL_CEILING)
        self.sectorBottom = SectorGZD(heightFloor=(LEVEL_CEILING+LEVEL_FLOOR)//2, heightCeiling=LEVEL_CEILING)

        self.lines.extend(self._convertLines(mapInterim.lines))

        prevDoorPolyObjectDef: PolObjectGZD = None
        for i in range(len(mapInterim.doors)):
            doorB3D = mapInterim.doors[i]
            prevDoorB3D = mapInterim.doors[i-1] if i > 0 else None
            lines = self._convertLines(doorB3D.lines)
            lines[0].polyObjectDef = self._genNewPolyObject()
            for line in (lines[0], lines[2]):
                line.b3dDoorBroken = False
                if doorB3D.speed == -1:
                    line.b3dDoorSpeed = 0.0
                elif doorB3D.speed == 8:
                    line.b3dDoorSpeed = 2.0
                elif doorB3D.speed == 24:
                    line.b3dDoorSpeed = 1.0
                elif doorB3D.speed == 2:
                    line.b3dDoorSpeed = 2.0
                    line.b3dDoorBroken = True
                else:
                    print("warning: unknown door speed", doorB3D.speed)
                    break
                line.b3dDoorPOStartLine = len(self.lines)
            self.things.append(ThingGZD(type=9300,
                x = (self.vertexes[lines[0].v1].x + self.vertexes[lines[2].v1].x) // 2,
                y = (self.vertexes[lines[0].v1].y + self.vertexes[lines[2].v1].y) // 2,
            ))
            if prevDoorB3D and prevDoorB3D.lines[1].v1 == doorB3D.lines[1].v2 and prevDoorB3D.lines[1].v2 == doorB3D.lines[1].v1:
                prevDoorPolyObjectDef.mirror = lines[0].polyObjectDef.number
                lines[0].polyObjectDef.mirror = prevDoorPolyObjectDef.number
            prevDoorPolyObjectDef = lines[0].polyObjectDef
            self.lines.extend(lines)

        self.things.append(ThingGZD(0, 0, 1)) # starting pos

        for i in range(len(self.vertexes)):
            self.vertexes[i].x *= SCALE_FACTOR
            self.vertexes[i].y *= SCALE_FACTOR

        for i in range(len(self.things)):
            self.things[i].x *= SCALE_FACTOR
            self.things[i].y *= SCALE_FACTOR


    def _convertLines(self, liesInterim: list[LineInterim]):
        linesGZD: list[LineGZD] = []
        for line in liesInterim:
            v1Idx = self._addVertex(*line.v1.pair())
            v2Idx = self._addVertex(*line.v2.pair())
            sideFrontIdx = None
            sideBackIdx = None
            if line.height == HeightType.FULL:
                sideFrontIdx = self._addSide(self.SECTOR_FULL_IDX, TextureMode.MIDDLE, line.texture.names[0], line.texture.offset)
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