/*
################################################################################
#  THIS FILE IS 100% GENERATED BY ZPROJECT; DO NOT EDIT EXCEPT EXPERIMENTALLY  #
#  Please refer to the README for information about making permanent changes.  #
################################################################################
*/
package org.zeromq.zyre;

import org.junit.Assert;
import org.junit.Test;

public class ZyreEventTest {
    static {
        try {
            System.loadLibrary ("zyrejni");
        }
        catch (Exception e) {
            System.exit (-1);
        }
    }
    @Test
    public void test () {
        ZyreEvent zyre_event = new ZyreEvent ();
        zyre_event.test (false);
    }
}
