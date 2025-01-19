import omg
from loadFromJava import loadMap
from drawMap import draw_lines
from ClassesInterim import MapInterim


for idx in range(1, 2):
    map = loadMap(idx)
    draw_lines(map.lines, name=f'c1m{idx}', show=False)
    MapInterim(map)
