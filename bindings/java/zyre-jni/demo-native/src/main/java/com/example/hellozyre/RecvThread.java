package com.example.hellozyre;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zyre.Utils;
import org.zyre.Zyre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecvThread extends Thread {

	public static Logger log = LoggerFactory.getLogger(RecvThread.class);

	private String group = null;
	
	private Zyre zyre; 
	
	private Map<String, List<String>> peers = new HashMap<String, List<String>>();

	public RecvThread() {
	}

	@Override
	public void run() {
		if (group == null) {
			log.error("group not set");
			return;
		}
		if (zyre == null) {
			log.error("Zyre not set");
			return;
		}
		//zyre.join(group);

		while (true) {

            HashMap<String,String> eventMap = receive();
            
            if (eventMap.isEmpty()) {
            	log.info("done");
            	break;
            }

            String eventType = eventMap.get("event");
            String peer = eventMap.get("peer");
            String group = eventMap.get("group");
            String payload = eventMap.get("message");

			// A Zyre-enabled device enters the network
			if (eventType.equals("ENTER")) {
				handleEnter(peer);
			} 
			// Message sent to a particular device
			else if (eventType.equals("WHISPER")) {
				handleWhisper(peer, payload);
			} 
			// Message sent to all members of a group
			else if (eventType.equals("SHOUT")) {
				handleShout(peer, group, payload);
			} 
			// A device joins a group
			else if (eventType.equals("JOIN")) {
				handleJoin(peer, group);
				logKnownDevices();
			} 
			// A device explicitly leaves a group
			else if (eventType.equals("LEAVE")) {
				handleLeave(peer, group);
				logKnownDevices();
			}
			// A device exits the network
			else if (eventType.equals("EXIT")) {
				handleExit(peer);
				logKnownDevices();
			}
			else if (eventType.equals("EVASIVE")) {
				// intentionally empty; node is not responding to beacons
			}
			else {
				System.out.println("unkown event: " + eventType);
			}
		}
	}

    private HashMap<String,String> receive() {
        String incoming = zyre.recv();
        HashMap<String,String> eventMap = new HashMap<>();

        if (incoming == null) {// Interrupted
            log.warn("Interrupted during recv()");
            return eventMap;
        }

        if (Thread.interrupted()) {
            log.info("RecvThread exiting");
            return eventMap;
        }

        // Convert the incoming string into a Map
        eventMap = Utils.parseMsg(incoming);

        if (eventMap.isEmpty() || eventMap.get("event") == null) {
            log.error("event map invalid, received: " + incoming);
            return new HashMap<>();
        }

        return eventMap;
    }

	private void logKnownDevices() {
		for(String group : peers.keySet()) {
			log.debug("devices in " + group + " : " + peers.get(group));
		}
	}
	
	private void handleEnter(String zyreDeviceId) {
		log.info("peer (" + zyreDeviceId + ") entered network");
	}
	
	private void handleWhisper(String zyreDeviceId, String payload) {
		log.info("peer (" + zyreDeviceId + ") whispered: " + payload);
	}
	
	private void handleShout(String zyreDeviceId, String group, String serializedMsg) {
		log.info("peer (" + zyreDeviceId + ") shouted to group " + group + ": " + serializedMsg);
        zyre.whisper(zyreDeviceId, "replyTo:"+ serializedMsg);
	}
		
	private void handleJoin(String zyreDeviceId, String group) {
		addPeer(group, zyreDeviceId);
		log.info("peer (" + zyreDeviceId + ") joined: " + group);
	}
	
	private void handleLeave(String zyreDeviceId, String group) {
		boolean success = removePeer(group, zyreDeviceId);
		log.info("peer (" + zyreDeviceId + ") left " + group + ":" + success);
	}
	
	private void handleExit(String zyreDeviceId) {
		boolean success = removePeer(zyreDeviceId);
		log.debug("peer (" + zyreDeviceId + ") exited: " + success);
	}
	
	private boolean addPeer(String group, String zyreDeviceId) {
		List<String> deviceList = peers.get(group);
		if (deviceList == null) {
			deviceList = new ArrayList<String>();
			peers.put(group, deviceList);
		}

		return deviceList.add(zyreDeviceId);
	}
	
	private boolean removePeer(String zyreDeviceId) {
		if (peers == null || peers.isEmpty()) {
			return false;
		}

		boolean allRemovesSucceeded = true;

		for (String group: peers.keySet()) {
			if ( !removePeer(group, zyreDeviceId) ) {
				log.debug("remove failed: " + zyreDeviceId);
				allRemovesSucceeded = false;
			}
		}
		
		return allRemovesSucceeded;
	}
	
	private boolean removePeer(String group, String zyreDeviceId) {
		peers.get(group);
		List<String> deviceList = peers.get(group);

		if (deviceList == null) {
			return false;
		}

		return deviceList.remove(zyreDeviceId);
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	
	public void setZyre(Zyre zyre) {
		this.zyre = zyre;
	}
}
