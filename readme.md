The goal of this project is to port maps and all the resources from an old 2005-2008 j2me mobile FPS game trilogy: Bunker3D, Laboratory3D and Castle3D by Netsoftware on [GZDoom](https://github.com/ZDoom/gzdoom) engine. The result is not planned to be a complete game, it's planned to be a base for a further enhanced port

What does this project do?
1. Run the java code extracted from the games, modified only to load and export data
1. Heuristic algorithm removes hidden linedefs and resolve overlapping ones, e.g. back side of a crate which fills only bottom half of the level height, overlaps a wall -> this algorithm cuts the wall in this place and leaves only the other top half of the wall
1. Work in progress...

Requires `python`, `java`, `javac` and python dependencies listed below. To run the program use extract the original games into `./jars/...` folders, and use `./convert.sh` to convert

```bash
python -m venv env
. env/bin/activate
pip install omgifol pillow svgwrite

```
