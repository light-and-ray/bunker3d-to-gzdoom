from dataclasses import dataclass
from tools import WALL_HEIGHT
from ClassesShared import GameType
from PIL import Image


@dataclass
class BrokenTextureData:
    nums: list[int]
    offset: float = None
    stretch: float = 1.0


BROKEN_LINES: dict[tuple[GameType, int], list[int]] = dict()
BROKEN_LINES[(GameType.B3D, 1)] = [145, 146, 147, 148,  181, 182, 183, 184,  83, 84, 85, 86, 87, 88]
BROKEN_LINES[(GameType.B3D, 2)] = [296, 297, 298, 299]
BROKEN_LINES[(GameType.B3D, 3)] = [84, 85, 86]
BROKEN_LINES[(GameType.B3D, 5)] = [316, 317, 318, 319]
BROKEN_LINES[(GameType.L3D, 1)] = [287, 288, 289, 290, 279, 280, 281, 282, 283, 284, 285, 286]
BROKEN_LINES[(GameType.L3D, 9)] = [276, 277, 278,  279, 280, 281,  422, 423, 424, 425,  442, 443, 444, 445]


BROKEN_TEXTURES_B3D = [ # Doors (inside) and 45 degree with middled texture inside
    {},
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

BROKEN_TEXTURES_L3D = [ # Doors (inside) and 45 degree with middled texture inside
    {},
    { # 1
        20 : BrokenTextureData(nums=[13]),
    },
    { # 2
        22 : BrokenTextureData(nums=[13]),
    },
    { # 3
        17 : BrokenTextureData(nums=[6]),
    },
    { # 4
        20 : BrokenTextureData(nums=[10]),
    },
    { #5
        15 : BrokenTextureData(nums=[6]),
    },
    { # 6
        22 : BrokenTextureData(nums=[10]),
        23 : BrokenTextureData(nums=[0]),
    },
    { # 7
        23 : BrokenTextureData(nums=[8]),
        24 : BrokenTextureData(nums=[8]),
    },
    { # 8
        20 : BrokenTextureData(nums=[3]),
        21 : BrokenTextureData(nums=[3]),
    },
    { # 9
        20 : BrokenTextureData(nums=[7]),
        21 : BrokenTextureData(nums=[7]),
    },
    { #10
        21 : BrokenTextureData(nums=[6]),
    },
]

BROKEN_TEXTURES = dict()
BROKEN_TEXTURES[GameType.B3D] = BROKEN_TEXTURES_B3D
BROKEN_TEXTURES[GameType.L3D] = BROKEN_TEXTURES_L3D


CRATE_TOP_TEXTURES_B3D = [
    [],
    ["CRATE_03", "CRATE_00"], #1
    ["CRATE_01", None], #2
    [None, None], #3
    ["CRATE_03", "CRATE_00"], #4
    ["CRATE_06", None], #5
    ["CRATE_05", None], #6
    ["CRATE_03", None], #7
    ["CRATE_03", "CRATE_00"], #8
    ["CRATE_05", None], #9
]

CRATE_TOP_TEXTURES_L3D = [
    [],
    ["CRATE_07"], #1
    ["CRATE_07"], #2
    ["CRATE_07"], #3
    ["CRATE_01"], #4
    ["CRATE_07"], #5
    ["CRATE_07"], #6
    ["CRATE_03"], #7
    ["CRATE_07"], #8
    ["CRATE_07"], #9
    ["CRATE_07"], #10
]

CRATE_TOP_TEXTURES = dict()
CRATE_TOP_TEXTURES[GameType.B3D] = CRATE_TOP_TEXTURES_B3D
CRATE_TOP_TEXTURES[GameType.L3D] = CRATE_TOP_TEXTURES_L3D


def fixFoeSprite(image: Image.Image, index: int) -> Image.Image:
    if image.mode != 'RGBA':
        raise Exception("is not rgba")
    pixels = image.load()
    pixels[1, 0] = (0, 0, 0, 0)
    if index == 3 and image.width == 38:
        image = image.crop((0, 0, 33, image.height))
    return image


SPRITE_SCALE_OVERRIDE: dict[tuple[GameType, int, int], float] = dict()
SPRITE_SCALE_OVERRIDE[(GameType.L3D, 1, 13)] = 1.3 # corpse
SPRITE_SCALE_OVERRIDE[(GameType.L3D, 1, 24)] = 1.0 # meat
SPRITE_SCALE_OVERRIDE[(GameType.L3D, 4, 28)] = 96/72 # water drop
SPRITE_SCALE_OVERRIDE[(GameType.L3D, 5, 41)] = 1.5 # skulls
SPRITE_SCALE_OVERRIDE[(GameType.L3D, 6, 32)] = 1.5 # coal
SPRITE_SCALE_OVERRIDE[(GameType.L3D, 6, 34)] = 0.8 # blood mess
SPRITE_SCALE_OVERRIDE[(GameType.L3D, 7, 37)] = 0.8 # vial
SPRITE_SCALE_OVERRIDE[(GameType.L3D, 7, 38)] = 0.5 # vial
SPRITE_SCALE_OVERRIDE[(GameType.L3D, 7, 39)] = 0.5 # vial
SPRITE_SCALE_OVERRIDE[(GameType.L3D, 7, 40)] = 0.5 # vial
SPRITE_SCALE_OVERRIDE[(GameType.L3D, 7, 41)] = 0.8 # blood mess
SPRITE_SCALE_OVERRIDE[(GameType.L3D, 9, 0)] = 1.5 # lamp
SPRITE_SCALE_OVERRIDE[(GameType.L3D, 9, 3)] = 1.5 # lamp
SPRITE_SCALE_OVERRIDE[(GameType.L3D, 9, 32)] = 1.3 # shovels
SPRITE_SCALE_OVERRIDE[(GameType.L3D, 9, 37)] = 1.5 # coal
SPRITE_SCALE_OVERRIDE[(GameType.L3D, 10, 13)] = 1.3 # corpse
SPRITE_SCALE_OVERRIDE[(GameType.L3D, 10, 24)] = 1.2 # martyr



BROKEN_THINGS: dict[tuple[GameType, int], list[int]] = dict()
BROKEN_THINGS[(GameType.B3D, 1)] = [24]
BROKEN_THINGS[(GameType.L3D, 3)] = [41]
BROKEN_THINGS[(GameType.L3D, 5)] = [51]
BROKEN_THINGS[(GameType.L3D, 7)] = [40]
BROKEN_THINGS[(GameType.L3D, 9)] = [23, 24, 29, 46, 72]

