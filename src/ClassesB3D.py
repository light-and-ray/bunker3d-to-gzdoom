from dataclasses import dataclass
from typing import Any
from ClassesShared import Vertex, HeightType

@dataclass
class DoorB3D:
    startLineIdx : int
    pair: Any = None
    texture : Any = None

@dataclass
class CrateB3D:
    startLineIdx : int
    angle : int
    content : int
    texture : Any = None

@dataclass
class LineB3D:
    v1 : Vertex
    v2 : Vertex
    height : HeightType
    texture : Any = None


class MapB3D:
    def __init__(self, rawLines: list[list[int]], rawHeight: list[int],
            cratesStartLineIdx: list[int], cratesContent: list[int], cratesAngles: list[int],
            doorsStartLineIdx
    ):
        self.lines: list[LineB3D] = []
        for i in range(len(rawLines[0])):
            self.lines.append(
                LineB3D(
                    v1=Vertex(rawLines[0][i], rawLines[1][i]),
                    v2=Vertex(rawLines[2][i], rawLines[3][i]),
                    height=HeightType(rawHeight[i])
                )
            )

        self.crates: list[CrateB3D] = []
        for idx in range(len(cratesStartLineIdx)):
            self.crates.append(CrateB3D(
                startLineIdx=cratesStartLineIdx[idx],
                content=cratesContent[idx],
                angle=cratesAngles[idx],
                texture=self.lines[cratesStartLineIdx[idx]].texture,
            ))

        self.doors: list[DoorB3D] = []
        for idx in range(len(doorsStartLineIdx)):
            self.doors.append(DoorB3D(
                startLineIdx=doorsStartLineIdx[idx],
                texture=self.lines[doorsStartLineIdx[idx]].texture,
            ))

