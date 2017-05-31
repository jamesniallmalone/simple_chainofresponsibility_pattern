package chainofresponsibility;

public class GeneralEnquiriesEmailHandler extends AbstractEmailHandler {

	@Override
	protected String[] matchingWords() {
		return new String[0];
	}

	@Override
	protected void handleHere(String email) {
		System.out.println("Email sent to general inbox.");
	}

	@Override
	public String getHandler() {
		return "GeneralEnquiries";
	}

}
