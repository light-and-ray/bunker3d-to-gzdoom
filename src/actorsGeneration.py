from PIL import Image
from tools import isBottomRowTransparent, isTopRowTransparent
from ClassesShared import GameType
from fixes import DecorationData, NpcData

_lastEdnum = 0
def generateEdnum():
    global _lastEdnum
    result = int(f'9{_lastEdnum:03}')
    _lastEdnum += 1
    return result

def generateGenericPatchTextureDef(patchName: str, spriteName: str, patch: Image.Image, mapIndex: int, game: GameType, scale2x: bool) -> str:
    textures = ""
    width = patch.width
    height = patch.height
    if scale2x:
        width *= 2
        height *= 2
    textures += f"Sprite {spriteName}, {width}, {height}\n"
    textures +=  "{\n"
    textures += f"    Patch \"patches/c{game.value+1}m{mapIndex}/{patchName}.png\", 0, 0\n"
    if scale2x:
        textures += "    XScale 2\n"
        textures += "    YScale 2\n"
    textures += f"    Offset {width//2}, {height}\n"
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

def generateDecorationZScript(className: str, spriteName: str, sprite: Image.Image, scaleOverride: float|None, decorationData: DecorationData):
    if scaleOverride is not None:
        scaleFactor = scaleOverride
    else:
        scaleFactor = 1.0
    code = ""
    isPinnedToCeiling = isBottomRowTransparent(sprite) and not isTopRowTransparent(sprite)
    code += f"class {className} : {decorationData.zscriptClass}\n"
    code +=  "{\n"
    code +=  "    Default\n"
    code +=  "    {\n"
    code += f"        Height {sprite.height*scaleFactor};\n"
    code += f"        Radius {sprite.width/2*scaleFactor};\n"
    if scaleOverride is not None:
        code += f"        Scale {scaleOverride};\n"
    if isPinnedToCeiling:
        code += f"        +NOGRAVITY;\n"
        code += f"        +SPAWNCEILING;\n"
    if decorationData.solid:
        code += f"        +SOLID;\n"
    code +=  "    }\n"
    code +=  "    States\n"
    code +=  "    {\n"
    code +=  "        Spawn:\n"
    code += f"            {spriteName} A 0 NoDelay A_JumpIf(true, \"SpawnBase\");\n"
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

def generateLampZScript(className: str, spriteName: str, spriteA: Image.Image, scaleOverride: float|None, isFloor, needLightSpot):
    if scaleOverride is not None:
        scaleFactor = scaleOverride
    else:
        scaleFactor = 1.0
    baseClassName = "BaseCeilingLamp" if not isFloor else "BaseFloorLamp"
    code = ""
    code += f"class {className} : {baseClassName}\n"
    code +=  "{\n"
    code +=  "    Default\n"
    code +=  "    {\n"
    code += f"        Height {spriteA.height*scaleFactor};\n"
    code += f"        DeathHeight {spriteA.height*scaleFactor};\n"
    code += f"        Radius {spriteA.width/2*scaleFactor};\n"
    if scaleOverride is not None:
        code += f"        Scale {scaleOverride};\n"
    code +=  "    }\n"
    code +=  "    States\n"
    code +=  "    {\n"
    code +=  "        Spawn:\n"
    code += f"            {spriteName} C 0 NoDelay A_JumpIf(true, \"SpawnBase\");\n"
    code += f"            stop;\n"
    code +=  "    }\n"
    code +=  "    override void PostBeginPlay()\n"
    code +=  "    {\n"
    code += f"        needLightSpot = {needLightSpot};\n"
    code +=  "        super.PostBeginPlay();\n"
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

def generateFoeTexturesDef(patchName: str, patch: Image.Image, mapIndex: int, game: GameType, scale2x: bool) -> str:
    textures = ""
    patchSuffixes = ["_front", "_left", "_back", "_right"]
    rotationSuffixesList = [['9', '1', 'G'], ['B', '3', 'A', '2'], ['4', 'C', '5', 'D', '6'], ['E', '7', 'F', '8']]
    for patchSuffix, rotationSuffixes in zip(patchSuffixes, rotationSuffixesList):
        if patchName.endswith(patchSuffix):
            baseName = patchName.removesuffix(patchSuffix)
            for rotationSuffix in rotationSuffixes:
                spriteName = baseName + rotationSuffix
                textures += generateGenericPatchTextureDef(patchName, spriteName, patch, mapIndex, game, scale2x)
                textures += "\n"
    return textures



