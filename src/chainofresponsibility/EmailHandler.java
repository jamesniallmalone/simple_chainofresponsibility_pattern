package chainofresponsibility;

public interface EmailHandler {
	public void setNextHandler(EmailHandler handler);
	public EmailHandler processHandler(String email);
	EmailHandler getNextHandler();
	public String getHandler();
}
