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


def loadB3DMap(mapIndex):
    returnCode = os.system(f'./bin/runJava.sh {mapIndex}')
    if (returnCode != 0):
        raise Exception(f"java returned {returnCode}")
    map = MapB3D(rawLines=read2DArray('LINES_VERTEXES'), rawHeight=read1DArray('LINES_HEIGHT'),
        cratesStartLineIdx=read1DArray('CRATES_START_LINE_IDX'), cratesContent=read1DArray('CRATES_CONTENT'),
        cratesAngles=read1DArray('CRATES_ANGLE'), doorsStartLineIdx=read1DArray('DOORS_START_LINE_IDX'))
    return map
