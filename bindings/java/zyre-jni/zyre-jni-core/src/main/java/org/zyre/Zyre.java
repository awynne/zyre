package org.zyre;

/**
 * Demo class showing how zyre could be wrapped using JNI
 */
public class Zyre {
	
	public static final String ZYRE_SYSTEM_LIB = "zyre";
	public static final String ZYRE_JNI_SYSTEM_LIB = "zyre-jni";
	
	public Zyre() {
		//initialize JNI stuff 
		nativeInit(); 
	}
	
	public static void loadSystemLibrary() {
		// Load native libraries 
		System.loadLibrary(ZYRE_SYSTEM_LIB); 
		System.loadLibrary(ZYRE_JNI_SYSTEM_LIB); 
	}
	
	/*
	 * Native methods that comprise the Zyre API  
	 * (Native methods are converted to C by javah command)
	 */

	public native void create();
	public native void destroy();
	public native void join(String group);
	public native void shout(String group, String msg);
	public native void whisper(String nodeId, String msg);
	public native String recv();
	
	/*
	 * Used by JNI to store C pointers on heap
	 */
	
	// Initializes JNI objects so they can be used in C code
	private static native void nativeInit();
	
    private long nodeHandle;
	
    private long getNodeHandle() {
        return this.nodeHandle;
    }
}
