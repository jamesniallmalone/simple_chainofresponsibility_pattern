package chainofresponsibility;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestServiceEmailHandler {
	
	private ServiceEmailHandler meh;

	@Before
	public void intialise(){
		meh = new ServiceEmailHandler();
	}
	
	@Test
	public void testGeneralEnquiries() {
		assertNotNull("Should not be null", meh);
	}

	@Test
	public void testMatchingWords() {
		//Should match all.
		assertEquals("Should match empty array.", 2, meh.matchingWords().length);
	}

	@Test
	public void testGetHandler() {
		assertEquals("Expected name", "Service", meh.getHandler());
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
		
		assertEquals("Not yet implemented", "Service", meh.processHandler("repair stuff.").getHandler());
		
	}
}
