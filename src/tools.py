import math, zlib, struct
from PIL import Image
from ClassesShared import GameType

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
    result = f'TEXT_{_textureLumpIdx:03}'
    _textureLumpIdx += 1
    return result

_textureMirroredLumpIdx = 0
def generateTextureModifiedLumpName():
    global _textureMirroredLumpIdx
    result = f'MDFC_{_textureMirroredLumpIdx:02}'
    _textureMirroredLumpIdx += 1
    return result

def getCeilingLumpName(mapIndex, game: GameType):
    return f"{game.name}_C{mapIndex:03}"

def getFloorLumpName(mapIndex: int, game: GameType):
    return f"{game.name}_F{mapIndex:03}"


def makeBackgroundTransparent(inputImage):
    img = inputImage.convert('RGBA')
    pixels = img.load()
    background_color = pixels[0, 0]
    for x in range(img.width):
        for y in range(img.height):
            pixel_color = pixels[x, y]
            if pixel_color == background_color:
                pixels[x, y] = (0, 0, 0, 0)
    return img


def addOffsets(png_data, x_offset, y_offset):
    def find_chunk(data, chunk_type):
        index = 8  # Skip the PNG header
        while index < len(data):
            length = struct.unpack(">I", data[index:index+4])[0]
            if data[index+4:index+8] == chunk_type:
                return index, length
            index += length + 12  # Move to the next chunk
        return -1, -1

    def create_grab_chunk(x, y):
        grab_data = struct.pack(">i", x) + struct.pack(">i", y)
        chunk_data = b'grAb' + grab_data
        crc = struct.pack(">I", zlib.crc32(chunk_data) & 0xffffffff)
        return struct.pack(">I", 8) + chunk_data + crc

    grab_index, grab_length = find_chunk(png_data, b'grAb')
    if grab_index != -1:
        if struct.unpack(">i", png_data[grab_index+8:grab_index+12])[0] == x_offset and \
           struct.unpack(">i", png_data[grab_index+12:grab_index+16])[0] == y_offset:
            return png_data  # No offset changes needed

    # Create new grAb chunk
    new_grab_chunk = create_grab_chunk(x_offset, y_offset)

    # Insert or replace the grAb chunk
    if grab_index == -1:
        idat_index, _ = find_chunk(png_data, b'IDAT')
        new_png_data = png_data[:idat_index] + new_grab_chunk + png_data[idat_index:]
    else:
        new_png_data = png_data[:grab_index] + new_grab_chunk + png_data[grab_index+grab_length+12:]

    return new_png_data


def isBottomRowTransparent(image: Image.Image):
    if image.mode != 'RGBA':
        raise Exception("is not rgba")

    width, height = image.size
    bottom_row = image.crop((0, height - 1, width, height))

    for pixel in bottom_row.getdata():
        if pixel[3] != 0:
            return False
    return True


def saveToFile(filepath, data):
    mode = 'w' if isinstance(data, str) else 'wb'
    with open(filepath, mode) as f:
        f.write(data)

