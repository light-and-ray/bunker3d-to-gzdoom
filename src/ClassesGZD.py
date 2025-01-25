from dataclasses import dataclass
from typing import Any
from ClassesInterim import MapInterim


@dataclass
class SectorGZD:
    floorHeight: float
    ceilingHeight: float
    floorColor: Any
    ceilingColor: Any

@dataclass
class SideGZD:
    sectorIdx: int
    textureTop: Any
    textureBottom: Any
    textureMiddle: Any

@dataclass
class VertexGZD:
    x: float
    y: float

@dataclass
class LineGZD:
    vertexStartIdx: int
    vertexEndIdx: int
    sideFrontIdx: int
    sideBackIdx: int|None


class MapGZD:
    SECTOR_FULL_IDX = 0
    SECTOR_BOTTOM_IDX = 1

    def __init__(self, mapInterim: MapInterim):
        self.vertexes: list[VertexGZD] = []
        self.sectorFull: SectorGZD = None
        self.sectorBottom: SectorGZD = None
        self.sides: list[SideGZD] = []
        self.lines: list[LineGZD] = []

