from loadFromJava import loadB3DMap
from drawMap import drawMap
from ClassesInterim import MapInterim
from ClassesGZD import MapGZD


for idx in range(1, 2):
    map = loadB3DMap(idx)
    map = MapInterim(map)
    drawMap(map, name=f'c1m{idx}', show=False)
    mapGZD = MapGZD(map)
    for i, x in enumerate(mapGZD.vertexes): print(f"{i}: {x}")
    for i, x in enumerate(mapGZD.sides): print(f"{i}: {x}")
    for i, x in enumerate(mapGZD.lines): print(f"{i}: {x}")


