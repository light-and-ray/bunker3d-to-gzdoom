from dataclasses import dataclass
import json, os
from ClassesB3D import MapB3D
from ClassesShared import BrokenTextureData
from PIL import Image
from tools import WALL_HEIGHT, makeBackgroundTransparent, fixFoeSprite

def readSingleValue(jsonName: str) -> int:
    filename = f'tmp/{jsonName}.json'
    with open(filename, 'r') as file:
        data = json.load(file)
        if isinstance(data, str):
            return int(data)
        else:
            raise ValueError("The JSON file does not contain a single string.")

def read1DArray(jsonName: str) -> list[int]:
    filename = f'tmp/{jsonName}.json'
    with open(filename, 'r') as file:
        data = json.load(file)
        return [int(num) for num in data]

def read2DArray(jsonName: str) -> list[list[int | None]]:
    filename = f'tmp/{jsonName}.json'
    with open(filename, 'r') as file:
        data = json.load(file)
        return [[int(num) if num is not None else None for num in row] if row is not None else None for row in data]

def read3DArray(jsonName: str) -> list[list[list[int | None]]]:
    filename = f'tmp/{jsonName}.json'
    with open(filename, 'r') as file:
        data = json.load(file)
        return [[[int(num) if num is not None else None for num in row] if row is not None else None for row in plane] if plane is not None else None for plane in data]


def load_image_from_1d_list(data, width, height) -> Image.Image:
    img = Image.new('RGB', (width, height))
    pixels = img.load()
    index = 0
    for y in range(height):
        for x in range(width):
            pixel = data[index]
            r = (pixel >> 16) & 0xFF
            g = (pixel >> 8) & 0xFF
            b = pixel & 0xFF
            pixels[x, y] = (r, g, b)
            index += 1

    return img


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

BROKEN_TEXTURES = [ # Doors (inside) and 45 degree with middled texture inside
    None,
    { # 1
        18 : BrokenTextureData(nums=[0, 13, 0], offset=WALL_HEIGHT-18),
        20 : BrokenTextureData(nums=[0]),
        19 : BrokenTextureData(nums=[6]),
        21 : BrokenTextureData(nums=[6]),
    },
    { # 2
        21 : BrokenTextureData(nums=[4]),
    },
    { # 3
        17 : BrokenTextureData(nums=[4]),
    },
    { # 4
        23 : BrokenTextureData(nums=[4]),
    },
    { #5
        18 : BrokenTextureData(nums=[0]),
        20 : BrokenTextureData(nums=[4]),
    },
    { # 6
        17 : BrokenTextureData(nums=[7]),
    },
    { # 7
        18 : BrokenTextureData(nums=[6]),
    },
    { # 8
        21 : BrokenTextureData(nums=[4]),
    },
    { # 9
        19 : BrokenTextureData(nums=[6]),
        20 : BrokenTextureData(nums=[6]),
    },
]

@dataclass
class LoadedData:
    map: MapB3D = None
    brokenLines: list[int] = None
    brokenTextures: dict[int, BrokenTextureData] = None
    colorCeiling: tuple[int] = None
    colorFloor: tuple[int] = None
    doorsSpeed: list[int] = None
    doorsStartLineIdx: list[int] = None
    spawnPos: list[int] = None
    spawnAngle: int = None
    foeAngles: list[int] = None
    foeWalkDistances: list[int] = None


def _loadTextures():
    textures_data = read2DArray("TEXTURES_DATA")
    textures_w = read1DArray("TEXTURES_W")
    textures_h = read1DArray("TEXTURES_H")
    textures = []
    for i in range(len(textures_data)):
        textures.append(load_image_from_1d_list(textures_data[i], textures_w[i], textures_h[i]))
    return textures

def _loadSprites():
    sprites_w = read1DArray("SPRITES_W")
    sprites_h = read1DArray("SPRITES_H")
    all_sprites = []
    for sprites_data in (read2DArray("SPRITES_DATA_COLOR_1"), read2DArray("SPRITES_DATA_COLOR_2")):
        sprites = []
        for i in range(len(sprites_data)):
            sprite = load_image_from_1d_list(sprites_data[i], sprites_w[i], sprites_h[i])
            sprite = makeBackgroundTransparent(sprite)
            sprites.append(sprite)
        all_sprites.append(sprites)
    return all_sprites

