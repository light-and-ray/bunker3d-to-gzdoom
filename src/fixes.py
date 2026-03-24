from dataclasses import dataclass
from tools import WALL_HEIGHT
from ClassesShared import GameType
from enum import Enum
from PIL import Image


BROKEN_LINES: dict[tuple[GameType, int], list[int]] = {}
BROKEN_LINES[(GameType.B3D, 1)] = [145, 146, 147, 148,  181, 182, 183, 184,  83, 84, 85, 86, 87, 88]
BROKEN_LINES[(GameType.B3D, 2)] = [296, 297, 298, 299]
BROKEN_LINES[(GameType.B3D, 3)] = [84, 85, 86]
BROKEN_LINES[(GameType.B3D, 5)] = [316, 317, 318, 319]
BROKEN_LINES[(GameType.L3D, 1)] = [287, 288, 289, 290, 279, 280, 281, 282, 283, 284, 285, 286]
BROKEN_LINES[(GameType.L3D, 9)] = [276, 277, 278,  279, 280, 281,  422, 423, 424, 425,  442, 443, 444, 445]


@dataclass
class TextureOverrideData:
    nums: list[int] = None
    offset: float = None
    stretch: float = None

NONE_TEXTURES_B3D = [ # Doors (inside) and 45 degree with middled texture inside
    {},
    { # 1
        18 : TextureOverrideData(nums=[0, 13, 0], offset=WALL_HEIGHT-18),
        20 : TextureOverrideData(nums=[0]),
        19 : TextureOverrideData(nums=[6]),
        21 : TextureOverrideData(nums=[6]),
    },
    { # 2
        21 : TextureOverrideData(nums=[4]),
    },
    { # 3
        17 : TextureOverrideData(nums=[4]),
    },
    { # 4
        23 : TextureOverrideData(nums=[4]),
    },
    { #5
        18 : TextureOverrideData(nums=[0]),
        20 : TextureOverrideData(nums=[4]),
    },
    { # 6
        17 : TextureOverrideData(nums=[7]),
    },
    { # 7
        18 : TextureOverrideData(nums=[6]),
    },
    { # 8
        21 : TextureOverrideData(nums=[4]),
    },
    { # 9
        19 : TextureOverrideData(nums=[6]),
        20 : TextureOverrideData(nums=[6]),
    },
]

NONE_TEXTURES_L3D = [ # Doors (inside) and 45 degree with middled texture inside
    {},
    { # 1
        20 : TextureOverrideData(nums=[13]),
    },
    { # 2
        22 : TextureOverrideData(nums=[13]),
    },
    { # 3
        17 : TextureOverrideData(nums=[6]),
    },
    { # 4
        20 : TextureOverrideData(nums=[10]),
    },
    { #5
        15 : TextureOverrideData(nums=[6]),
    },
    { # 6
        22 : TextureOverrideData(nums=[10]),
        23 : TextureOverrideData(nums=[0]),
    },
    { # 7
        23 : TextureOverrideData(nums=[8]),
        24 : TextureOverrideData(nums=[8]),
    },
    { # 8
        20 : TextureOverrideData(nums=[3]),
        21 : TextureOverrideData(nums=[3]),
        # fix big fan
        # WARNING: editing like this breaks intermedial lines indexes
        100: TextureOverrideData(nums=[0, 20, 0], offset=WALL_HEIGHT-18, stretch=1.0),
    },
    { # 9
        20 : TextureOverrideData(nums=[7]),
        21 : TextureOverrideData(nums=[7]),
    },
    { #10
        21 : TextureOverrideData(nums=[6]),
    },
]