_npcSpriteNameIdx = 0
def generateNpcSpriteName():
    global _npcSpriteNameIdx
    result = f'N{_npcSpriteNameIdx:03}'
    _npcSpriteNameIdx += 1
    return result

_npcClassNameIdx = 0
def generateNpcClassName():
    global _npcClassNameIdx
    result = f'B3DNpc{_npcClassNameIdx:03}'
    _npcClassNameIdx += 1
    return result

def generateNpcZScript(className: str, spriteName: str, spriteA: Image.Image, spriteCorpse: Image.Image, scaleOverride: float|None, npcData: NpcData):
    code = ""
    if scaleOverride is not None:
        scaleFactor = scaleOverride
    else:
        scaleFactor = 1.3
    code += f"class {className} : {npcData.zscriptClass}\n"
    code +=  "{\n"
    code +=  "    Default\n"
    code +=  "    {\n"
    code += f"        Height {spriteA.height*scaleFactor};\n"
    code += f"        DeathHeight {spriteCorpse.height*scaleFactor};\n"
    code += f"        Radius {spriteA.width/2*scaleFactor};\n"
    if scaleOverride is not None:
        code += f"        Scale {scaleOverride};\n"
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

def generateModelReplacementTextureDef(spriteName: str, textureName: str, texture: Image.Image, mapIndex: int, game: GameType):
    textures = ""
    textures += f"Sprite {spriteName}, {texture.width}, {texture.height}\n"
    textures +=  "{\n"
    textures += f"    Patch \"textures/c{game.value+1}m{mapIndex}/{textureName}.png\", 0, 0\n"
    textures += f"    Offset {texture.width//2}, {texture.height}\n"
    textures +=  "}\n"
    return textures


_barrelSpriteNameIdx = 0
def generateBarrelSpriteName():
    global _barrelSpriteNameIdx
    result = f'BAR{_barrelSpriteNameIdx}'
    _barrelSpriteNameIdx += 1
    return result

_barrelClassNameIdx = 0
def generateBarrelClassName():
    global _barrelClassNameIdx
    result = f'B3DBarrel{_barrelClassNameIdx:03}'
    _barrelClassNameIdx += 1
    return result

def generateBarrelZScript(className: str, spriteName: str):
    code = ""
    code += f"class {className} : BaseBarrel\n"
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

