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
    code += f"class {className} : Actor\n"
    code +=  "{\n"
    code +=  "    Default\n"
    code +=  "    {\n"
    code += f"        Height {sprite.height};\n"
    code += f"        Radius {sprite.width};\n"
    # code += f"        +SOLID;\n"
    if isPinnedToCeiling:
        code += "        +NOGRAVITY;\n"
    code +=  "    }\n"
    code +=  "    States\n"
    code +=  "    {\n"
    code +=  "        Spawn:\n"
    code += f"            {spriteName} A 25"
    if isPinnedToCeiling:
        code += " ThrustThingZ(0,35,0,1)"
    code += ";\n"
    code +=  "            Loop;\n"
    code +=  "    }\n"
    code +=  "}\n"
    return code

# Scale 1.3; for npcs
