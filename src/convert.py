from loadFromJava import loadB3DMap
from drawMap import draw_lines
from ClassesInterim import MapInterim


for idx in range(1, 2):
    map = loadB3DMap(idx)
    map = MapInterim(map)
    draw_lines(map, name=f'c1m{idx}', show=False)
