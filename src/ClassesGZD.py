from dataclasses import dataclass
from typing import Any
from ClassesShared import HeightType
from ClassesInterim import MapInterim

LEVEL_FLOOR = 0.0
LEVEL_CEILING = 64.0

@dataclass
class SectorGZD:
    floorHeight: float
    ceilingHeight: float
    floorColor: Any = None
    ceilingColor: Any = None

@dataclass
class SideGZD:
    sectorIdx: int
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

    def __init__(self, mapInterim: MapInterim):
        self.vertexes: list[VertexGZD] = []
        self.sectorFull: SectorGZD = None
        self.sectorBottom: SectorGZD = None
        self.sides: list[SideGZD] = []
        self.lines: list[LineGZD] = []

        self.sectorFull = SectorGZD(floorHeight=LEVEL_FLOOR, ceilingHeight=LEVEL_CEILING)
        self.sectorBottom = SectorGZD(floorHeight=(LEVEL_CEILING+LEVEL_FLOOR)/2, ceilingHeight=LEVEL_CEILING)

        for line in mapInterim.lines:
            v1Idx = self._addVertex(*line.v1.pair())
            v2Idx = self._addVertex(*line.v2.pair())
            sideFrontIdx = None
            sideBackIdx = None
            if line.height == HeightType.FULL:
                sideFrontIdx = self._addSide(self.SECTOR_FULL_IDX)
            elif line.height == HeightType.BOTTOM:
                sideFrontIdx = self._addSide(self.SECTOR_FULL_IDX)
                sideBackIdx = self._addSide(self.SECTOR_BOTTOM_IDX)
            elif line.height == HeightType.TOP:
                sideFrontIdx = self._addSide(self.SECTOR_BOTTOM_IDX)
            self.lines.append(LineGZD(vertexStartIdx=v1Idx, vertexEndIdx=v2Idx,
                                      sideFrontIdx=sideFrontIdx, sideBackIdx=sideBackIdx))


    def _addVertex(self, x, y) -> int:
        x = float(x)
        y = float(y)
        for i in range(len(self.vertexes)):
            if self.vertexes[i].x == x and self.vertexes[i].y == y:
                return i
        self.vertexes.append(VertexGZD(x=x, y=y))
        return len(self.vertexes) - 1

    def _addSide(self, sectorIdx):
        for i in range(len(self.sides)):
            if self.sides[i].sectorIdx == sectorIdx:
                return i
        self.sides.append(SideGZD(sectorIdx=sectorIdx))
        return len(self.sides) - 1
