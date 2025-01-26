#!/bin/bash -ex
mkdir -p drawings
if [ -d "tmp" ]; then
    rm -r tmp
fi
mkdir tmp
mkdir -p result.d
env/bin/python src/convert.py
