from dataclasses import dataclass
from enum import Enum

class HeightType(Enum):
    FULL = 0
    BOTTOM = 1
    TOP = 2

@dataclass
class Vertex:
    x: int
    y: int
