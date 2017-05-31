package chainofresponsibility;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSalesEmailHandler {
	
	private SalesEmailHandler meh;

	@Before
	public void intialise(){
		meh = new SalesEmailHandler();
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
		assertEquals("Expected name", "Sales", meh.getHandler());
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
		
		assertEquals("Not yet implemented", "Sales", meh.processHandler("buy lots.").getHandler());
		
	}
}
