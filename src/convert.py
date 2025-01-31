from loadFromJava import load
from drawMap import drawMap
from ClassesInterim import MapInterim
from ClassesGZD import MapGZD
from ClassesShared import Animation
from save import saveMap, saveStaticData, saveTextures, saveAnimations

MAPS = range(1, 10)
MAPS = [1]

if __name__ == "__main__":
    saveStaticData()
    colorsCeiling = []
    colorsFloor = []
    animations: list[Animation] = []
    for idx in MAPS:
        data = load(idx)
        animations.extend(data.map.animations)
        mapInterim = MapInterim(data.map, data.brokenLines, data.doorsSpeed, data.doorsStartLineIdx)
        print(mapInterim.doors)
        drawMap(data.map, name=f'c1m{idx}', show=False)
        mapGZD = MapGZD(mapInterim)
        saveMap(map=mapGZD, mapIndex=idx)
        saveTextures(textures=data.map.textures, mapIndex=idx, colorCeiling=data.colorCeiling, colorFloor=data.colorFloor)
    saveAnimations(animations)

