from loadFromJava import load
from drawMap import drawMap
from ClassesIntermedial import MapIntermedial
from ClassesGZD import MapGZD, EdnumGZD, ModelGZD
from ClassesShared import Animation, GameType
from save import (saveMap, saveStaticData, saveTextures, saveAnimations, saveSprites, saveZScripts, saveEdnums,
    savePatches, saveTexturesDef, saveModels, saveTexturesDef2x,
)

MAPS = [range(1, 10), range(1, 11)]
# MAPS = [[], [4]]
GAMES = [GameType.B3D, GameType.L3D]
# GAMES = [None, GameType.L3D]

if __name__ == "__main__":
    saveStaticData()
    animations: list[Animation] = []
    texturesDefs: dict[str, dict[str, str]] = dict()
    texturesDefs2x: dict[str, dict[str, str]] = dict()
    zscripts: dict[str, list[str]] = dict()
    ednums: list[EdnumGZD] = []
    models: list[ModelGZD] = []
    for game, maps in zip(GAMES, MAPS):
        if not maps or not game: continue
        for idx in maps:
            data = load(idx, game)
            animations.extend(data.map.animations)
            mapIntermedial = MapIntermedial(data.map, doorsSpeed=data.doorsSpeed,
                    doorsStartLineIdx=data.doorsStartLineIdx, foeAngles=data.foeAngles,
                    foeWalkDistances=data.foeWalkDistances, gameType=game, mapIndex=idx)
            mapName = f'c{game.value+1}m{idx}'
            drawMap(data.map, name=f"b3d/{mapName}", show=False)
            drawMap(mapIntermedial, name=f"inter/{mapName}", show=False)
            mapGZD = MapGZD(mapIntermedial, spawnPos=data.spawnPos, spawnAngle=data.spawnAngle, mapIndex=idx, gameType=game)
            saveMap(map=mapGZD, mapIndex=idx, game=game)
            saveTextures(textures=data.map.textures, mapIndex=idx, colorCeiling=data.colorCeiling, colorFloor=data.colorFloor, game=game)
            saveSprites(sprites=mapGZD.sprites, mapIndex=idx, game=game)
            savePatches(patches=mapGZD.patches, mapIndex=idx, game=game)
            zscripts[mapName] = [a.zscript for a in mapGZD.actors]
            ednums.extend([a.ednum for a in mapGZD.actors])
            texturesDefs[mapName] = mapGZD.texturesDefs
            texturesDefs2x[mapName] = mapGZD.texturesDefs2x
            models.extend(mapGZD.models)
    saveAnimations(animations)
    saveZScripts(zscripts)
    saveEdnums(ednums)
    saveTexturesDef(texturesDefs)
    saveTexturesDef2x(texturesDefs2x)
    saveModels(models)

