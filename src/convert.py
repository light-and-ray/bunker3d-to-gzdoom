from loadFromJava import loadB3DMap
from drawMap import drawMap
from ClassesInterim import MapInterim


for idx in range(1, 10):
    map = loadB3DMap(idx)
    map = MapInterim(map)
    drawMap(map, name=f'c1m{idx}', show=False)
