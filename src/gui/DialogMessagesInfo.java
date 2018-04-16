package gui;

import org.eclipse.jface.dialogs.MessageDialog;

public class DialogMessagesInfo implements DialogMessages{

	@Override
	public void displayDialog() {
		MessageDialog.openInformation(PatternMain.shlPatternsEditor, "Informations", "Default settings loaded");
	}
}
