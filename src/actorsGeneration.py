from PIL import Image
from tools import isBottomRowTransparent, isTopRowTransparent
from ClassesShared import GameType


_lastEdnum = 0
def generateEdnum():
    global _lastEdnum
    result = int(f'9{_lastEdnum:03}')
    _lastEdnum += 1
    return result

def generateGenericPatchTextureDef(patchName: str, spriteName: str, patch: Image.Image, mapIndex: int, game: GameType) -> str:
    textures = ""
    textures += f"Sprite {spriteName}, {patch.width}, {patch.height}\n"
    textures +=  "{\n"
    textures += f"    Patch \"patches/c{game.value+1}m{mapIndex}/{patchName}.png\", 0, 0\n"
    textures += f"    Offset {patch.width//2}, {patch.height}\n"
    textures +=  "}\n"
    return textures


_decorationSpriteNameIdx = 0
def generateDecorationSpriteName():
    global _decorationSpriteNameIdx
    result = f'D{_decorationSpriteNameIdx:03}'
    _decorationSpriteNameIdx += 1
    return result

_decorationClassNameIdx = 0
def generateDecorationClassName():
    global _decorationClassNameIdx
    result = f'B3DDecoration{_decorationClassNameIdx:03}'
    _decorationClassNameIdx += 1
    return result

def generateDecorationZScript(className: str, spriteName: str, sprite: Image.Image):
    code = ""
    isPinnedToCeiling = isBottomRowTransparent(sprite) and not isTopRowTransparent(sprite)
    baseClassName = "BaseCeilingDecoration" if isPinnedToCeiling else "BaseFloorDecoration"
    code += f"class {className} : {baseClassName}\n"
    code +=  "{\n"
    code +=  "    Default\n"
    code +=  "    {\n"
    code += f"        Height {sprite.height};\n"
    code += f"        Radius {sprite.width/2};\n"
    code +=  "    }\n"
    code +=  "    States\n"
    code +=  "    {\n"
    code +=  "        Spawn:\n"
    code += f"            {spriteName} C 0 NoDelay A_JumpIf(true, \"SpawnBase\");\n"
    code += f"            stop;\n"
    code +=  "    }\n"
    code +=  "}\n"
    return code


_lampSpriteNameIdx = 0
def generateLampSpriteName():
    global _lampSpriteNameIdx
    result = f'L{_lampSpriteNameIdx:03}'
    _lampSpriteNameIdx += 1
    return result

_lampClassNameIdx = 0
def generateLampClassName():
    global _lampClassNameIdx
    result = f'B3DLamp{_lampClassNameIdx:03}'
    _lampClassNameIdx += 1
    return result

def generateLampZScript(className: str, spriteName: str, spriteA: Image.Image):
    code = ""
    code += f"class {className} : BaseLamp\n"
    code +=  "{\n"
    code +=  "    Default\n"
    code +=  "    {\n"
    code += f"        Height {spriteA.height};\n"
    code += f"        DeathHeight {spriteA.height};\n"
    code += f"        Radius {spriteA.width/2};\n"
    code +=  "    }\n"
    code +=  "    States\n"
    code +=  "    {\n"
    code +=  "        Spawn:\n"
    code += f"            {spriteName} C 0 NoDelay A_JumpIf(true, \"SpawnBase\");\n"
    code += f"            stop;\n"
    code +=  "    }\n"
    code +=  "}\n"
    return code


_foeSpriteNameIdx = 0
def generateFoeSpriteName():
    global _foeSpriteNameIdx
    result = f'F{_foeSpriteNameIdx:03}'
    _foeSpriteNameIdx += 1
    return result

_foeClassNameIdx = 0
def generateFoeClassName():
    global _foeClassNameIdx
    result = f'B3DFoe{_foeClassNameIdx:03}'
    _foeClassNameIdx += 1
    return result

def generateFoeZScript(className: str, spriteName: str, sprite0: Image.Image, spriteCorpse: Image.Image):
    code = ""
    foeScale = 1.2
    code += f"class {className} : BaseFoe\n"
    code +=  "{\n"
    code +=  "    Default\n"
    code +=  "    {\n"
    code += f"        Height {sprite0.height*foeScale};\n"
    code += f"        DeathHeight {spriteCorpse.height*foeScale};\n"
    code += f"        Radius {sprite0.width*foeScale/2};\n"
    code +=  "    }\n"
    code +=  "    States\n"
    code +=  "    {\n"
    code +=  "        Spawn:\n"
    code += f"            {spriteName} A 0 NoDelay A_JumpIf(true, \"SpawnBase\");\n"
    code += f"            stop;\n"
    code +=  "    }\n"
    code +=  "}\n"
    return code

def generateFoeTexturesDef(patchName: str, patch: Image.Image, mapIndex: int, game: GameType) -> str:
    textures = ""
    patchSuffixes = ["_front", "_left", "_back", "_right"]
    rotationSuffixesList = [['9', '1', 'G'], ['B', '3', 'A', '2'], ['4', 'C', '5', 'D', '6'], ['E', '7', 'F', '8']]
    for patchSuffix, rotationSuffixes in zip(patchSuffixes, rotationSuffixesList):
        if patchName.endswith(patchSuffix):
            baseName = patchName.removesuffix(patchSuffix)
            for rotationSuffix in rotationSuffixes:
                spriteName = baseName + rotationSuffix
                textures += generateGenericPatchTextureDef(patchName, spriteName, patch, mapIndex, game)
                textures += "\n"
    return textures



