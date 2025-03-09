from dataclasses import dataclass
from enum import Enum

class HeightType(Enum):
    FULL = 0
    ONLY_BOTTOM = 1
    ONLY_TOP = 2
    BOTTOM = 3
    TOP = 4

@dataclass
class Vertex:
    x: int
    y: int
    def pair(self) -> tuple[int]:
        return (self.x, self.y)

@dataclass
class Animation:
    name: str
    frames: list[str]
    duration: float

class GameType(Enum):
    B3D = 0
    L3D = 1
    C3D = 2
