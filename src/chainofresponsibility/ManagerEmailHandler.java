package chainofresponsibility;
public class ManagerEmailHandler extends AbstractEmailHandler {

	@Override
	protected String[] matchingWords() {
		// TODO Auto-generated method stub
		return new String[]{"complain","bad"};
	}

	@Override
	protected void handleHere(String email) {
		System.out.println("Email handled by manager");
	}

	@Override
	public String getHandler() {
		return "Manager";
	}

}
