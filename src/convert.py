from loadFromJava import load
from drawMap import drawMap
from ClassesInterim import MapInterim
from ClassesGZD import MapGZD, EdnumGZD
from ClassesShared import Animation
from save import (saveMap, saveStaticData, saveTextures, saveAnimations, saveSprites, saveZScripts, saveEdnums,
    savePatches, saveTexturesDef,
)

MAPS = range(1, 10)
# MAPS = [1]

if __name__ == "__main__":
    saveStaticData()
    colorsCeiling = []
    colorsFloor = []
    animations: list[Animation] = []
    texturesDefs: list[str] = []
    zscripts: dict[str, list[str]] = dict()
    ednums: list[EdnumGZD] = []
    for idx in MAPS:
        data = load(idx)
        animations.extend(data.map.animations)
        mapInterim = MapInterim(data.map, data.brokenLines, data.doorsSpeed, data.doorsStartLineIdx, data.brokenTextures)
        mapName = f'c1m{idx}'
        drawMap(data.map, name=mapName, show=False)
        mapGZD = MapGZD(mapInterim, data.spawnPos, data.spawnAngle, mapIndex=idx)
        saveMap(map=mapGZD, mapIndex=idx)
        saveTextures(textures=data.map.textures, mapIndex=idx, colorCeiling=data.colorCeiling, colorFloor=data.colorFloor)
        saveSprites(sprites=mapGZD.sprites, mapIndex=idx)
        savePatches(patches=mapGZD.patches, mapIndex=idx)
        zscripts[mapName] = [a.zscript for a in mapGZD.actors]
        ednums.extend([a.ednum for a in mapGZD.actors])
        texturesDefs.extend(mapGZD.texturesDefs)
    saveAnimations(animations)
    saveZScripts(zscripts)
    saveEdnums(ednums)
    saveTexturesDef(texturesDefs)

