package chainofresponsibility;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestGeneralEnquiriesEmailHandler {
	
	private GeneralEnquiriesEmailHandler ge;

	@Before
	public void intialise(){
		ge = new GeneralEnquiriesEmailHandler();
	}
	
	@Test
	public void testGeneralEnquiries() {
		assertNotNull("Should not be null", ge);
	}

	@Test
	public void testMatchingWords() {
		//Should match all.
		assertArrayEquals("Should match empty array.", new String[0] , ge.matchingWords());
	}

	@Test
	public void testGetHandler() {
		assertEquals("Expected name", "GeneralEnquiries", ge.getHandler());
	}

	@Test
	public void testSetNextHandler() {
		EmailHandler service = new ServiceEmailHandler();
		ge.setNextHandler(service );
		assertEquals("Not yet implemented", "Service", ge.getNextHandler().getHandler());
	}

	@Test
	public void testProcessHandler() {
		EmailHandler service = new ServiceEmailHandler();
		ge.setNextHandler(service );
		
		assertEquals("Not yet implemented", "GeneralEnquiries", ge.processHandler("IPSUM").getHandler());
		
	}
}
