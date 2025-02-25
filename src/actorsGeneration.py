from PIL import Image
from tools import isBottomRowTransparent
from ClassesInterim import LampSpecial

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
    if isPinnedToCeiling:
        code += "        +NOGRAVITY;\n"
        code += "        +SPAWNCEILING;\n"
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


_lampClassNameIdx = 0
def generateLampClassName():
    global _lampClassNameIdx
    result = f'B3DLamp{_lampClassNameIdx:03}'
    _lampClassNameIdx += 1
    return result

def generateLampZScript(className: str, spriteName: str, spriteA: Image.Image):
    code = ""
    code += f"class {className} : Actor\n"
    code +=  "{\n"
    code +=  "    Default\n"
    code +=  "    {\n"
    code += f"        Height {spriteA.height};\n"
    code += f"        DeathHeight {spriteA.height};\n"
    code += f"        Radius {spriteA.width};\n"
    code +=  "        Health 1;\n"
    code +=  "        +NOGRAVITY;\n"
    code +=  "        +DONTFALL;\n"
    code +=  "        +SHOOTABLE;\n"
    code +=  "        +DONTTHRUST;\n"
    code +=  "        +NOBLOOD;\n"
    code +=  "        +NOBLOODDECALS;\n"
    code +=  "        +SPAWNCEILING;\n"
    code +=  "    }\n"
    code +=  "    States\n"
    code +=  "    {\n"
    code +=  "        Spawn:\n"
    code += f"            TNT1 A 0 A_JumpIf(args[0] == {LampSpecial.ON.value}, \"LightON\");\n"
    code += f"            TNT1 A 0 A_JumpIf(args[0] == {LampSpecial.OFF.value}, \"LightOFF\");\n"
    code += f"            TNT1 A 0 A_JumpIf(args[0] == {LampSpecial.FLICK.value}, \"LightFLICK\");\n"
    code +=  "        LightON:\n"
    code += f"            {spriteName} A 5 ThrustThingZ(0,35,0,1);\n"
    code +=  "            Loop;\n"
    code +=  "        LightOFF:\n"
    code += f"            {spriteName} B 5 ThrustThingZ(0,35,0,1);\n"
    code +=  "            Loop;\n"
    code +=  "        LightFLICK:\n"
    code += f"            {spriteName} A 10 ThrustThingZ(0,35,0,1);\n"
    code += f"            {spriteName} B 20;\n"
    code +=  "            Loop;\n"
    code +=  "        Death:\n"
    code += f"            {spriteName} C 5 ThrustThingZ(0,35,0,1);\n"
    code +=  "            Loop;\n"
    code +=  "    }\n"
    code +=  "}\n"
    return code


# Scale 1.3; for npcs
