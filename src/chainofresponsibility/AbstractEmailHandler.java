package chainofresponsibility;

public abstract class AbstractEmailHandler implements EmailHandler {

	private EmailHandler nextHandler;

	@Override
	public void setNextHandler(EmailHandler handler) {
		nextHandler = handler;
	}
	
	@Override
	public EmailHandler getNextHandler() {
		return nextHandler;
	}

	@Override
	public EmailHandler processHandler(String email) {
		boolean wordfound = false;
		
		if(matchingWords().length == 0){
			wordfound = true;
		} else{
			for(String word : matchingWords()){
				if(email.indexOf(word) >= 0){
					wordfound = true;
					break;
				}
			}
		}
		
		if(wordfound){
			handleHere(email);
			return this;
		} else{
			return nextHandler.processHandler(email);
		}
		
	}
	
	protected abstract String[] matchingWords();
	protected abstract void handleHere(String email);
	
	public abstract String getHandler();
	
	public static void handle(String email){	
		EmailHandler spam = new SpamEmailHandler();
		EmailHandler sales = new SalesEmailHandler();
		EmailHandler service = new ServiceEmailHandler();
		EmailHandler manager = new ManagerEmailHandler();
		EmailHandler general = new GeneralEnquiriesEmailHandler();
		
		spam.setNextHandler(sales);
		sales.setNextHandler(service);
		service.setNextHandler(manager);
		manager.setNextHandler(general);
		
		spam.processHandler(email);
		
	}

}
