#!/bin/bash

################################################################
################################################################

if [ "$(whoami)" != "root" ]; then
    echo "ERROR: This script must be run with sudo"
    exit 1
fi

USER=`who | grep -v mbsetupuser | head -1 | awk '{print $1}'`

echo ">>> user $USER running with sudo..."
echo

# Git repo containing zeromq sources
ZMQ_URL="http://github.com/zeromq"
LS_URL="http://github.com/jedisct1"

# location of libsodium tarball
SODIUM_TARBALL="https://download.libsodium.org/libsodium/releases/libsodium-1.0.6.tar.gz"

# set directory where this script lives
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

# download and build zeromq sources here
ZMQ_PROJECT_SRC="$DIR/tmp"

# clones git projects
function clone {
    url=$1
    project=$2

    cmd="git clone $url/${project}.git $ZMQ_PROJECT_SRC/$project"
    echo ">>> running $cmd \n"
    sudo -u $USER $cmd
}

function build {
    dir=$1

    echo ">>> building $dir \n"

    cd $ZMQ_PROJECT_SRC/$dir
    sudo -u $USER ./autogen.sh
    sudo -u $USER ./configure $MY_CONF_FLAGS
    sudo -u $USER make
    make install
}

# remove existing zeromq source files
rm -rf $ZMQ_PROJECT_SRC

# create temporary src code dir
sudo -u $USER mkdir $ZMQ_PROJECT_SRC

# clone all zeromq projects
clone $LS_URL libsodium
clone $ZMQ_URL libzmq
clone $ZMQ_URL czmq
clone $ZMQ_URL zyre

#export CFLAGS="-I${ZMQ_PROJECT_SRC}/local/lib"
export MY_CONF_FLAGS="LDFLAGS=-L${ZMQ_PROJECT_SRC}/local/lib CPPFLAGS=-I${ZMQ_PROJECT_SRC}/local/include --prefix $ZMQ_PROJECT_SRC/local"
export PKG_CONFIG_PATH="${ZMQ_PROJECT_SRC}/local/lib/pkgconfig"

build libsodium
build libzmq
build czmq
build zyre

chown -R $USER $ZMQ_PROJECT_SRC/local

# checkout a specific commit because of a temporary build problem with zyre
#cd "$ZMQ_PROJECT_SRC/zyre" && git checkout b92cb1b && cd -


