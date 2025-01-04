import omg

wad = omg.WAD('C1M1.wad')
map = omg.UMapEditor(wad.udmfmaps.values()[0])


vertex : omg.UVertex = map.vertexes[0]
print('vertexes[0]:', vertex.to_textmap())

sector : omg.USector = map.sectors[0]
print('sectors[0]:', sector.to_textmap())

side : omg.USidedef = map.sidedefs[0]
print('sidedefs[0]:', side.to_textmap())

line : omg.ULinedef = map.linedefs[0]
print('linedefs[0]:', line.to_textmap())

# print(sector.defaults)
# print(map.scripts.data)

# behavior : omg.Lump = map.behavior
# print(behavior.data)

print('namespace:', map.namespace, '\n')

thing : omg.UThing = map.things[0]
print('things[0]:', thing.to_textmap())


