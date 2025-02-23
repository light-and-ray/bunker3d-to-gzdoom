from loadFromJava import load
from drawMap import drawMap
from ClassesInterim import MapInterim
from ClassesGZD import MapGZD, EdnumGZD
from ClassesShared import Animation
from save import saveMap, saveStaticData, saveTextures, saveAnimations, saveSprites, saveZScripts, saveEdnums

MAPS = range(1, 10)
# MAPS = [1]

if __name__ == "__main__":
    saveStaticData()
    colorsCeiling = []
    colorsFloor = []
    animations: list[Animation] = []
    zscripts: dict[str, list[str]] = dict()
    ednums: list[EdnumGZD] = []
    for idx in MAPS:
        data = load(idx)
        animations.extend(data.map.animations)
        mapInterim = MapInterim(data.map, data.brokenLines, data.doorsSpeed, data.doorsStartLineIdx, data.brokenTextures)
        mapName = f'c1m{idx}'
        drawMap(data.map, name=mapName, show=False)
        mapGZD = MapGZD(mapInterim, data.spawnPos, data.spawnAngle)
        saveMap(map=mapGZD, mapIndex=idx)
        saveTextures(textures=data.map.textures, mapIndex=idx, colorCeiling=data.colorCeiling, colorFloor=data.colorFloor)
        saveSprites(sprites=mapGZD.sprites, mapIndex=idx)
        zscripts[mapName] = mapGZD.zscripts
        ednums.extend(mapGZD.ednums)
    saveAnimations(animations)
    saveZScripts(zscripts)
    saveEdnums(ednums)

