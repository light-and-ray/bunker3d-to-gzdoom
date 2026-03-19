from dataclasses import dataclass
from enum import Enum

class HeightType(Enum):
    FULL = 0
    ONLY_BOTTOM = 1 # bottom with air on top of it
    ONLY_TOP = 2
    BOTTOM = 3 # bottom with solid on top of it
    TOP = 4

@dataclass
class Vertex:
    x: int
    y: int
    def pair(self) -> tuple[int]:
        return (self.x, self.y)
    def __add__(self, other: "Vertex"):
        return Vertex(self.x + other.x, self.y + other.y)
    def __truediv__(self, scalar):
        return Vertex(self.x // scalar, self.y // scalar)

@dataclass
class Animation:
    name: str
    frames: list[str]
    duration: float

class GameType(Enum):
    B3D = 0
    L3D = 1
    C3D = 2
