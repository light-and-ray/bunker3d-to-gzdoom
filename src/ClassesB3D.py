from dataclasses import dataclass
from PIL import Image
from typing import Any
from ClassesShared import Vertex, HeightType
from tools import generateTextureLumpName

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
    textureName : str

@dataclass
class LineB3D:
    v1 : Vertex
    v2 : Vertex
    height : HeightType
    texturesNames : list[str]


class MapB3D:
    def __init__(self, rawLines: list[list[int]], rawHeight: list[int],
            cratesStartLineIdx: list[int], cratesContent: list[int], cratesAngles: list[int],
            doorsStartLineIdx: list[int],
            textures: list[Image.Image], linesTextures: list[list[int]],
    ):
        self.textures: dict[str, Image.Image] = {}
        for texture in textures:
            self.textures[generateTextureLumpName()] = texture

        self.lines: list[LineB3D] = []

        for i in range(len(rawLines[0])):
            texturesNames: list[str] = []
            for index in linesTextures[i]:
                keys = list(self.textures.keys())
                if index >= len(keys):
                    texturesNames.append(None)
                else:
                    texturesNames.append(keys[index])

            self.lines.append(
                LineB3D(
                    v1=Vertex(rawLines[0][i], rawLines[1][i]),
                    v2=Vertex(rawLines[2][i], rawLines[3][i]),
                    height=HeightType(rawHeight[i]),
                    texturesNames=texturesNames,
                )
            )

        self.crates: list[CrateB3D] = []
        for idx in range(len(cratesStartLineIdx)):
            self.crates.append(CrateB3D(
                startLineIdx=cratesStartLineIdx[idx],
                content=cratesContent[idx],
                angle=cratesAngles[idx],
                textureName=self.lines[cratesStartLineIdx[idx]].texturesNames[0],
            ))

        self.doors: list[DoorB3D] = []
        for idx in range(len(doorsStartLineIdx)):
            self.doors.append(DoorB3D(
                startLineIdx=doorsStartLineIdx[idx],
            ))

        self._removeRepeatingTexturesTale()


    def _removeRepeatingTexturesTale(self):
        for line in self.lines:
            i = len(line.texturesNames) - 1
            while i > 0 and line.texturesNames[i] == line.texturesNames[i-1]:
                i -= 1
            line.texturesNames = line.texturesNames[:i+1]