def _loadFoeSprites():
    sprites_w = read1DArray("FOE_SPRITES_W")
    sprites_h = read1DArray("FOE_SPRITES_H")
    all_sprites = []
    for sprites_data in (read2DArray("FOE_SPRITES_DATA_COLOR_1"), read2DArray("FOE_SPRITES_DATA_COLOR_2")):
        sprites = []
        for i in range(len(sprites_data)):
            sprite = load_image_from_1d_list(sprites_data[i], sprites_w[i], sprites_h[i])
            sprite = makeBackgroundTransparent(sprite)
            sprite = fixFoeSprite(sprite)
            sprites.append(sprite)
        all_sprites.append(sprites)
    return all_sprites

def _loadLinesTextures():
    cX = read1DArray("LINES_TEXTURES")
    bs = read1DArray("LINES_bs")
    bk = read1DArray("LINES_bk")
    bA = read1DArray("LINES_bA")
    br = read1DArray("LINES_br")

    linesTextures = []

    for i in range(len(cX)):
        av = cX[i]
        at = bs[av]

        var6 = 1 if av < 32 else 7
        brvar3list = []
        var12s = []
        var3s = []
        for var7 in range(var6):
            if var6 == 1:
                var12 = av
            else:
                var12 = bA[(av - 32) * var6 + var7]

            var3 = bk[var12]
            var12s.append(var12)
            var3s.append(var3)
            brvar3list.append(br[var3])
        # 18 = 0, 19 = 6, 21 = 6
        # 0 = 0, 1 = 6, 3 = 6
        linesTextures.append(var12s)
        # print(f"{i}: {av=} {at=} {var12s=} {var3s=} {brvar3list=}")
    return linesTextures


def _run(command: str):
    returnCode = os.system(command)
    if (returnCode != 0):
        raise Exception(f"java returned {returnCode}")


_isJavaCompiled = False
def load(mapIndex):
    global _isJavaCompiled
    if not _isJavaCompiled:
        _isJavaCompiled = True
        _run(f'./bin/runJavaCompile.sh')
    _run(f'./bin/runJavaB3D.sh {mapIndex}')
    data = LoadedData()
    textures = _loadTextures()
    linesTextures = _loadLinesTextures()
    sprites = _loadSprites()
    foeSprites = _loadFoeSprites()
    # os.makedirs(f"tmp/sprites/map{mapIndex}", exist_ok=True)
    # for i in range(len(sprites[0])):
    #     for color in (0, 1):
    #         sprites[color][i].save(f"tmp/sprites/map{mapIndex}/sprite_{color}_{i}.png")
    # for i in range(len(foeSprites[0])):
    #     for color in (0, 1):
    #         foeSprites[color][i].save(f"tmp/sprites/map{mapIndex}/foe_{color}_{i}.png")

    data.map = MapB3D(rawLines=read2DArray('LINES_VERTEXES'), rawHeight=read1DArray('LINES_HEIGHT'),
        cratesStartLineIdx=read1DArray('CRATES_START_LINE_IDX'), cratesContent=read1DArray('CRATES_CONTENT'),
        cratesAngles=read1DArray('CRATES_ANGLE'),
        textures=textures, linesTextures=linesTextures, circles=read2DArray("CIRCLES_IDX"),
        textureMirroring=read1DArray("LINES_MIRRORING"), animatedFrames=read2DArray("ANIMATED_FRAMES"),
        animatedLines=read2DArray("LINES_ANIMATED"), sprites=sprites, foeSprites=foeSprites,
        thingsPos=read2DArray('THINGS_POS'), thingsSprites=read1DArray("THINGS_SPRITE"), thingsColors=read1DArray("THINGS_COLOR"),
        thingsVisible=read1DArray("THINGS_VISIBLE"), thingsSpecials = read1DArray('THINGS_SPECIAL'),
    )

    data.brokenLines = BROKEN_LINES[mapIndex]
    data.brokenTextures = BROKEN_TEXTURES[mapIndex]
    footer = read1DArray("FOOTER")
    data.colorCeiling = (footer[0], footer[1], footer[2])
    data.colorFloor = (footer[3], footer[4], footer[5])
    data.doorsSpeed = read1DArray("DOORS_SPEED")
    data.doorsStartLineIdx=read1DArray('DOORS_START_LINE_IDX')

    data.spawnPos = read1DArray('SPAWN_POS')
    data.spawnAngle = readSingleValue('SPAWN_ANGLE')

    data.foeAngles = read1DArray('FOE_ANGLES')
    data.foeWalkDistances = read1DArray('FOE_WALK_DISTANCE')

    return data

