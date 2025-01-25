from dataclasses import dataclass
import json, os
from ClassesB3D import MapB3D


def read1DArray(arrayName: str) -> list[int]:
    filename = f'tmp/{arrayName}.json'
    with open(filename, 'r') as file:
        data = json.load(file)
        return [int(num) for num in data]

def read2DArray(arrayName: str) -> list[list[int]]:
    filename = f'tmp/{arrayName}.json'
    with open(filename, 'r') as file:
        data = json.load(file)
        return [[int(num) for num in row] for row in data]


BROKEN_LINES = [
    [],
    [145, 146, 147, 148,  181, 182, 183, 184,  83, 84, 85, 86, 87, 88], #1
    [296, 297, 298, 299], #2
    [], #3
    [], #4
    [316, 317, 318, 319], #5
    [], #6
    [], #7
    [], #8
    [] #9
]

@dataclass
class LoadedData:
    map: MapB3D = None
    brokenLines: list[int] = None
    startPos: tuple[int] = None


def load(mapIndex):
    returnCode = os.system(f'./bin/runJava.sh {mapIndex}')
    if (returnCode != 0):
        raise Exception(f"java returned {returnCode}")
    data = LoadedData()
    data.map = MapB3D(rawLines=read2DArray('LINES_VERTEXES'), rawHeight=read1DArray('LINES_HEIGHT'),
        cratesStartLineIdx=read1DArray('CRATES_START_LINE_IDX'), cratesContent=read1DArray('CRATES_CONTENT'),
        cratesAngles=read1DArray('CRATES_ANGLE'), doorsStartLineIdx=read1DArray('DOORS_START_LINE_IDX'),
    )
    data.brokenLines = BROKEN_LINES[mapIndex]
    footer = read1DArray("FOOTER")
    data.startPos = (footer[-2], footer[-1])
    return data
