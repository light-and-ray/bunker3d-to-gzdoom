from loadFromJava import load
from drawMap import drawMap
from ClassesInterim import MapInterim
from ClassesGZD import MapGZD
from save import saveMap, saveStaticData, saveTexturesPreview, saveTexturesWAD

if __name__ == "__main__":
    saveStaticData()

    for idx in range(1, 2):
        data = load(idx)
        mapInterim = MapInterim(data.map, data.brokenLines)
        # drawMap(data.map, name=f'c1m{idx}', show=False)
        mapGZD = MapGZD(mapInterim, startPos=data.startPos)
        saveMap(map=mapGZD, mapIndex=idx)
        saveTexturesPreview(textures=data.map.textures, mapIndex=idx)
        saveTexturesWAD(textures=data.map.textures, mapIndex=idx)

