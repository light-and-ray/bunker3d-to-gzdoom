from dataclasses import dataclass
from enum import Enum
from typing import Any
from ClassesShared import HeightType
from ClassesInterim import MapInterim
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

        self.sectorFull = SectorGZD(heightFloor=LEVEL_FLOOR, heightCeiling=LEVEL_CEILING)
        self.sectorBottom = SectorGZD(heightFloor=(LEVEL_CEILING+LEVEL_FLOOR)//2, heightCeiling=LEVEL_CEILING)

        for line in mapInterim.lines:
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
            self.lines.append(LineGZD(vertexStartIdx=v1Idx, vertexEndIdx=v2Idx,
                                      sideFrontIdx=sideFrontIdx, sideBackIdx=sideBackIdx))

        for i in range(len(self.vertexes)):
            self.vertexes[i].x *= SCALE_FACTOR
            self.vertexes[i].y *= SCALE_FACTOR


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
