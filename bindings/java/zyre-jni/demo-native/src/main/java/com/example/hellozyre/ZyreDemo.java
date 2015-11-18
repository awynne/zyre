package com.example.hellozyre;

import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zyre.Zyre;

import cz.adamh.utils.NativeUtils;

public class ZyreDemo {

    public static final String GROUP = "HelloZyreGroup";
    private Zyre zyre;
    static private RecvThread receiver;
    private final static Logger log = LoggerFactory.getLogger(ZyreDemo.class);

    public static void main(String[] args) {
    	log.info("LD_LIBRARY_PATH: " + System.getenv("LD_LIBRARY_PATH"));
    	log.info("LD_PRELOAD: " + System.getenv("LD_PRELOAD"));
    	log.info("java.library.path = " + System.getProperty("java.library.path"));

    	ZyreDemo demo = new ZyreDemo();
    	
    	demo.init();
    	demo.sendLoop();
    	demo.destroy();
    }
    
    public void sendLoop() {
    	Scanner sc = new Scanner(System.in);
    	while (true) {
    		System.out.print("message to shout: ");
    		String msg = sc.nextLine();
    		msg = msg.trim().toLowerCase();

    		if (msg.equals("exit")) {
    			break;
    		}
    		if (msg.equals(""))  {
    			continue;
    		}
    		zyre.shout(GROUP, msg);
    	}
    	log.info("exiting ...");
    	sc.close();
    }
    
    public void init() {

    	zyre = newZyre();
        zyre.create();
        zyre.join(GROUP);

        receiver = new RecvThread();
        receiver.setZyre(zyre);
        receiver.setGroup(GROUP);
        receiver.start();
    }
    
    public void destroy() {
        receiver.interrupt();
        try { Thread.sleep(100); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        zyre.destroy();
    }
    
    private Zyre newZyre() {
    	log.info("Loading zyre-jni as system library...");
    	Zyre.loadSystemLibrary();
		log.info("... success");
    	return new Zyre();
    }
}
