from dataclasses import dataclass
from typing import Any


@dataclass
class LineB3D:
    v1 : tuple[int]
    v2 : tuple[int]
    side1 : Any = None
    side2 : Any = None


class MapB3D:
    def __init__(self, rawLines: list[list[int]]):
        self.lines: list[LineB3D] = []
        for i in range(len(rawLines[0])):
            self.lines.append(LineB3D(v1=(rawLines[0][i], rawLines[1][i]), v2=(rawLines[2][i], rawLines[3][i])))
