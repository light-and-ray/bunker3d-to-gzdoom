import json, os
from ClassesB3D import MapB3D

def read_2d_list_from_json(filename):
    with open(filename, 'r') as file:
        data = json.load(file)
        return [[int(num) for num in row] for row in data]


def readArray(arrayName: str):
    filename = f'tmp/{arrayName}.json'
    data = read_2d_list_from_json(filename)
    return data


def loadMap(mapIndex):
    returnCode = os.system(f'./bin/runJava.sh {mapIndex}')
    if (returnCode != 0):
        raise Exception(f"java returned {returnCode}")
    map = MapB3D(rawLines=readArray('cW'))
    return map