NONE_TEXTURES_C3D = [ # Doors (inside) and 45 degree with middled texture inside
    {},
    { # 1
        16 : TextureOverrideData(nums=[1]),
    },
    { # 2
        # 22 : TextureOverrideData(nums=[13]),
    },
    { # 3
        # 17 : TextureOverrideData(nums=[6]),
    },
    { # 4
        # 20 : TextureOverrideData(nums=[10]),
    },
    { #5
        # 15 : TextureOverrideData(nums=[6]),
    },
    { # 6
        # 22 : TextureOverrideData(nums=[10]),
        # 23 : TextureOverrideData(nums=[0]),
    },
    { # 7
        # 23 : TextureOverrideData(nums=[8]),
        # 24 : TextureOverrideData(nums=[8]),
    },
    { # 8
        # 20 : TextureOverrideData(nums=[3]),
        # 21 : TextureOverrideData(nums=[3]),
    },
    { # 9
        # 20 : TextureOverrideData(nums=[7]),
        # 21 : TextureOverrideData(nums=[7]),
    },
    { #10
        # 21 : TextureOverrideData(nums=[6]),
    },
    { #11
        # 21 : TextureOverrideData(nums=[6]),
    },
    { #12
        # 21 : TextureOverrideData(nums=[6]),
    },
    { #13
        # 21 : TextureOverrideData(nums=[6]),
    },
]

NONE_TEXTURES = dict()
NONE_TEXTURES[GameType.B3D] = NONE_TEXTURES_B3D
NONE_TEXTURES[GameType.L3D] = NONE_TEXTURES_L3D
NONE_TEXTURES[GameType.C3D] = NONE_TEXTURES_C3D

INTERMEDIAL_TEXTURES_OVERRIDES: dict[tuple[GameType, int], dict[int, TextureOverrideData]] = {}
INTERMEDIAL_TEXTURES_OVERRIDES[(GameType.L3D, 4)] = \
{
    40: TextureOverrideData(nums=[22]), # not animated glass texture for some reason
}
INTERMEDIAL_TEXTURES_OVERRIDES[(GameType.L3D, 6)] = \
{
    49: TextureOverrideData(nums=[0]), # accidentally broken texture over metal box
}
INTERMEDIAL_TEXTURES_OVERRIDES[(GameType.L3D, 7)] = \
{
    37: TextureOverrideData(offset=0), # broken offsets
    39: TextureOverrideData(offset=48),
}
INTERMEDIAL_TEXTURES_OVERRIDES[(GameType.L3D, 8)] = \
{
    303: TextureOverrideData(offset=0), # broken offsets
    304: TextureOverrideData(offset=48),
    58: TextureOverrideData(offset=0),
    59: TextureOverrideData(offset=48),
}

B3D_TEXTURES_OVERRIDES: dict[tuple[GameType, int], dict[int, int]] = {}
B3D_TEXTURES_OVERRIDES[(GameType.L3D, 8)] = { 122: 100, 104: 100, 79: 100 }


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
    ["CRATE_08"], #4
    ["CRATE_07"], #5
    ["CRATE_07"], #6
    ["CRATE_03", "CRATE_09"], #7
    ["CRATE_07", "CRATE_09"], #8
    ["CRATE_07"], #9
    ["CRATE_03"], #10
]

CRATE_TOP_TEXTURES_C3D = [
    [],
    ["CRATE_07"], #1
    ["CRATE_07"], #2
    ["CRATE_07"], #3
    ["CRATE_07"], #4
    ["CRATE_07"], #5
    ["CRATE_07"], #6
    ["CRATE_07"], #7
    ["CRATE_07"], #8
    ["CRATE_07"], #9
    ["CRATE_07"], #10
    ["CRATE_07"], #11
    ["CRATE_07"], #12
    ["CRATE_07"], #13
]

CRATE_TOP_TEXTURES = dict()
CRATE_TOP_TEXTURES[GameType.B3D] = CRATE_TOP_TEXTURES_B3D
CRATE_TOP_TEXTURES[GameType.L3D] = CRATE_TOP_TEXTURES_L3D
CRATE_TOP_TEXTURES[GameType.C3D] = CRATE_TOP_TEXTURES_C3D

