from dataclasses import dataclass
import json, os
from ClassesB3D import MapB3D
from PIL import Image
from tools import makeBackgroundTransparent
from fixes import fixFoeSprite
from ClassesShared import GameType

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
            try:
                pixel = data[index]
            except:
                print("load_image_from_1d_list", index, height, width)
                raise
            r = (pixel >> 16) & 0xFF
            g = (pixel >> 8) & 0xFF
            b = pixel & 0xFF
            pixels[x, y] = (r, g, b)
            index += 1

    return img


@dataclass
class LoadedData:
    map: MapB3D = None
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
        texture = load_image_from_1d_list(textures_data[i], textures_w[i], textures_h[i])
        textures.append(texture)
    return textures

def _loadSprites():
    sprites_w = read1DArray("SPRITES_W")
    sprites_h = read1DArray("SPRITES_H")
    all_sprites = []
    for sprites_data in (read2DArray("SPRITES_DATA_COLOR_1"), read2DArray("SPRITES_DATA_COLOR_2")):
        sprites = []
        for i in range(len(sprites_data)):
            if sprites_w[i] == -1:
                magenta_square = Image.new('RGBA', (48, 48), color=(255, 0, 255, 255))
                sprites.append(magenta_square)
            else:
                sprite = load_image_from_1d_list(sprites_data[i], sprites_w[i], sprites_h[i])
                sprite = makeBackgroundTransparent(sprite)
                if sprite.width == 96: # bomb
                    sprite = sprite.transpose(Image.FLIP_TOP_BOTTOM)
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
            sprite = fixFoeSprite(sprite, i)
            sprites.append(sprite)
        all_sprites.append(sprites)
    return all_sprites

def _resolveTextureList(textureIdx: int) -> list[int]:
    help4 = read1DArray("LINES_TEXTURES_HELP_4")
    var6 = 1 if textureIdx < 32 else 7
    var12s = []
    for var7 in range(var6):
        if var6 == 1:
            var12 = textureIdx
        else:
            var12 = help4[(textureIdx - 32) * var6 + var7]
        var12s.append(var12)
    return var12s


def _loadLinesTextures():
    textures = read1DArray("LINES_TEXTURES")
    linesTextures = []
    for texture in textures:
        linesTextures.append(_resolveTextureList(texture))
    return linesTextures

def _loadAnimatedFramesInner(lst):
    if not lst:
        return []
    max_len = max(len(sub) for sub in lst)

    result = []
    for i in range(max_len):
        current = [sub[i % len(sub)] for sub in lst]
        result.append(current)
    return result

def _loadAnimatedFrames():
    framesList = read2DArray("ANIMATED_FRAMES")
    resultList = []
    for frames in framesList:
        if not frames:
            resultList.append(None)
            continue
        for i in range(len(frames)):
            frames[i] = _resolveTextureList(frames[i])
        # print(frames, '->', _loadAnimatedFramesInner(frames))
        resultList.append(_loadAnimatedFramesInner(frames))

    return resultList

def _run(command: str):
    returnCode = os.system(command)
    if (returnCode != 0):
        raise Exception(f"java returned {returnCode}")


_isJavaCompiled = False
def load(mapIndex: int, game: GameType):
    global _isJavaCompiled
    if not _isJavaCompiled:
        _isJavaCompiled = True
        _run(f'./bin/runJavaCompile.sh')
    if game == GameType.B3D:
        _run(f'./bin/runJavaB3D.sh {mapIndex}')
    elif game == GameType.L3D:
        _run(f'./bin/runJavaL3D.sh {mapIndex}')
    elif game == GameType.C3D:
        _run(f'./bin/runJavaC3D.sh {mapIndex}')
    data = LoadedData()
    textures = _loadTextures()
    linesTextures = _loadLinesTextures()
    animatedFrames = _loadAnimatedFrames()
    sprites = _loadSprites()
    foeSprites = _loadFoeSprites()
    os.makedirs(f"tmp/sprites/c{game.value+1}m{mapIndex}", exist_ok=True)
    for i in range(len(sprites[0])):
        for color in (0, 1):
            sprites[color][i].save(f"tmp/sprites/c{game.value+1}m{mapIndex}/sprite_{color}_{i}.png")
    for i in range(len(foeSprites[0])):
        for color in (0, 1):
            foeSprites[color][i].save(f"tmp/sprites/c{game.value+1}m{mapIndex}/foe_{color}_{i}.png")
    os.makedirs(f"tmp/textures/c{game.value+1}m{mapIndex}", exist_ok=True)
    for i in range(len(textures)):
        textures[i].save(f"tmp/textures/c{game.value+1}m{mapIndex}/texture_{i}.png")

    data.map = MapB3D(rawLines=read2DArray('LINES_VERTEXES'), rawHeight=read1DArray('LINES_HEIGHT'),
        cratesStartLineIdx=read1DArray('CRATES_START_LINE_IDX'), cratesContent=read1DArray('CRATES_CONTENT'),
        cratesAngles=read1DArray('CRATES_ANGLE'), gameType=game, mapIndex=mapIndex,
        textures=textures, linesTextures=linesTextures, circles=read2DArray("CIRCLES_IDX"),
        textureMirroring=read1DArray("LINES_MIRRORING"), animatedFrames=animatedFrames,
        animatedLines=read2DArray("LINES_ANIMATED"), sprites=sprites, foeSprites=foeSprites,
        thingsPos=read2DArray('THINGS_POS'), thingsSprites=read1DArray("THINGS_SPRITE"), thingsColors=read1DArray("THINGS_COLOR"),
        thingsVisibleFlag=read1DArray("THINGS_VISIBLE"), thingsSpecials = read1DArray('THINGS_SPECIAL'),
        visibleThingSets=read2DArray("VISIBLE_THING_SETS"), triggers=read2DArray("TRIGGERS"),
        triggerVisibleThingSet=read1DArray("TRIGGER_VISIBLE_THING_SET")
    )

    footer = read1DArray("FOOTER")
    data.colorCeiling = (footer[0], footer[1], footer[2])
    data.colorFloor = (footer[3], footer[4], footer[5])
    data.doorsSpeed = read1DArray("DOORS_SPEED")
    data.doorsStartLineIdx=read1DArray('DOORS_START_LINE_IDX')

    data.spawnPos = read1DArray('SPAWN_POS')
    data.spawnPos[0] = data.spawnPos[0] * 2**16 // 75000
    data.spawnPos[1] = data.spawnPos[1] * 2**16 // 75000
    data.spawnAngle = readSingleValue('SPAWN_ANGLE')

    data.foeAngles = read1DArray('FOE_ANGLES')
    data.foeWalkDistances = read1DArray('FOE_WALK_DISTANCE')

    return data

