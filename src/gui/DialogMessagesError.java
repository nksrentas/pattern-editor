package gui;

import org.eclipse.jface.dialogs.MessageDialog;

public class DialogMessagesError implements DialogMessages{

	@Override
	public void displayDialog() {
		MessageDialog.openError(PatternMain.shlPatternsEditor, "Error", "Wrong pattern");
	}
}
