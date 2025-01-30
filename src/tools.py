import math

LEVEL_FLOOR = 0
WALL_HEIGHT = 96
LEVEL_CEILING = WALL_HEIGHT
SCALE_FACTOR = LEVEL_CEILING / 65536


def get2DListValueRange(list_: list[list]):
    min = math.inf
    max = -math.inf
    for i in range(len(list_)):
        for j in range(len(list_[i])):
            value = list_[i][j]
            if value < min:
                min = value
            if value > max:
                max = value
    return (min, max)


def printBigLump(bigLump):
    for i in range(len(bigLump)):
        list_ = bigLump[i]
        print(f"Fragment {i} of size {len(list_)} in range {get2DListValueRange(list_)}: {list_}\n")


def create2DList(a, b, default=0):
    return [[default for _ in range(b)] for _ in range(a)]

def create1DList(a, default=0):
    return [default for _ in range(a)]


_textureLumpIdx = 0
def generateTextureLumpName():
    global _textureLumpIdx
    result = f'B3D_T{_textureLumpIdx:03}'
    _textureLumpIdx += 1
    return result

def getCeilingLumpName(mapIndex):
    return f"B3D_C{mapIndex:03}"

def getFloorLumpName(mapIndex):
    return f"B3D_F{mapIndex:03}"
