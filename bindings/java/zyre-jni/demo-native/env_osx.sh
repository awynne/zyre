#!/bin/bash

# set directory where this script lives
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

#export DYLD_LIBRARY_PATH="$DIR/../native/osx:$DIR/../tmp/local/lib"
export JAVA_LIBRARY_PATH="$DIR/../native/osx:$DIR/../tmp/local/lib"

