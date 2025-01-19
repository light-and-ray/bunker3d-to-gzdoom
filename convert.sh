#!/bin/bash -ex
mkdir -p drawings
if [ -d "tmp" ]; then
    rm -r tmp
fi
mkdir tmp
env/bin/python convert.py
