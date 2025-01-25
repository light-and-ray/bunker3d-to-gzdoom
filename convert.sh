#!/bin/bash -ex
mkdir -p drawings
if [ -d "tmp" ]; then
    rm -r tmp
fi
mkdir tmp
if [ -d "result.d" ]; then
    rm -r result.d
fi
mkdir result.d
env/bin/python src/convert.py
