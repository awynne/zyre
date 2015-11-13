#!/bin/bash

# set directory where this script lives
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

# zeromq sources were downloaded here
ZMQ_PROJECT_SRC="$DIR/tmp"

if [ ! -d "$ZMQ_PROJECT_SRC" ]; then
    echo "ERROR: Bulid Zyre and dependent libraries before running this script"
    exit 1
fi

export LD_LIBRARY_PATH="$ZMQ_PROJECT_SRC/local/lib"
export C_INCLUDE_PATH="$ZMQ_PROJECT_SRC/local/include:$JAVA_HOME/include:$JAVA_HOME/include/linux"

CMD="gcc -fPIC -shared -o native/x64linux/libzyre-jni.so src/main/c/org_zyre_Zyre.c"

echo "Running: $CMD"
$CMD

