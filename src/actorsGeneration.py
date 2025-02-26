from PIL import Image
from tools import isBottomRowTransparent

_spriteNameIdx = 0
def generateSpriteName():
    global _spriteNameIdx
    result = f'S{_spriteNameIdx:03}'
    _spriteNameIdx += 1
    return result

_lastEdnum = 0
def generateEdnum():
    global _lastEdnum
    result = int(f'9{_lastEdnum:03}')
    _lastEdnum += 1
    return result


_decorationClassNameIdx = 0
def generateDecorationClassName():
    global _decorationClassNameIdx
    result = f'B3DDecoration{_decorationClassNameIdx:03}'
    _decorationClassNameIdx += 1
    return result

def generateDecorationZScript(className: str, spriteName: str, sprite: Image.Image):
    code = ""
    isPinnedToCeiling = isBottomRowTransparent(sprite)
    baseClassName = "BaseCeilingDecoration" if isPinnedToCeiling else "BaseFloorDecoration"
    code += f"class {className} : {baseClassName}\n"
    code +=  "{\n"
    code +=  "    Default\n"
    code +=  "    {\n"
    code += f"        Height {sprite.height};\n"
    code += f"        Radius {sprite.width};\n"
    code +=  "    }\n"
    code +=  "    States\n"
    code +=  "    {\n"
    code +=  "        Spawn:\n"
    code += f"            {spriteName} C 0 NoDelay A_JumpIf(true, \"SpawnBase\");\n"
    code += f"            stop;\n"
    code +=  "    }\n"
    code +=  "}\n"
    return code


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
    code += f"        Radius {spriteA.width};\n"
    code +=  "    }\n"
    code +=  "    States\n"
    code +=  "    {\n"
    code +=  "        Spawn:\n"
    code += f"            {spriteName} C 0 NoDelay A_JumpIf(true, \"SpawnBase\");\n"
    code += f"            stop;\n"
    code +=  "    }\n"
    code +=  "}\n"
    return code


# Scale 1.3; for npcs
