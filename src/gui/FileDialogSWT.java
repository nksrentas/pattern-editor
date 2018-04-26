package gui;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class FileDialogSWT {
	private String fileName;

	public FileDialogSWT(Display display) {
		final Shell shell = new Shell(display);

		FileDialog dlg = new FileDialog(shell, SWT.MULTI);
		Collection files = new ArrayList();
		if (dlg.open() != null) {
			String[] names = dlg.getFileNames();
			for (int i = 0, n = names.length; i < n; i++) {
				StringBuffer buf = new StringBuffer(dlg.getFilterPath());
				if (buf.charAt(buf.length() - 1) != File.separatorChar)
					buf.append(File.separatorChar);
				buf.append(names[i]);
				files.add(buf.toString());
			}
		}
		fileName = (String) ((ArrayList) files).get(0);
		//display.dispose();

	}

	public String getFileName() {
		return fileName;
	}
}