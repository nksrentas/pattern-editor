package gui;

public abstract class MessageFactory {
	public abstract DialogMessages displayDialog();
	
	public void renderDialogWindow() {
		DialogMessages dialogMessages = displayDialog();
		dialogMessages.displayDialog();
	}
}
