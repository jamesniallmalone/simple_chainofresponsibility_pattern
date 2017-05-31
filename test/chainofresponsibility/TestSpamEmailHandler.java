package chainofresponsibility;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSpamEmailHandler {
	
	private SpamEmailHandler meh;

	@Before
	public void intialise(){
		meh = new SpamEmailHandler();
	}
	
	@Test
	public void testGeneralEnquiries() {
		assertNotNull("Should not be null", meh);
	}

	@Test
	public void testMatchingWords() {
		//Should match all.
		assertEquals("Should match empty array.", 3, meh.matchingWords().length);
	}

	@Test
	public void testGetHandler() {
		assertEquals("Expected name", "Spam", meh.getHandler());
	}

	@Test
	public void testSetNextHandler() {
		EmailHandler manager = new ManagerEmailHandler();
		meh.setNextHandler(manager);
		assertEquals("Not yet implemented", manager.getHandler(), meh.getNextHandler().getHandler());
	}

	@Test
	public void testProcessHandler() {
		EmailHandler service = new ServiceEmailHandler();
		meh.setNextHandler(service );
		
		assertEquals("Not yet implemented", "Spam", meh.processHandler("lots of pills.").getHandler());
		
	}
}
