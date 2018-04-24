package gui;

import java.util.Arrays;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.ScrolledComposite;

public class TextWindowGUI extends Shell {
	private Monitor primary;
	private Text text;
	private String textInput;
	
	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public TextWindowGUI(Display display, String message) {
		super(display, SWT.SHELL_TRIM);
		this.textInput = message;
		setImage(SWTResourceManager.getImage(TextWindowGUI.class, "/gui/icons8-code-fork-50.png"));
		createContents();
		setWindowPosition(display);
		setLayout(null);
		
		text = new Text(this, SWT.BORDER | SWT.MULTI);
		text.setLocation(10, 10);
		text.setSize(437, 232);
		text.setText(textInput);
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.setBounds(10, 253, 126, 45);
		btnNewButton.setText("Save");
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				textInput = text.getText();
				close();
			}
		});
		
		try {
			open();
			layout();
			while (!isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Create your pattern language");
		setSize(469, 367);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	private void setWindowPosition(Display display) {
		primary = display.getPrimaryMonitor();
		Rectangle bounds = primary.getBounds();
		Rectangle rect = this.getBounds();
		int x = bounds.x + (bounds.width - rect.width) / 2;
		int y = bounds.y + (bounds.height - rect.height) / 2;
		this.setLocation(x, y);
	}
	
	public String getTextInput() {
		return textInput;
	}
	
	public void setTextInput(String textInput) {
		this.textInput = textInput;
	}
}