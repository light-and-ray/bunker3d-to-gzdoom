from io import BytesIO
import shutil, os, pathlib
import omg
from PIL import Image
from ClassesGZD import MapGZD, TextureMode, EdnumGZD, ModelGZD
from ClassesShared import Animation, GameType
from tools import getCeilingLumpName, getFloorLumpName, addOffsets, saveToFile

STATIC_DIR = "static"
RESULT_DIR = "result.d"
LIGHT_LEVEL = 220 # 250 is the closest to the original


def saveMap(map: MapGZD, mapIndex: int, game: GameType):
    umap = omg.UMapEditor()
    umap.namespace = "zdoom"

    umap.vertexes = [omg.UVertex(v.x, v.y) for v in map.vertexes]

    for sector in map.sectors:
        umap.sectors.append(omg.USector(textureceiling=getCeilingLumpName(mapIndex, game), texturefloor=getFloorLumpName(mapIndex, game),
            heightfloor=int(sector.heightFloor), heightceiling=int(sector.heightCeiling), lightlevel=LIGHT_LEVEL))

    for side in map.sides:
        umap.sidedefs.append(omg.USidedef(sector=side.sectorIdx))
        if side.mode == TextureMode.MIDDLE:
            umap.sidedefs[-1].texturemiddle = side.textureMiddle
            umap.sidedefs[-1].offsetx_mid = side.offset
            umap.sidedefs[-1].scalex_mid = 1/side.stretch
        elif side.mode == TextureMode.TOP_AND_BOTTOM:
            umap.sidedefs[-1].texturebottom = side.textureBottom
            umap.sidedefs[-1].texturetop = side.textureTop
            umap.sidedefs[-1].offsetx_bottom = side.offset
            umap.sidedefs[-1].offsetx_top = side.offset
            umap.sidedefs[-1].scalex_bottom = 1/side.stretch
            umap.sidedefs[-1].scalex_top = 1/side.stretch

    for line in map.lines:
        umap.linedefs.append(omg.ULinedef(v1=line.v1, v2=line.v2,
                                          sidefront=line.sideFrontIdx, sideback=line.sideBackIdx))
        if line.sideBackIdx is not None:
            umap.linedefs[-1].twosided = True

        if line.polyObjectDef:
            umap.linedefs[-1].special = 1
            umap.linedefs[-1].arg0 = line.polyObjectDef.number
            umap.linedefs[-1].arg2 = line.polyObjectDef.soundSeq
        if line.b3dDoorSpeed is not None:
            umap.linedefs[-1].user_b3d_door_speed = float(line.b3dDoorSpeed)
        if line.b3dDoorBroken is not None:
            umap.linedefs[-1].user_b3d_door_broken = line.b3dDoorBroken
        if line.b3dDoorPONum is not None:
            umap.linedefs[-1].user_b3d_door_po_num = int(line.b3dDoorPONum)
        if line.b3dDoorPOx is not None:
            umap.linedefs[-1].user_b3d_door_po_x = float(line.b3dDoorPOx)
        if line.b3dDoorPOy is not None:
            umap.linedefs[-1].user_b3d_door_po_y = float(line.b3dDoorPOy)
        if line.b3dDoorBackSide is not None:
            umap.linedefs[-1].user_b3d_door_back_side = int(line.b3dDoorBackSide)
        if line.b3dDoorPOMirrorNum is not None:
            umap.linedefs[-1].user_b3d_door_po_mirror_num = int(line.b3dDoorPOMirrorNum)

    for thing in map.things:
        umap.things.append(omg.UThing(x=thing.x, y=thing.y, ednum=thing.type))
        umap.things[-1].skill1 = True
        umap.things[-1].skill2 = True
        umap.things[-1].skill3 = True
        umap.things[-1].skill4 = True
        umap.things[-1].skill5 = True
        umap.things[-1].single = True
        umap.things[-1].coop = True
        umap.things[-1].dm = True
        umap.things[-1].class1 = True
        umap.things[-1].class2 = True
        umap.things[-1].class3 = True
        umap.things[-1].angle = thing.angle
        umap.things[-1].arg0 = thing.arg0
        umap.things[-1].arg1 = thing.arg1

    mapName = f'c{game.value+1}m{mapIndex}'
    wad = omg.WAD()
    wad.udmfmaps[mapName] = umap.to_lumps()
    wadPath = RESULT_DIR + "/maps/" + mapName + ".wad"
    os.makedirs(os.path.dirname(wadPath), exist_ok=True)
    wad.to_file(wadPath)


