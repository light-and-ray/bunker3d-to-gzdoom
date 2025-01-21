from dataclasses import dataclass
from typing import Any
from enum import Enum
from ClassesB3D import MapB3D
from algebraFunctions import resolveSegmentsOverlap

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
        i = 0
        while i < len(lines):
            j = i + 1
            while j < len(lines):
                resolved = resolveSegmentsOverlap(lines[i].v1[0], lines[i].v1[1], lines[i].v2[0], lines[i].v2[1],
                                                  lines[j].v1[0], lines[j].v1[1], lines[j].v2[0], lines[j].v2[1])
                if resolved:
                    print(i, j, (lines[i].v1[0], lines[i].v1[1], lines[i].v2[0], lines[i].v2[1]),
                                (lines[j].v1[0], lines[j].v1[1], lines[j].v2[0], lines[j].v2[1]),
                            "->\n      ", *resolved)
                j += 1
            i += 1