BARREL_TOP_TEXTURES: dict[tuple[GameType, int], str] = {}
BARREL_TOP_TEXTURES[(GameType.L3D, 1)] = "BARR_TOP"
BARREL_TOP_TEXTURES[(GameType.L3D, 4)] = "BARR_TOP"
BARREL_TOP_TEXTURES[(GameType.L3D, 9)] = "BARR_TOP"


def fixFoeSprite(image: Image.Image, index: int) -> Image.Image:
    if image.mode != 'RGBA':
        raise Exception("is not rgba")
    pixels = image.load()
    pixels[1, 0] = (0, 0, 0, 0)
    if index == 3 and image.width == 38:
        image = image.crop((0, 0, 33, image.height))
    return image


SPRITE_SCALE_OVERRIDE: dict[tuple[GameType, int, int], float] = {}
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


BROKEN_THINGS: dict[tuple[GameType, int], list[int]] = {}
BROKEN_THINGS[(GameType.B3D, 1)] = [24]
BROKEN_THINGS[(GameType.L3D, 3)] = [41]
BROKEN_THINGS[(GameType.L3D, 5)] = [51]
BROKEN_THINGS[(GameType.L3D, 7)] = [40]
BROKEN_THINGS[(GameType.L3D, 9)] = [23, 24, 29, 46, 72]


LINE_REVERSE_FIXES: dict[tuple[GameType, int], list[int]] = {}
LINE_REVERSE_FIXES[(GameType.L3D, 4)] = [3]
LINE_REVERSE_FIXES[(GameType.L3D, 6)] = [52, 118]


class AltTextureType(Enum):
    LAMP_OFF = 'lamp_off'
    GLASS_BREAK = 'glass_break'

@dataclass
class AltTextureRawData:
    index: int
    type: AltTextureType
    mirror: bool = False

ALT_TEXTURE_VARIANT: dict[tuple[GameType, int], dict[int, AltTextureRawData]] = {}
ALT_TEXTURE_VARIANT[(GameType.L3D, 4)] = \
{
    22: AltTextureRawData(3, AltTextureType.GLASS_BREAK),
}
ALT_TEXTURE_VARIANT[(GameType.L3D, 6)] = \
{
    6: AltTextureRawData(5, AltTextureType.LAMP_OFF),
    26: AltTextureRawData(5, AltTextureType.LAMP_OFF, mirror=True),
}
ALT_TEXTURE_VARIANT[(GameType.L3D, 7)] = \
{
    13: AltTextureRawData(0, AltTextureType.LAMP_OFF),
}
ALT_TEXTURE_VARIANT[(GameType.L3D, 8)] = \
{
    4: AltTextureRawData(5, AltTextureType.GLASS_BREAK), # doesn't exist in the original
}
ALT_TEXTURE_VARIANT[(GameType.L3D, 10)] = \
{
    3: AltTextureRawData(4, AltTextureType.LAMP_OFF),
}


NO_LAMP_LIGHT_SPOT_LEVELS: list[tuple[GameType, int]] = [(GameType.B3D, 9)]


@dataclass
class DecorationData:
    zscriptClass: str = "BaseDecoration"
    numberOfSprites: int = 1
    solid: bool = False

