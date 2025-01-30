from loadFromJava import load
from drawMap import drawMap
from ClassesInterim import MapInterim
from ClassesGZD import MapGZD
from ClassesShared import Animation
from save import saveMap, saveStaticData, saveTextures, saveAnimations

if __name__ == "__main__":
    saveStaticData()
    colorsCeiling = []
    colorsFloor = []
    animations: list[Animation] = []
    for idx in range(9, 10):
        data = load(idx)
        animations.extend(data.map.animations)
        mapInterim = MapInterim(data.map, data.brokenLines)
        drawMap(mapInterim, name=f'c1m{idx}', show=False)
        mapGZD = MapGZD(mapInterim, startPos=data.startPos)
        saveMap(map=mapGZD, mapIndex=idx)
        saveTextures(textures=data.map.textures, mapIndex=idx, colorCeiling=data.colorCeiling, colorFloor=data.colorFloor)
    saveAnimations(animations)

