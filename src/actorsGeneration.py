from PIL import Image

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
    code += f"class {className} : Actor\n"
    code +=  "{\n"
    code +=  "    Default\n"
    code +=  "    {\n"
    code += f"        Height {sprite.height};\n"
    code += f"        Radius {sprite.width};\n"
    # code += f"        +SOLID;\n"
    code +=  "    }\n"
    code +=  "    States\n"
    code +=  "    {\n"
    code +=  "        Spawn:\n"
    code += f"            {spriteName} A -1;\n"
    code +=  "            Loop;\n"
    code +=  "    }\n"
    code +=  "}\n"
    return code
