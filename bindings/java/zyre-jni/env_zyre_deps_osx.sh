#!/bin/bash

################################################################
################################################################

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
    $cmd
}

# remove existing zeromq source files
rm -rf $ZMQ_PROJECT_SRC

# create temporary src code dir
mkdir $ZMQ_PROJECT_SRC
mkdir -p $ZMQ_PROJECT_SRC/local/lib
mkdir -p $ZMQ_PROJECT_SRC/local/include
mkdir -p $ZMQ_PROJECT_SRC/local/bin
mkdir -p $ZMQ_PROJECT_SRC/local/share

# clone all zeromq projects
clone $LS_URL libsodium
clone $ZMQ_URL libzmq
clone $ZMQ_URL czmq
clone $ZMQ_URL zyre

# checkout a specific commit because of a temporary build problem with zyre
cd "$ZMQ_PROJECT_SRC/zyre" && git checkout b92cb1b && cd -

export MY_CONF_FLAGS="LDFLAGS=-L${ZMQ_PROJECT_SRC}/local/lib CPPFLAGS=-I${ZMQ_PROJECT_SRC}/local/include --prefix $ZMQ_PROJECT_SRC/local"
export PKG_CONFIG_PATH="${ZMQ_PROJECT_SRC}/local/lib/pkgconfig"

echo
echo "Please note the value of MY_CONF_FLAGS: $MY_CONF_FLAGS"
echo "Please note the value of PKG_CONFIG_PATH: $PKG_CONFIG_PATH"
echo
echo "Now you need to build each project separately in: $ZMQ_PROJECT_SRC"
echo
echo "Please run configure with MY_CONF_FLAGS: e.g.: "
echo "> ./autogen.sh"
echo "> ./configure MY_CONF_FLAGS"
echo "> make"
echo "> make install"
echo