def saveTextures(textures: dict[str, Image.Image], mapIndex: int, colorFloor: tuple[int], colorCeiling: tuple[int], game: GameType):
    mapTexturesDir = RESULT_DIR + f"/textures/c{game.value+1}m{mapIndex}/"
    if os.path.exists(mapTexturesDir):
        shutil.rmtree(mapTexturesDir)
    os.makedirs(mapTexturesDir)
    path = f"{mapTexturesDir}/{getFloorLumpName(mapIndex, game)}.png"
    Image.new("RGB", (64, 64), color=colorFloor).save(path)
    path = f"{mapTexturesDir}/{getCeilingLumpName(mapIndex, game)}.png"
    Image.new("RGB", (64, 64), color=colorCeiling).save(path)

    for name, texture in textures.items():
        path = f"{mapTexturesDir}/{name}.png"
        texture.save(path)


def saveSprites(sprites: dict[str, Image.Image], mapIndex: int, game: GameType):
    mapSpritesDir = RESULT_DIR + f"/sprites/c{game.value+1}m{mapIndex}/"
    if os.path.exists(mapSpritesDir):
        shutil.rmtree(mapSpritesDir)
    os.makedirs(mapSpritesDir)

    for name, sprite in sprites.items():
        buffer = BytesIO()
        sprite.save(buffer, format="PNG")
        buffer = addOffsets(buffer.getvalue(), sprite.width//2, sprite.height)
        saveToFile(mapSpritesDir + f"/{name}.png", buffer)

def savePatches(patches: dict[str, Image.Image], mapIndex: int, game: GameType):
    mapPatchesDir = RESULT_DIR + f"/patches/c{game.value+1}m{mapIndex}/"
    if os.path.exists(mapPatchesDir):
        shutil.rmtree(mapPatchesDir)
    os.makedirs(mapPatchesDir)
    for name, patch in patches.items():
        patch.save(mapPatchesDir + f"/{name}.png")

def saveAnimations(animations: list[Animation]):
    animdefs = ""
    for animation in animations:
        animdefs += f"texture {animation.name}\n"
        animdefs += f"    allowdecals\n"
        for frame in animation.frames:
            animdefs += f"    pic {frame} tics {animation.duration}\n"
        animdefs += "\n"
    saveToFile(RESULT_DIR + "/ANIMDEFS.generated", animdefs)

def saveTexturesDef(texturesDict: dict[str, dict[str, str]]):
    includes = ""
    for mapName, mapDict in texturesDict.items():
        for fileName, code in mapDict.items():
            path = f"textureDefs/{mapName}/{fileName}.txt"
            codePath = RESULT_DIR + "/" + path
            os.makedirs(os.path.dirname(codePath), exist_ok=True)
            saveToFile(codePath, code)
            includes += f'#include "{path}"\n'
    saveToFile(RESULT_DIR + "/TEXTURES.generated", includes)


def saveZScripts(zscriptsDict: dict[str, list[str]]):
    directory = RESULT_DIR + "/zscript/generated"
    if os.path.exists(directory):
        shutil.rmtree(directory)
    os.makedirs(directory)

    includes = ""
    for name in list(zscriptsDict.keys()):
        includes += f'#include "zscript/generated/{name}.zs"\n'
    saveToFile(directory + "/include.zs", includes)

    for name, zscripts in zscriptsDict.items():
        code = ""
        for zscript in zscripts:
            code += zscript + "\n\n"
        saveToFile(directory + f"/{name}.zs", code)


def saveEdnums(ednums: list[EdnumGZD]):
    code = ""
    code += "DoomEdNums\n"
    code += "{\n"
    for ednum in ednums:
        code += f'    {ednum.num} = "{ednum.className}"\n'
    code += "}\n"
    saveToFile(RESULT_DIR + "/MAPINFO.ednums", code)


def saveModels(models: list[ModelGZD]):
    modeldef = ""
    for model in models:
        modeldef += model.modelDef
        modeldef += "\n"
    saveToFile(RESULT_DIR + "/MODELDEF.generated", modeldef)

    for model in models:
        savePath = RESULT_DIR + "/" + model.modelPath
        os.makedirs(os.path.dirname(savePath), exist_ok=True)
        saveToFile(savePath, model.modelObj)


def _copyFileFromStatic(name: str):
    origin = STATIC_DIR + "/" + name
    dist = RESULT_DIR + "/" + name
    os.makedirs(os.path.dirname(dist), exist_ok=True)
    shutil.copy(origin, dist)


def saveStaticData():
    for file in pathlib.Path(STATIC_DIR).rglob('*'):
        if file.is_file():
            file = os.path.relpath(file, STATIC_DIR)
            _copyFileFromStatic(file)
