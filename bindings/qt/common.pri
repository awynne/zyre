################################################################################
#  THIS FILE IS 100% GENERATED BY ZPROJECT; DO NOT EDIT EXCEPT EXPERIMENTALLY  #
#  Please refer to the README for information about making permanent changes.  #
################################################################################
exists(config.pri):infile(config.pri, QZYRE_LIBRARY, yes): CONFIG += qzyre-uselib
TEMPLATE += fakelib
QZYRE_LIBNAME = qzyre
CONFIG(debug, debug|release) {
    mac:QZYRE_LIBNAME = $$member(QZYRE_LIBNAME, 0)_debug
    else:win32:QZYRE_LIBNAME = $$member(QZYRE_LIBNAME, 0)d
}
TEMPLATE -= fakelib
QZYRE_LIBDIR = $$PWD/lib
unix:qzyre-uselib:!qzyre-buildlib:QMAKE_RPATHDIR += $$QZYRE_LIBDIR
################################################################################
#  THIS FILE IS 100% GENERATED BY ZPROJECT; DO NOT EDIT EXCEPT EXPERIMENTALLY  #
#  Please refer to the README for information about making permanent changes.  #
################################################################################
