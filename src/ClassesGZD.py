from dataclasses import dataclass
from enum import Enum
from typing import Any
from ClassesShared import HeightType
from ClassesInterim import MapInterim

LEVEL_FLOOR = 0.0
LEVEL_CEILING = 96.0
SCALE_FACTOR = 96 / 65536

@dataclass
class SectorGZD:
    heightFloor: float
    heightCeiling: float

class TextureMode(Enum):
    MIDDLE = 0
    TOP_AND_BOTTOM = 1
    NO_TEXTURES = 2

@dataclass
class SideGZD:
    sectorIdx: int
    mode: TextureMode
    textureTop: Any = None
    textureBottom: Any = None
    textureMiddle: Any = None

@dataclass
class VertexGZD:
    x: float
    y: float

@dataclass
class LineGZD:
    vertexStartIdx: int
    vertexEndIdx: int
    sideFrontIdx: int
    sideBackIdx: int|None = None


class MapGZD:
    SECTOR_FULL_IDX = 0
    SECTOR_BOTTOM_IDX = 1

    def __init__(self, mapInterim: MapInterim, startPos: tuple[int]):
        self.vertexes: list[VertexGZD] = []
        self.sectorFull: SectorGZD = None
        self.sectorBottom: SectorGZD = None
        self.sides: list[SideGZD] = []
        self.lines: list[LineGZD] = []

        self.sectorFull = SectorGZD(heightFloor=LEVEL_FLOOR, heightCeiling=LEVEL_CEILING)
        self.sectorBottom = SectorGZD(heightFloor=(LEVEL_CEILING+LEVEL_FLOOR)/2, heightCeiling=LEVEL_CEILING)

        for line in mapInterim.lines:
            v1Idx = self._addVertex(*line.v1.pair())
            v2Idx = self._addVertex(*line.v2.pair())
            sideFrontIdx = None
            sideBackIdx = None
            if line.height == HeightType.FULL:
                sideFrontIdx = self._addSide(self.SECTOR_FULL_IDX, TextureMode.MIDDLE)
            elif line.height == HeightType.BOTTOM:
                sideFrontIdx = self._addSide(self.SECTOR_FULL_IDX, TextureMode.TOP_AND_BOTTOM)
                sideBackIdx = self._addSide(self.SECTOR_BOTTOM_IDX, TextureMode.NO_TEXTURES)
            elif line.height == HeightType.TOP:
                sideFrontIdx = self._addSide(self.SECTOR_BOTTOM_IDX, TextureMode.MIDDLE)
            self.lines.append(LineGZD(vertexStartIdx=v1Idx, vertexEndIdx=v2Idx,
                                      sideFrontIdx=sideFrontIdx, sideBackIdx=sideBackIdx))

        for i in range(len(self.vertexes)):
            self.vertexes[i].x *= SCALE_FACTOR
            self.vertexes[i].y *= SCALE_FACTOR

        self.startPos = (startPos[0] * SCALE_FACTOR, startPos[1] * SCALE_FACTOR)


    def _addVertex(self, x, y) -> int:
        x = float(x)
        y = float(y)
        for i in range(len(self.vertexes)):
            if self.vertexes[i].x == x and self.vertexes[i].y == y:
                return i
        self.vertexes.append(VertexGZD(x=x, y=y))
        return len(self.vertexes) - 1

    def _addSide(self, sectorIdx: int, mode: TextureMode):
        for i in range(len(self.sides)):
            side = self.sides[i]
            if side.sectorIdx == sectorIdx and side.mode == mode:
                return i

        self.sides.append(SideGZD(sectorIdx=sectorIdx, mode=mode))
        return len(self.sides) - 1
