package chainofresponsibility;

public class SalesEmailHandler extends AbstractEmailHandler {

	@Override
	protected String[] matchingWords() {
		return new String[]{"buy", "purchase"};
	}

	@Override
	protected void handleHere(String email) {
		System.out.println("Email handled by sales department.");
	}

	@Override
	public String getHandler() {
		return "Sales";
	}

}
