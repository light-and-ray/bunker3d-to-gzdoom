#!/bin/bash -ex
cd "$(dirname "$0")"
palettePath="../result.d/playpal.lmp"
colormapPath="../result.d/colormap.lmp"
find ../result.d/ -iname "*.png" | xargs python3 _generatePalette/optimal_palette.py "$palettePath"
python3 _generatePalette/colormap.py "$palettePath" > "$colormapPath"
