package chainofresponsibility;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestManagerEmailHandler {
	
	private ManagerEmailHandler meh;

	@Before
	public void intialise(){
		meh = new ManagerEmailHandler();
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
		assertEquals("Expected name", "Manager", meh.getHandler());
	}

	@Test
	public void testSetNextHandler() {
		EmailHandler service = new ServiceEmailHandler();
		meh.setNextHandler(service );
		assertEquals("Not yet implemented", "Service", meh.getNextHandler().getHandler());
	}

	@Test
	public void testProcessHandler() {
		EmailHandler service = new ServiceEmailHandler();
		meh.setNextHandler(service );
		
		assertEquals("Not yet implemented", "Manager", meh.processHandler("bad job").getHandler());
		
	}
}
