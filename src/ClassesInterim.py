from dataclasses import dataclass
from typing import Any
from ClassesB3D import MapB3D, CrateB3D, DoorB3D
from algebraFunctions import resolveSegmentsOverlap, isInside, areOppositelyDirected, fixVertex
from ClassesShared import Vertex, HeightType
from drawMap import drawMap


@dataclass
class LineInterim:
    v1 : Vertex
    v2 : Vertex
    height : HeightType
    texturesNames : list[str]


class MapInterim:
    def __init__(self, mapB3D: MapB3D, brokenLines: list[int]):
        self.lines: list[LineInterim] = []
        for line in mapB3D.lines:
            self.lines.append(LineInterim(v1=line.v1, v2=line.v2, height=line.height, texturesNames=line.texturesNames))
        self._removeCratesDoorsAndBrokenLines(mapB3D.crates, mapB3D.doors, brokenLines)
        # self._fixVertexes()
        self._removeOverlaps()


    def _removeCratesDoorsAndBrokenLines(self, crates: list[CrateB3D], doors: list[DoorB3D], brokenLines: list[int]):
        linesToRemove: set[int] = set(brokenLines)

        for crate in crates:
            linesToRemove.add(crate.startLineIdx)
            linesToRemove.add(crate.startLineIdx+1)
            linesToRemove.add(crate.startLineIdx+2)
            linesToRemove.add(crate.startLineIdx+3)
        for door in doors:
            linesToRemove.add(door.startLineIdx)
            linesToRemove.add(door.startLineIdx+1)
            linesToRemove.add(door.startLineIdx+2)

        newLines: list[LineInterim] = []
        for index, line in enumerate(self.lines):
            if index not in linesToRemove:
                newLines.append(line)
        self.lines = newLines


    def _fixVertexes(self):
        THRESHOLD = 100
        for i in range(len(self.lines)):
            v1 = self.lines[i].v1
            v2 = self.lines[i].v2
            for j in range(len(self.lines)):
                if i == j: continue
                if (v1.pair in [self.lines[j].v1.pair, self.lines[j].v2.pair] or
                    v2.pair in [self.lines[j].v1.pair, self.lines[j].v2.pair]
                ): continue

                x, y = v1.pair()
                fixed = fixVertex(x, y, *self.lineToTuple(self.lines[j]), THRESHOLD)
                if fixed:
                    self.lines[i].v1 = Vertex(*fixed)

                x, y = v2.pair()
                fixed = fixVertex(x, y, *self.lineToTuple(self.lines[j]), THRESHOLD)
                if fixed:
                    self.lines[i].v2 = Vertex(*fixed)


    @staticmethod
    def lineToTuple(line: LineInterim) -> tuple[int]:
        return (line.v1.x, line.v1.y, line.v2.x, line.v2.y)

    @staticmethod
    def _tuplesToLines(tuples, oldLine1: LineInterim, oldLine2: LineInterim) -> list[LineInterim]:
        lines: list[LineInterim] = []
        for tup in tuples:
            height : HeightType = None
            changed = False
            if isInside(*tup, *MapInterim.lineToTuple(oldLine1)) and isInside(*tup, *MapInterim.lineToTuple(oldLine2)):
                if oldLine1.height == oldLine2.height:
                    if areOppositelyDirected(*MapInterim.lineToTuple(oldLine1), *MapInterim.lineToTuple(oldLine2)):
                        height = None
                    else:
                        height = oldLine1.height
                else:
                    heights = set([oldLine1.height, oldLine2.height])
                    if heights == set([HeightType.TOP, HeightType.BOTTOM]):
                        if areOppositelyDirected(*MapInterim.lineToTuple(oldLine1), *MapInterim.lineToTuple(oldLine2)):
                            raise Exception("Oppositely directed TOP and BOTTOM")
                        else:
                            height = HeightType.FULL
                    elif heights == set([HeightType.TOP, HeightType.FULL]):
                        if areOppositelyDirected(*MapInterim.lineToTuple(oldLine1), *MapInterim.lineToTuple(oldLine2)):
                            height = HeightType.BOTTOM
                            changed = True
                        else:
                            print('Warning: top and full lines are not oppositely directed')
                            height = HeightType.FULL
                    elif heights == set([HeightType.BOTTOM, HeightType.FULL]):
                        if areOppositelyDirected(*MapInterim.lineToTuple(oldLine1), *MapInterim.lineToTuple(oldLine2)):
                            height = HeightType.TOP
                            changed = True
                        else:
                            print('Warning: bottom and full lines are not oppositely directed')
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
                newLine = None
                if changed and height in (HeightType.TOP, HeightType.BOTTOM):
                    for oldLine in (oldLine1, oldLine2):
                        if oldLine.height != HeightType.FULL:
                            continue
                        if ((tup[0], tup[1]) in [oldLine.v1.pair(), oldLine.v2.pair()]
                            and (tup[2], tup[3]) in [oldLine.v1.pair(), oldLine.v2.pair()]
                        ):
                            newLine = oldLine
                            newLine.height = height
                            break
                if not newLine:
                    if not changed:
                        lines.append(LineInterim(
                            v1=Vertex(tup[0], tup[1]),
                            v2=Vertex(tup[2], tup[3]),
                            height=height,
                            texturesNames=[None]
                        ))
                    else:
                        lines.append(LineInterim(
                            v1=Vertex(tup[2], tup[3]),
                            v2=Vertex(tup[0], tup[1]),
                            height=height,
                            texturesNames=[None]
                        ))
                else:
                    lines.append(newLine)

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
                    # print(i, j)
                    # if i > 170:
                    #     drawMap(self, wait=True)
                    oldLine1 = self.lines[i]
                    oldLine2 = self.lines[j]
                    del self.lines[j]
                    newLines = self._tuplesToLines(resolved, oldLine1, oldLine2)
                    # print(i, j, (self.lineToTuple(oldLine1), self.lineToTuple(oldLine2)), "->\n     ",
                    #       tuple((self.lineToTuple(line) for line in newLines)))
                    self.lines = self.lines[:i] + newLines + self.lines[i+1:]
                    isBroken = True
                    break
            if isBroken:
                continue
            else:
                i += 1
                continue


