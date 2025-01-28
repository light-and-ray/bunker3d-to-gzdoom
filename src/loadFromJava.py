from dataclasses import dataclass
import json, os
from ClassesB3D import MapB3D
from PIL import Image


def read1DArray(arrayName: str) -> list[int]:
    filename = f'tmp/{arrayName}.json'
    with open(filename, 'r') as file:
        data = json.load(file)
        return [int(num) for num in data]


def read2DArray(arrayName: str) -> list[list[int | None]]:
    filename = f'tmp/{arrayName}.json'
    with open(filename, 'r') as file:
        data = json.load(file)
        return [[int(num) if num is not None else None for num in row] if row is not None else None for row in data]

def read3DArray(arrayName: str) -> list[list[list[int | None]]]:

    filename = f'tmp/{arrayName}.json'
    with open(filename, 'r') as file:
        data = json.load(file)
        return [[[int(num) if num is not None else None for num in row] if row is not None else None for row in plane] if plane is not None else None for plane in data]


def load_image_from_1d_list(data, width, height) -> Image.Image:
    img = Image.new('RGB', (width, height))

    # Load the pixel data into the image
    pixels = img.load()
    index = 0
    for y in range(height):
        for x in range(width):
            # Extract the RGB channels from the integer pixel value
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

@dataclass
class LoadedData:
    map: MapB3D = None
    brokenLines: list[int] = None
    startPos: tuple[int] = None
    colorCeiling: tuple[int] = None
    colorFloor: tuple[int] = None
    textures: list[Image.Image] = None


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
    data.colorCeiling = (footer[0], footer[1], footer[2])
    data.colorFloor = (footer[3], footer[4], footer[5])
    data.startPos = (0, 0)

    textures_data = read2DArray("TEXTURES_DATA")
    textures_w = read1DArray("TEXTURES_W")
    textures_h = read1DArray("TEXTURES_H")
    data.textures = []
    for i in range(len(textures_data)):
        data.textures.append(load_image_from_1d_list(textures_data[i], textures_w[i], textures_h[i]))

    return data
