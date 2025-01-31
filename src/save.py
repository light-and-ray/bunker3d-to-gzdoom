import shutil, os, pathlib
import omg
from PIL import Image
from ClassesGZD import MapGZD, TextureMode
from ClassesShared import Animation
from tools import getCeilingLumpName, getFloorLumpName

STATIC_DIR = "static"
RESULT_DIR = "result.d"
LIGHT_LEVEL = 220 # 250 is the closest to the original


def saveMap(map: MapGZD, mapIndex: int):
    umap = omg.UMapEditor()
    umap.namespace = "zdoom"

    umap.vertexes = [omg.UVertex(v.x, v.y) for v in map.vertexes]

    for sector in (map.sectorFull, map.sectorBottom):
        umap.sectors.append(omg.USector(textureceiling=getCeilingLumpName(mapIndex), texturefloor=getFloorLumpName(mapIndex),
            heightfloor=int(sector.heightFloor), heightceiling=int(sector.heightCeiling), lightlevel=LIGHT_LEVEL))

    for side in map.sides:
        umap.sidedefs.append(omg.USidedef(sector=side.sectorIdx))
        if side.mode == TextureMode.MIDDLE:
            umap.sidedefs[-1].texturemiddle = side.textureMiddle
            umap.sidedefs[-1].offsetx_mid = side.offset
        elif side.mode == TextureMode.TOP_AND_BOTTOM:
            umap.sidedefs[-1].texturebottom = side.textureBottom
            umap.sidedefs[-1].texturetop = side.textureMiddle
            umap.sidedefs[-1].offsetx_bottom = side.offset
            umap.sidedefs[-1].offsetx_top = side.offset

    for line in map.lines:
        umap.linedefs.append(omg.ULinedef(v1=line.vertexStartIdx, v2=line.vertexEndIdx,
                                          sidefront=line.sideFrontIdx, sideback=line.sideBackIdx))
        if line.sideBackIdx is not None:
            umap.linedefs[-1].twosided = True

        if line.polyObjectDef:
            umap.linedefs[-1].special = 1
            umap.linedefs[-1].arg0 = line.polyObjectDef.number
            umap.linedefs[-1].arg1 = line.polyObjectDef.mirror
        if line.b3dDoorSpeed is not None:
            umap.linedefs[-1].user_b3d_door_speed = line.b3dDoorSpeed
        if line.b3dDoorBroken is not None:
            umap.linedefs[-1].user_b3d_door_broken = line.b3dDoorBroken
        if line.b3dDoorPOStartLine is not None:
            umap.linedefs[-1].user_b3d_door_po_start_line = line.b3dDoorPOStartLine

    umap.things.append(omg.UThing(x=0, y=0, ednum=1))
    mapName = f'c1m{mapIndex}'
    wad = omg.WAD()
    wad.udmfmaps[mapName] = umap.to_lumps()
    wadPath = RESULT_DIR + "/maps/" + mapName + ".wad"
    os.makedirs(os.path.dirname(wadPath), exist_ok=True)
    wad.to_file(wadPath)



def saveTextures(textures: dict[str, Image.Image], mapIndex: int, colorFloor: tuple[int], colorCeiling: tuple[int]):
    mapTexturesDir = RESULT_DIR + f"/textures/c1m{mapIndex}/"
    if os.path.exists(mapTexturesDir):
        shutil.rmtree(mapTexturesDir)
    os.makedirs(mapTexturesDir)
    path = f"{mapTexturesDir}/{getFloorLumpName(mapIndex)}.png"
    Image.new("RGB", (64, 64), color=colorFloor).save(path)
    path = f"{mapTexturesDir}/{getCeilingLumpName(mapIndex)}.png"
    Image.new("RGB", (64, 64), color=colorCeiling).save(path)

    for name, texture in textures.items():
        path = f"{mapTexturesDir}/{name}.png"
        texture.save(path)


def saveAnimations(animations: list[Animation]):
    animdefs = ""
    for animation in animations:
        animdefs += f"texture {animation.name}\n"
        for frame in animation.frames:
            animdefs += f"    pic {frame} tics {animation.duration}\n"
        animdefs += "\n"
    with open(RESULT_DIR + "/ANIMDEFS.txt", 'w') as f:
        f.write(animdefs)


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
