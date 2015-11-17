#!/bin/bash

# set directory where this script lives
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

export LD_LIBRARY_PATH="$DIR/../native/x64linux:$DIR/../tmp/local/lib"
export LD_PRELOAD="$DIR/../tmp/local/lib/libzyre.so"

