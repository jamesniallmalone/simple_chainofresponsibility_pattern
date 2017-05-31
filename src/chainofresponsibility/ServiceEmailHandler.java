package chainofresponsibility;
public class ServiceEmailHandler extends AbstractEmailHandler {

	@Override
	protected String[] matchingWords() {
		return new String[]{"service", "repair"};
	}

	@Override
	protected void handleHere(String email) {
		System.out.println("Email handled by service department");
	}

	@Override
	public String getHandler() {
		return "Service";
	}

}