DECORATION_DATA_FOR_SPRITE: dict[tuple[GameType, int], dict[int, DecorationData]] = {}
DECORATION_DATA_FOR_SPRITE[(GameType.L3D, 2)] = \
{
    32: DecorationData(zscriptClass="BaseSmallRadiusDecoration", solid=True), # table
    33: DecorationData(zscriptClass="BaseSmallRadiusDecoration", solid=True), # chair
}
DECORATION_DATA_FOR_SPRITE[(GameType.L3D, 4)] = \
{
    28: DecorationData(zscriptClass="BaseDrippingDecoration", numberOfSprites=3),
}
DECORATION_DATA_FOR_SPRITE[(GameType.L3D, 5)] = \
{
    41: DecorationData(zscriptClass="BaseSmallRadiusDecoration", solid=True), # skulls
}
DECORATION_DATA_FOR_SPRITE[(GameType.L3D, 6)] = \
{
    32: DecorationData(zscriptClass="BaseSmallRadiusDecoration", solid=True), # coal
}
DECORATION_DATA_FOR_SPRITE[(GameType.L3D, 7)] = \
{
    34: DecorationData(zscriptClass="BaseCurrentDischarge", numberOfSprites=3, solid=True),
}
DECORATION_DATA_FOR_SPRITE[(GameType.L3D, 8)] = \
{
    42: DecorationData(zscriptClass="BaseXYBillboardDecoration"), # blood
    43: DecorationData(zscriptClass="BaseXYBillboardDecoration"), # blood
}
DECORATION_DATA_FOR_SPRITE[(GameType.L3D, 9)] = \
{
    32: DecorationData(zscriptClass="BaseSmallRadiusDecoration", solid=True), # shovels
}
DECORATION_DATA_FOR_SPRITE[(GameType.L3D, 10)] = \
{
    24: DecorationData(zscriptClass="BaseMartyrNPC", numberOfSprites=4), # martyr but decoration
    32: DecorationData(zscriptClass="BaseCurrentDischargeCutScene", numberOfSprites=3, solid=True),
    35: DecorationData(zscriptClass="BaseXYBillboardDecoration"), # blood
    36: DecorationData(zscriptClass="BaseXYBillboardDecoration"), # blood
}


@dataclass
class NpcData:
    zscriptClass: str = "BaseHandsUpFriendlyNPC"
    numberOfSprites: int = 4
    deathScale: float = 1.8

NPC_DATA_FOR_SPRITE: dict[tuple[GameType, int], dict[int, DecorationData]] = {}
NPC_DATA_FOR_SPRITE[(GameType.L3D, 1)] = \
{
    24: NpcData(zscriptClass="BaseMeatFalseNPC", numberOfSprites=5),
}
NPC_DATA_FOR_SPRITE[(GameType.L3D, 2)] = \
{
    24: NpcData(deathScale=1.3), # fat worker
}
NPC_DATA_FOR_SPRITE[(GameType.L3D, 5)] = \
{
    24: NpcData(deathScale=1.3), # fat worker
    28: NpcData(zscriptClass="BaseFlamethrowerGuyNPC"),
    33: NpcData(deathScale=1.3), # bald worker
    37: NpcData(deathScale=1.3), # skinny worker
}
NPC_DATA_FOR_SPRITE[(GameType.L3D, 6)] = \
{
    24: NpcData(deathScale=1.3), # fat worker
}
NPC_DATA_FOR_SPRITE[(GameType.L3D, 7)] = \
{
    24: NpcData(zscriptClass="BaseMartyrNPC"),
}
NPC_DATA_FOR_SPRITE[(GameType.L3D, 8)] = \
{
    24: NpcData(zscriptClass="BaseMartyrNPC"),
    28: NpcData(zscriptClass="BaseFlamethrowerGuyNPC"),
}
NPC_DATA_FOR_SPRITE[(GameType.L3D, 9)] = \
{
    24: NpcData(deathScale=1.3), # fat worker
    28: NpcData(deathScale=1.3), # bald worker
    33: NpcData(deathScale=1.3), # skinny worker
}


TEXTURE_INDEX_TO_ANIMATION_DURATIONS: dict[tuple[GameType, int], dict[int, float]] = {}
TEXTURE_INDEX_TO_ANIMATION_DURATIONS[(GameType.L3D, 5)] = \
{
    7: 4, # furnace
}
TEXTURE_INDEX_TO_ANIMATION_DURATIONS[(GameType.L3D, 8)] = \
{
    14: 4, # computer
    9: 4.5, # bubbles
    6: 3.7, # big fan
}
