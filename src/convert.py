from loadFromJava import load
from drawMap import drawMap
from ClassesInterim import MapInterim
from ClassesGZD import MapGZD
from save import saveMap, saveStaticData, saveTextures

if __name__ == "__main__":
    saveStaticData()
    colorsCeiling = []
    colorsFloor = []

    for idx in range(8, 9):
        data = load(idx)
        mapInterim = MapInterim(data.map, data.brokenLines)
        # drawMap(mapInterim, name=f'c1m{idx}', show=False)
        mapGZD = MapGZD(mapInterim, startPos=data.startPos)
        saveMap(map=mapGZD, mapIndex=idx)
        saveTextures(textures=data.map.textures, mapIndex=idx, colorCeiling=data.colorCeiling, colorFloor=data.colorFloor)

