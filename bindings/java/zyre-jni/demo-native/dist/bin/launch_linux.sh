#!/bin/bash

# set directory where this script lives
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

# we use this var to set java.library.path in the gradle generated launcher script
export NATIVE_PATH="$DIR/../native/x64linux"

# Can someone explain why this is needed on Linux??
export LD_PRELOAD="$NATIVE_PATH/libzyre.so"

# execute the launcher script in this shell process
source "$DIR/demo-native"

