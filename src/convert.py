from loadFromJava import load
from drawMap import drawMap
from ClassesInterim import MapInterim
from ClassesGZD import MapGZD, EdnumGZD, ModelGZD
from ClassesShared import Animation
from save import (saveMap, saveStaticData, saveTextures, saveAnimations, saveSprites, saveZScripts, saveEdnums,
    savePatches, saveTexturesDef, saveModels,
)

MAPS = range(1, 10)
# MAPS = [1]

if __name__ == "__main__":
    saveStaticData()
    colorsCeiling = []
    colorsFloor = []
    animations: list[Animation] = []
    texturesDefs: dict[str, dict[str, str]] = dict()
    zscripts: dict[str, list[str]] = dict()
    ednums: list[EdnumGZD] = []
    models: list[ModelGZD] = []
    for idx in MAPS:
        data = load(idx)
        animations.extend(data.map.animations)
        mapInterim = MapInterim(data.map, brokenLines=data.brokenLines, doorsSpeed=data.doorsSpeed,
                doorsStartLineIdx=data.doorsStartLineIdx, brokenTextures=data.brokenTextures, foeAngles=data.foeAngles,
                foeWalkDistances=data.foeWalkDistances,)
        mapName = f'c1m{idx}'
        drawMap(data.map, name=mapName, show=False)
        mapGZD = MapGZD(mapInterim, spawnPos=data.spawnPos, spawnAngle=data.spawnAngle, mapIndex=idx)
        saveMap(map=mapGZD, mapIndex=idx)
        saveTextures(textures=data.map.textures, mapIndex=idx, colorCeiling=data.colorCeiling, colorFloor=data.colorFloor)
        saveSprites(sprites=mapGZD.sprites, mapIndex=idx)
        savePatches(patches=mapGZD.patches, mapIndex=idx)
        zscripts[mapName] = [a.zscript for a in mapGZD.actors]
        ednums.extend([a.ednum for a in mapGZD.actors])
        texturesDefs[mapName] = mapGZD.texturesDefs
        models.extend(mapGZD.models)
    saveAnimations(animations)
    saveZScripts(zscripts)
    saveEdnums(ednums)
    saveTexturesDef(texturesDefs)
    saveModels(models)

