# OSX notes

* update xcode command line tools to latest
* install glibtoolize, eg. via homebrew
* alias libtool and libtoolize to point to glibool and glibtoolize
* install pkg-config, eg. via homebrew

## Build each project individually

Build the projects in order

* libsodium
* libzmq
* czmq
* zyre

Using these commands:

    > ./autogen.sh
    > ./configure MY_CONF_FLAGS
    > make
    > make install
