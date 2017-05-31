package chainofresponsibility;

public class SpamEmailHandler extends AbstractEmailHandler {

	@Override
	protected String[] matchingWords() {
		// TODO Auto-generated method stub
		return new String[]{"viagra", "pills", "medicines"};
	}

	@Override
	protected void handleHere(String email) {
		System.out.println("This is a spam email.");
	}

	@Override
	public String getHandler() {
		return "Spam";
	}

}