_npcSpriteNameIdx = 0
def generateNpcSpriteName():
    global _npcSpriteNameIdx
    result = f'N{_npcSpriteNameIdx:03}'
    _npcSpriteNameIdx += 1
    return result

_friendlyClassNameIdx = 0
def generateFriendlyClassName():
    global _friendlyClassNameIdx
    result = f'B3DFriendly{_friendlyClassNameIdx:03}'
    _friendlyClassNameIdx += 1
    return result

def generateFriendlyZScript(className: str, spriteName: str, spriteA: Image.Image, spriteCorpse: Image.Image):
    code = ""
    friendlyScale = 1.3
    code += f"class {className} : BaseFriendly\n"
    code +=  "{\n"
    code +=  "    Default\n"
    code +=  "    {\n"
    code += f"        Height {spriteA.height*friendlyScale};\n"
    code += f"        DeathHeight {spriteCorpse.height*friendlyScale};\n"
    code += f"        Radius {spriteA.width/2*friendlyScale};\n"
    code +=  "    }\n"
    code +=  "    States\n"
    code +=  "    {\n"
    code +=  "        Spawn:\n"
    code += f"            {spriteName} A 0 NoDelay A_JumpIf(true, \"SpawnBase\");\n"
    code += f"            stop;\n"
    code +=  "    }\n"
    code +=  "}\n"
    return code


_crateSpriteNameIdx = 0
def generateCrateSpriteName():
    global _crateSpriteNameIdx
    result = f'C{_crateSpriteNameIdx:03}'
    _crateSpriteNameIdx += 1
    return result

_crateClassNameIdx = 0
def generateCrateClassName():
    global _crateClassNameIdx
    result = f'B3DCrate{_crateClassNameIdx:03}'
    _crateClassNameIdx += 1
    return result

def generateCrateZScript(className: str, spriteName: str):
    code = ""
    code += f"class {className} : BaseCrate\n"
    code +=  "{\n"
    code +=  "    Default\n"
    code +=  "    {\n"
    code +=  "    }\n"
    code +=  "    States\n"
    code +=  "    {\n"
    code +=  "        Spawn:\n"
    code += f"            {spriteName} B 0 NoDelay A_JumpIf(true, \"SpawnBase\");\n"
    code += f"            stop;\n"
    code +=  "    }\n"
    code +=  "}\n"
    return code

def generateCrateObj(sideTextureName: str, topTextureName: str):
    code = ""
    code +=  "\n"
    code +=  "v 0.0 0.0 0.0\n"
    code +=  "v 1.0 0.0 0.0\n"
    code +=  "v 1.0 1.0 0.0\n"
    code +=  "v 0.0 1.0 0.0\n"
    code +=  "v 0.0 0.0 1.0\n"
    code +=  "v 1.0 0.0 1.0\n"
    code +=  "v 1.0 1.0 1.0\n"
    code +=  "v 0.0 1.0 1.0\n"
    code +=  "\n"
    code +=  "vt 0.0 0.0\n"
    code +=  "vt 1.0 0.0\n"
    code +=  "vt 1.0 1.0\n"
    code +=  "vt 0.0 1.0\n"
    code +=  "\n"
    code +=  "vn 0.0 0.0 1.0\n"
    code +=  "vn 0.0 1.0 0.0\n"
    code +=  "vn 0.0 0.0 -1.0\n"
    code +=  "vn 0.0 -1.0 0.0\n"
    code +=  "vn 1.0 0.0 0.0\n"
    code +=  "vn -1.0 0.0 0.0\n"
    code +=  "\n"
    code +=  "g top\n"
    code += f"usemtl {topTextureName}\n"
    code +=  "f 3/3/4 4/4/4 8/1/4 7/2/4\n"
    code +=  "\n"
    code +=  "g side 1\n"
    code += f"usemtl {sideTextureName}\n"
    code +=  "f 5/1/6 6/2/6 7/3/6 8/4/6\n"
    code +=  "\n"
    code +=  "g side 2\n"
    code += f"usemtl {sideTextureName}\n"
    code +=  "f 2/2/3 3/3/3 7/4/3 6/1/3\n"
    code +=  "\n"
    code +=  "g side 3\n"
    code += f"usemtl {sideTextureName}\n"
    code +=  "f 1/2/1 2/1/1 3/4/1 4/3/1\n"
    code +=  "\n"
    code +=  "g side 4\n"
    code += f"usemtl {sideTextureName}\n"
    code +=  "f 4/4/5 1/1/5 5/2/5 8/3/5\n"
    code +=  "\n"
    code +=  "g bottom\n"
    code += f"usemtl {topTextureName}\n"
    code +=  "f 1/1/2 2/2/2 6/3/2 5/4/2\n"
    return code

def generateCrateModeldef(spriteName: str, className: str, modelPath: str):
    code = ""
    code += f"Model {className}\n"
    code +=  "{\n"
    code += f"    Model 0 \"{modelPath}\"\n"
    code +=  "    Scale 48.0 48.0 48.0\n"
    code +=  "    Offset -24 24 0\n"
    code += f"    FrameIndex {spriteName} A 0 0\n"
    code +=  "}\n"
    return code

def generateCrateModelReplacementTextureDef(spriteName: str, textureName: str, texture: Image.Image, mapIndex: int, game: GameType):
    textures = ""
    textures += f"Sprite {spriteName}, {texture.width}, {texture.height}\n"
    textures +=  "{\n"
    textures += f"    Patch \"textures/c{game.value+1}m{mapIndex}/{textureName}.png\", 0, 0\n"
    textures += f"    Offset {texture.width//2}, {texture.height}\n"
    textures +=  "}\n"
    return textures

