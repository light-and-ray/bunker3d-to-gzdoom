import omg
from loadFromJava import loadMap
from drawMap import draw_lines
from b3dClasses import MapB3D


for idx in range(1, 10):
    lines = loadMap(idx)
    map = MapB3D(lines)
    draw_lines(map.lines, name=f'c1m{idx}', show=False)
