#!/bin/bash -ex
./runJava.sh
env/bin/python convert.py
