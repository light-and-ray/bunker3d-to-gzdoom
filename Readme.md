Need to do list [15/24]:
- [x] filter things using triggers
- [x] sprite scale mechanism
- [x] remove broken things
- [x] floor lamps
- [x] fix animated big fan texture
- [x] fix broken lines in l3d levels
- [x] add lamp light on walls
- [x] add lamp light on floor
- [x] breakable glass
- [x] add RPG
- [x] explosive barrels
- [x] fix broken texture offset in constructions
- [x] animated decorations
- [x] friendly NPC AI
- [x] sync current discharge sprite and wall


- [ ] ends of levels
- [ ] broken door logic
- [ ] add pistols
- [ ] add chaingun
- [ ] flamethrower guy AI
- [ ] foe AI
- [ ] crates logic
- [ ] smart cutter for TOP lines
- [ ] lightnings

## Bunker3D to GZDoom

The goal of this project is to port all the maps and resources from an old 2006-2008 j2me mobile FPS game trilogy: Bunker3D, Laboratory3D and Castle3D by Netsoftware on [GZDoom](https://github.com/ZDoom/gzdoom)/[UZDoom](https://github.com/UZDoom/UZDoom) engine. The project is planned to serve as a base for a further enhanced port

![](readmeImages/screenshot1.png)


#### How the porting/resource conversion process works in general terms:

1. A part of the code that loads data into RAM during level loading was extracted from the decompiled original game code, and data in this format is saved to .json. Initially, I wanted to write a resource parser myself, but it turned out that the data is very tightly compressed, and essentially the level is reconstructed using a small set of parameters. This makes sense - the game files for version 1.0 weigh less than 100KB, which is orders of magnitude smaller than classic games from the 90s.
2. The entire conversion process takes place in Python code. Data from the .json files is loaded and organized into something more or less meaningful in terms of structure.
3. Data is converted into an intermediate format based on the logic of engines more familiar to Doom. For example, in Doom, there can only be one texture on a single wall, whereas in Bunker, there is a whole array of textures from left to right.
4. Data from the format "familiar" to Doom is converted into one compatible with it. For instance, sectors are created for different floor and ceiling levels, and walls are sliced into Sidedefs, Linedefs, etc.
5. The resulting resources are saved as UDMF format maps, and TEXTUREDEF, ANIMATEDEF, MODELDEF files, etc., which can already work with GZDoom/UZDoom.

### Dependencies

Requires `python`, `java`, `javac` and python dependencies listed below. To run the program extract the original games into `./jars/...` folders, and use `./convert.sh` to convert

```bash
python -m venv env
. env/bin/activate
pip install omgifol pillow svgwrite

```

#### Fonts

To write any text in the games' fonts I've made script in `bin/font`. Use it, or a hosted version of this script online: https://huggingface.co/spaces/light-and-ray/bunker3d-fonts
