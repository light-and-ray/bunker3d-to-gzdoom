import omg
from loadFromJava import loadMap
from drawMap import draw_lines
from ClassesB3D import MapB3D
import src.segmentsOverlap as segmentsOverlap


# for idx in range(1, 10):
#     lines = loadMap(idx)
#     map = MapB3D(lines)
#     draw_lines(map.lines, name=f'c1m{idx}', show=False)

segmentsOverlap.test()
