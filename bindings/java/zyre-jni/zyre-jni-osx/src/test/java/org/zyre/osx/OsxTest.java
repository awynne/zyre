package org.zyre.osx;

import org.junit.Test;
import org.zyre.PingPongTest;
import org.zyre.ShoutWhisperTest;

public class OsxTest {
	
	@Test
	public void pingPong() throws Exception {
		PingPongTest pp = new PingPongTest();
		pp.test();
	}
	
	@Test
	public void shoutWhisper() throws Exception {
		ShoutWhisperTest sw = new ShoutWhisperTest();
		sw.test();
	}
}