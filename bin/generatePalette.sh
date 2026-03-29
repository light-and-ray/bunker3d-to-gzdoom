#!/bin/bash -ex
cd "$(dirname "$0")"
palettePath="../static/playpal.lmp"
colormapPath="../static/colormap.lmp"
find ../result.d/game -iname "*.png" | xargs python3 _generatePalette/optimal_palette.py "$palettePath"
python3 _generatePalette/colormap.py "$palettePath" > "$colormapPath"
cd ..
./updateStatic.sh
