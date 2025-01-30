from dataclasses import dataclass
from PIL import Image
from typing import Any
from ClassesShared import Vertex, HeightType, Animation
from tools import generateTextureLumpName, generateTextureMirroredLumpName, generateAnimationName

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
            circles: list[list[int]], textureMirroring: list[int],
            animatedFrames: list[list[int]], animatedLines: list[list[int]],
    ):
        self.circles = circles

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

        self._applyMirroring(textureMirroring)
        self._removeRepeatingTexturesTale()
        self._applyAnimation(animatedFrames, animatedLines)

    def _applyMirroring(self, mirroringData: list[int]):
        mirroredDict = {}
        for line, mirroring in zip(self.lines, mirroringData):
            needMirrorIdx = None
            if mirroring in [3, 15]:
                needMirrorIdx = 0
            if mirroring in [10]:
                needMirrorIdx = 1
            if needMirrorIdx is not None:
                if len(line.texturesNames) == 1:
                    while len(line.texturesNames) < 10:
                        line.texturesNames.append(line.texturesNames[0])
                textureName = line.texturesNames[needMirrorIdx]
                if textureName not in mirroredDict.keys():
                    mirroredName = generateTextureMirroredLumpName()
                    mirroredDict[textureName] = mirroredName
                    self.textures[mirroredName] = self.textures[textureName].transpose(Image.FLIP_LEFT_RIGHT)
                line.texturesNames[needMirrorIdx] = mirroredDict[textureName]

    def _removeRepeatingTexturesTale(self):
        for line in self.lines:
            i = len(line.texturesNames) - 1
            while i > 0 and line.texturesNames[i] == line.texturesNames[i-1]:
                i -= 1
            line.texturesNames = line.texturesNames[:i+1]


    def _applyAnimation(self, animatedFramesList: list[list[int]], animatedLinesList: list[list[int]]):
        self.animations: list[Animation] = []
        for animatedFrames in animatedFramesList:
            if not animatedFrames: continue
            name = generateAnimationName()
            frames: list[str] = []
            for frameIdx in animatedFrames:
                frames.append(list(self.textures.keys())[frameIdx])
            self.animations.append(Animation(name=name, frames=frames))

        for i in range(len(self.animations)):
            for animatedLineIdx in animatedLinesList[i]:
                self.lines[animatedLineIdx].texturesNames = [self.animations[i].name]
