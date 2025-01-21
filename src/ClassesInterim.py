from dataclasses import dataclass
from typing import Any
from ClassesB3D import MapB3D, CrateB3D, DoorB3D
from algebraFunctions import resolveSegmentsOverlap
from ClassesShared import Vertex, HeightType


@dataclass
class LineInterim:
    v1 : Vertex
    v2 : Vertex
    height : HeightType = None
    side1 : Any = None
    side2 : Any = None


class MapInterim:
    def __init__(self, mapB3D: MapB3D):
        self.lines: list[LineInterim] = []
        for line in mapB3D.lines:
            self.lines.append(LineInterim(v1=line.v1, v2=line.v2))
        self._removeCratesAndDoors(mapB3D.crates, mapB3D.doors)

    def _removeCratesAndDoors(self, crates: list[CrateB3D], doors: list[DoorB3D]):
        linesToRemove: list[int] = []
        for crate in crates:
            linesToRemove.append(crate.startLineIdx)
            linesToRemove.append(crate.startLineIdx+1)
            linesToRemove.append(crate.startLineIdx+2)
            linesToRemove.append(crate.startLineIdx+3)
        for door in doors:
            linesToRemove.append(door.startLineIdx)
            linesToRemove.append(door.startLineIdx+1)
            linesToRemove.append(door.startLineIdx+2)

        newLines: list[LineInterim] = []
        for i, line in enumerate(self.lines):
            if i not in linesToRemove:
                newLines.append(line)
        self.lines = newLines



    # @staticmethod
    # def cullLines(lines: list[LineInterim]) -> list[LineInterim]:
    #     i = 0
    #     while i < len(lines):
    #         j = i + 1
    #         while j < len(lines):
    #             resolved = resolveSegmentsOverlap(lines[i].v1.x, lines[i].v1.y, lines[i].v2.x, lines[i].v2.y,
    #                                               lines[j].v1.x, lines[j].v1.y, lines[j].v2.x, lines[j].v2.y)
    #             # if resolved:
    #                 # print(i, j, (lines[i].v1.x, lines[i].v1.y, lines[i].v2.x, lines[i].v2.y),
    #                 #             (lines[j].v1.x, lines[j].v1.y, lines[j].v2.x, lines[j].v2.y),
    #                 #         "->\n      ", *resolved)
    #             j += 1
    #         i += 1
    #     return lines