def generateBarrelObj(sideTextureName: str, topTextureName: str):
    code = f'''
# Blender 4.1.1
# www.blender.org
o Cylinder
v 0.000000 0.000000 -27.817490
v 0.000000 48.000000 -27.817490
v 13.908745 0.000000 -24.090652
v 13.908745 48.000000 -24.090652
v 24.090652 0.000000 -13.908745
v 24.090652 48.000000 -13.908745
v 27.817490 0.000000 0.000000
v 27.817490 48.000000 0.000000
v 24.090652 0.000000 13.908745
v 24.090652 48.000000 13.908745
v 13.908745 0.000000 24.090652
v 13.908745 48.000000 24.090652
v 0.000000 0.000000 27.817490
v 0.000000 48.000000 27.817490
v -13.908745 0.000000 24.090652
v -13.908745 48.000000 24.090652
v -24.090652 0.000000 13.908745
v -24.090652 48.000000 13.908745
v -27.817490 0.000000 0.000000
v -27.817490 48.000000 0.000000
v -24.090652 0.000000 -13.908745
v -24.090652 48.000000 -13.908745
v -13.908745 0.000000 -24.090652
v -13.908745 48.000000 -24.090652
vn 0.2588 -0.0000 -0.9659
vn 0.7071 -0.0000 -0.7071
vn 0.9659 -0.0000 -0.2588
vn 0.9659 -0.0000 0.2588
vn 0.7071 -0.0000 0.7071
vn 0.2588 -0.0000 0.9659
vn -0.2588 -0.0000 0.9659
vn -0.7071 -0.0000 0.7071
vn -0.9659 -0.0000 0.2588
vn -0.9659 -0.0000 -0.2588
vn -0.0000 1.0000 -0.0000
vn -0.7071 -0.0000 -0.7071
vn -0.2588 -0.0000 -0.9659
vn -0.0000 -1.0000 -0.0000
vt 4.000000 1.000000
vt 3.666667 0.000000
vt 4.000000 0.000000
vt 3.666667 1.000000
vt 3.333333 0.000000
vt 3.333333 1.000000
vt 3.000000 0.000000
vt 3.000000 1.000000
vt 2.666667 0.000000
vt 2.666667 1.000000
vt 2.333333 0.000000
vt 2.333333 1.000000
vt 2.000000 0.000000
vt 2.000000 1.000000
vt 1.666667 0.000000
vt 1.666667 1.000000
vt 1.333333 0.000000
vt 1.333333 1.000000
vt 1.000000 0.000000
vt 1.000000 1.000000
vt 0.666667 0.000000
vt 1.000000 0.500000
vt 0.250000 0.066987
vt 0.250000 0.933013
vt 0.666667 1.000000
vt 0.333333 0.000000
vt 0.333333 1.000000
vt 0.000000 0.000000
vt 0.500000 1.000000
vt 0.750000 0.933013
vt 0.933013 0.750000
vt 0.933013 0.250000
vt 0.750000 0.066987
vt 0.500000 0.000000
vt 0.066987 0.250000
vt 0.000000 0.500000
vt 0.066987 0.750000
vt 0.000000 1.000000
s 0
usemtl {topTextureName}
f 22/22/11 14/23/11 6/24/11
f 7/22/14 15/23/14 23/24/14
f 6/24/11 4/29/11 2/30/11
f 2/30/11 24/31/11 22/22/11
f 22/22/11 20/32/11 14/23/11
f 20/32/11 18/33/11 14/23/11
f 18/33/11 16/34/11 14/23/11
f 14/23/11 12/35/11 10/36/11
f 10/36/11 8/37/11 14/23/11
f 8/37/11 6/24/11 14/23/11
f 6/24/11 2/30/11 22/22/11
f 23/24/14 1/29/14 7/22/14
f 1/29/14 3/30/14 7/22/14
f 3/30/14 5/31/14 7/22/14
f 7/22/14 9/32/14 11/33/14
f 11/33/14 13/34/14 7/22/14
f 13/34/14 15/23/14 7/22/14
f 15/23/14 17/35/14 19/36/14
f 19/36/14 21/37/14 23/24/14
f 15/23/14 19/36/14 23/24/14
usemtl {sideTextureName}
f 2/1/1 3/2/1 1/3/1
f 4/4/2 5/5/2 3/2/2
f 6/6/3 7/7/3 5/5/3
f 8/8/4 9/9/4 7/7/4
f 10/10/5 11/11/5 9/9/5
f 12/12/6 13/13/6 11/11/6
f 14/14/7 15/15/7 13/13/7
f 16/16/8 17/17/8 15/15/8
f 18/18/9 19/19/9 17/17/9
f 20/20/10 21/21/10 19/19/10
f 22/25/12 23/26/12 21/21/12
f 24/27/13 1/28/13 23/26/13
f 2/1/1 4/4/1 3/2/1
f 4/4/2 6/6/2 5/5/2
f 6/6/3 8/8/3 7/7/3
f 8/8/4 10/10/4 9/9/4
f 10/10/5 12/12/5 11/11/5
f 12/12/6 14/14/6 13/13/6
f 14/14/7 16/16/7 15/15/7
f 16/16/8 18/18/8 17/17/8
f 18/18/9 20/20/9 19/19/9
f 20/20/10 22/25/10 21/21/10
f 22/25/12 24/27/12 23/26/12
f 24/27/13 2/38/13 1/28/13

'''
    return code

def generateBarrelModeldef(spriteName: str, className: str, modelPath: str):
    code = ""
    code += f"Model {className}\n"
    code +=  "{\n"
    code += f"    Model 0 \"{modelPath}\"\n"
    code +=  "    Scale 1.0 1.0 1.0\n"
    code +=  "    Offset 0 0 0\n"
    code += f"    FrameIndex {spriteName} A 0 0\n"
    code +=  "}\n"
    return code

