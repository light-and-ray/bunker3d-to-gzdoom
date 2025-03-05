#!/bin/bash -ex
export __NV_PRIME_RENDER_OFFLOAD=1
export __GLX_VENDOR_LIBRARY_NAME=nvidia
gzdoom -iwad DOOM.WAD -file result.d "$@"
