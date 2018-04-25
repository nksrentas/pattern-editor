package gui;

public class MessageErrorDialog extends MessageFactory{

	@Override
	public DialogMessages displayDialog() {
		return new DialogMessagesError();
	}
}
