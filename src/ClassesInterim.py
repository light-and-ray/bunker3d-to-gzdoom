from dataclasses import dataclass
from typing import Any
from enum import Enum
from ClassesB3D import MapB3D

class HeightType(Enum):
    FULL = 1
    BOTTOM = 2
    TOP = 3


@dataclass
class LineInterim:
    v1 : tuple[int]
    v2 : tuple[int]
    height : HeightType = None
    side1 : Any = None
    side2 : Any = None


class MapInterim:
    def __init__(self, mapB3D: MapB3D):
        self.lines: list[LineInterim] = []
        for line in mapB3D.lines:
            self.lines.append(LineInterim(v1=line.v1, v2=line.v2))
        self.lines = self.cullLines(self.lines)

    @staticmethod
    def cullLines(lines: list[LineInterim]) -> list[LineInterim]:
        pass
