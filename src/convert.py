from loadFromJava import load
from drawMap import drawMap
from ClassesInterim import MapInterim
from ClassesGZD import MapGZD
from saveMap import saveMap, saveMapInfo

saveMapInfo()

# for idx in range(1, 10):
#     data = load(idx)
#     mapInterim = MapInterim(data.map, data.brokenLines)
#     # drawMap(mapInterim, name=f'c1m{idx}', show=False)
#     mapGZD = MapGZD(mapInterim, startPos=data.startPos)
#     saveMap(map=mapGZD, mapIndex=idx)

