import omg
from loadMap import loadMap
from drawMap import draw_lines

wad = omg.WAD('MAP01.wad')
map = omg.UMapEditor(wad.udmfmaps.values()[0])


def prettifyACS(script) -> str:
    return str(script).replace('\\n', '\n').replace('\\t', '    ')

# vertex : omg.UVertex = map.vertexes[0]
# print('vertexes[0]:', vertex.to_textmap())

# sector : omg.USector = map.sectors[0]
# print('sectors[0]:', sector.to_textmap())

# side : omg.USidedef = map.sidedefs[0]
# print('sidedefs[0]:', side.to_textmap())

# line : omg.ULinedef = map.linedefs[0]
# print('linedefs[0]:', line.to_textmap())

# # for line in map.linedefs:
# #     print(line.to_textmap())

# print(sector.defaults)

# # script : str = map.scripts.data
# # print('scripts[0]:', prettifyACS(script), '\n')

# # behavior : omg.Lump = map.behavior
# # print(prettifyACS(behavior.data))

# print('namespace:', map.namespace, '\n')

# thing : omg.UThing = map.things[0]
# print('things[0]:', thing.to_textmap())


lines = loadMap("1 d (склад).b3d")
# lines = loadMap("2 b (казарма).b3d")
# lines = loadMap("3 o (офицерская).b3d")
draw_lines(lines)
