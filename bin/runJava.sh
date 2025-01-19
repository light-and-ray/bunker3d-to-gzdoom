#!/bin/bash -ex
cd java
javac *.java
exec java -cp . Main "$@"
