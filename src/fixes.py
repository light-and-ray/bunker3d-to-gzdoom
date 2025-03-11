from dataclasses import dataclass
from tools import WALL_HEIGHT
from ClassesShared import GameType


@dataclass
class BrokenTextureData:
    nums: list[int]
    offset: float = None
    stretch: float = 1.0


BROKEN_LINES_B3D = [
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

BROKEN_LINES_L3D = [
    [],
    [287, 288, 289, 290, 279, 280, 281, 282, 283, 284, 285, 286], #1
    [], #2
    [], #3
    [], #4
    [], #5
    [], #6
    [], #7
    [], #8
    [], #9
    [], #10
]

BROKEN_LINES = dict()
BROKEN_LINES[GameType.B3D] = BROKEN_LINES_B3D
BROKEN_LINES[GameType.L3D] = BROKEN_LINES_L3D


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
