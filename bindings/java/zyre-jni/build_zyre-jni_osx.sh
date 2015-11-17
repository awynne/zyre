#!/bin/bash

set -e

# set directory where this script lives
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

# zeromq sources were downloaded here
ZMQ_PROJECT_SRC="$DIR/tmp"

PLATFORM="darwin" 

if [ ! -d "$ZMQ_PROJECT_SRC" ]; then
    echo "ERROR: Bulid Zyre and dependent libraries before running this script"
    exit 1
fi

export C_INCLUDE_PATH="$ZMQ_PROJECT_SRC/local/include:$JAVA_HOME/include:$JAVA_HOME/include/$PLATFORM"

CMD="gcc -fPIC -shared -L${ZMQ_PROJECT_SRC}/local/lib -o native/osx/libzyre-jni.dylib src/main/c/org_zyre_Zyre.c -lzyre -lczmq"

echo
echo "Running: $CMD ..."
$CMD
echo
echo "success!"
