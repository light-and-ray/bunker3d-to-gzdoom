import shutil, os, pathlib
import omg
from PIL import Image
from ClassesGZD import MapGZD, TextureMode
from io import BytesIO

STATIC_DIR = "static"
RESULT_DIR = "result.d"
LIGHT_LEVEL = 160


def saveMap(map: MapGZD, mapIndex: int):
    umap = omg.UMapEditor()
    umap.namespace = "zdoom"

    umap.vertexes = [omg.UVertex(v.x, v.y) for v in map.vertexes]

    for sector in (map.sectorFull, map.sectorBottom):
        umap.sectors.append(omg.USector(textureceiling="CEIL1_1", texturefloor="FLOOR0_1",
            heightfloor=int(sector.heightFloor), heightceiling=int(sector.heightCeiling), lightlevel=LIGHT_LEVEL))

    for side in map.sides:
        umap.sidedefs.append(omg.USidedef(sector=side.sectorIdx))
        if side.mode == TextureMode.MIDDLE:
            umap.sidedefs[-1].texturemiddle = "B3D_T001"
        elif side.mode == TextureMode.TOP_AND_BOTTOM:
            umap.sidedefs[-1].texturebottom = "B3D_T001"
            umap.sidedefs[-1].texturetop = "B3D_T001"

    for line in map.lines:
        umap.linedefs.append(omg.ULinedef(v1=line.vertexStartIdx, v2=line.vertexEndIdx,
                                          sidefront=line.sideFrontIdx, sideback=line.sideBackIdx))
        if line.sideBackIdx is not None:
            umap.linedefs[-1].twosided = True

    print(f"{map.startPos=}")
    umap.things.append(omg.UThing(x=map.startPos[0], y=map.startPos[1], ednum=1))
    mapName = f'c1m{mapIndex}'
    wad = omg.WAD()
    wad.udmfmaps[mapName] = umap.to_lumps()
    wadPath = RESULT_DIR + "/maps/" + mapName + ".wad"
    os.makedirs(os.path.dirname(wadPath), exist_ok=True)
    wad.to_file(wadPath)


def saveTexturesWAD(textures: dict[str, Image.Image], mapIndex: int):
    wad = omg.WAD()
    for name, texture in textures.items():
        buffer = BytesIO()
        texture.save(buffer, format='PNG')
        wad.ztextures[name] = omg.Lump(buffer.getvalue())
    wadPath = RESULT_DIR + f"/textures/textures_c1m{mapIndex}.wad"
    os.makedirs(os.path.dirname(wadPath), exist_ok=True)
    wad.to_file(wadPath)


def saveTexturesPreview(textures: dict[str, Image.Image], mapIndex: int):
    for name, texture in textures.items():
        path = RESULT_DIR + f"/textures/c1m{mapIndex}/{name}.png"
        os.makedirs(os.path.dirname(path), exist_ok=True)
        texture.save(path)


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
