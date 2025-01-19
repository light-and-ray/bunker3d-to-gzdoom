import omg
from loadFromJava import loadMap
from drawMap import draw_lines
from ClassesB3D import MapB3D
import segmentsOverlap as segmentsOverlap


for idx in range(1, 2):
    map = loadMap(idx)
    draw_lines(map.lines, name=f'c1m{idx}', show=False)

# segmentsOverlap.test()
