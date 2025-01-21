from dataclasses import dataclass
from typing import Any
from ClassesB3D import MapB3D, CrateB3D, DoorB3D
from algebraFunctions import resolveSegmentsOverlap, isInside, isAthwart
from ClassesShared import Vertex, HeightType


@dataclass
class LineInterim:
    v1 : Vertex
    v2 : Vertex
    height : HeightType
    texture : Any = None


class MapInterim:
    def __init__(self, mapB3D: MapB3D):
        self.lines: list[LineInterim] = []
        for line in mapB3D.lines:
            self.lines.append(LineInterim(v1=line.v1, v2=line.v2, height=line.height, texture=line.texture))
        # self._removeCratesAndDoors(mapB3D.crates, mapB3D.doors)
        self._removeOverlaps()


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
        for index, line in enumerate(self.lines):
            if index not in linesToRemove:
                newLines.append(line)
        self.lines = newLines

    @staticmethod
    def lineToTuple(line: LineInterim) -> tuple[int]:
        return (line.v1.x, line.v1.y, line.v2.x, line.v2.y)

    @staticmethod
    def _tuplesToLines(tuples, oldLine1: LineInterim, oldLine2: LineInterim) -> list[LineInterim]:
        lines: list[LineInterim] = []
        for tup in tuples:
            height : HeightType = None
            if isInside(*tup, *MapInterim.lineToTuple(oldLine1)) and isInside(*tup, *MapInterim.lineToTuple(oldLine2)):
                if oldLine1.height == oldLine2.height:
                    if isAthwart(*MapInterim.lineToTuple(oldLine1), *MapInterim.lineToTuple(oldLine2)):
                        height = None
                    else:
                        height = oldLine1.height
                else:
                    heights = set([oldLine1.height, oldLine2.height])
                    if heights == set([HeightType.TOP, HeightType.BOTTOM]):
                        if isAthwart(*MapInterim.lineToTuple(oldLine1), *MapInterim.lineToTuple(oldLine2)):
                            # raise Exception("Athwart TOP and BOTTOM")
                            pass
                        else:
                            height = HeightType.FULL
                    elif heights == set([HeightType.TOP, HeightType.FULL]):
                        if isAthwart(*MapInterim.lineToTuple(oldLine1), *MapInterim.lineToTuple(oldLine2)):
                            height = HeightType.BOTTOM
                        else:
                            print('Warning: top and full lines are not athwart')
                            height = HeightType.FULL
                    elif heights == set([HeightType.BOTTOM, HeightType.FULL]):
                        if isAthwart(*MapInterim.lineToTuple(oldLine1), *MapInterim.lineToTuple(oldLine2)):
                            height = HeightType.TOP
                        else:
                            print('Warning: bottom and full lines are not athwart')
                            height = HeightType.FULL
                    else:
                        raise Exception("Can't be here")
            else:
                if isInside(*tup, *MapInterim.lineToTuple(oldLine1)):
                    height = oldLine1.height
                elif isInside(*tup, *MapInterim.lineToTuple(oldLine2)):
                    height = oldLine2.height
                else:
                    raise Exception("Tuple is not inside either oldLine1 or oldLine2")
            if height:
                lines.append(LineInterim(
                    v1=Vertex(tup[0], tup[1]),
                    v2=Vertex(tup[2], tup[3]),
                    height=height
                ))
        return lines

    def _removeOverlaps(self):
        i = 0
        while i < len(self.lines):
            j = i + 1
            isBroken = False
            while j < len(self.lines):
                resolved = resolveSegmentsOverlap(*self.lineToTuple(self.lines[i]), *self.lineToTuple(self.lines[j]))
                if not resolved:
                    j += 1
                    continue
                else:
                    print(i, j, resolved)
                    oldLine1 = self.lines[i]
                    oldLine2 = self.lines[j]
                    del self.lines[j]
                    self.lines = self.lines[:i] + self._tuplesToLines(resolved, oldLine1, oldLine2) + self.lines[i+1:]
                    isBroken = True
                    break
            if isBroken:
                continue
            else:
                i += 1
                continue


