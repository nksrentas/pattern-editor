package gui;

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

public class InductiveMiniGUI extends Shell {
	private Monitor primary;
	private Display display;
	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public InductiveMiniGUI(Display display) {
		super(display, SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(InductiveMiniGUI.class, "/gui/icons8-code-fork-50.png"));
		createContents();
		setWindowPosition(display);
		setLayout(null);
		this.display = display;
		Menu menu = new Menu(this, SWT.BAR);
		setMenuBar(menu);
		
		MenuItem mntmFile = new MenuItem(menu, SWT.CASCADE);
		mntmFile.setText("File");
		
		Menu menu_1 = new Menu(mntmFile);
		mntmFile.setMenu(menu_1);
		
		MenuItem mntmAddPattern = new MenuItem(menu_1, SWT.NONE);
		mntmAddPattern.setText("Add pattern");
		
		Button nameButton = new Button(this, SWT.NONE);
		Button templateButton = new Button(this, SWT.NONE);
		Button solutionButton = new Button(this, SWT.NONE);
		Button contextButton = new Button(this, SWT.NONE);
		Button forcesButton = new Button(this, SWT.NONE);
		forcesButton.setSelection(true);
		
		nameButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		nameButton.setBounds(10, 10, 154, 25);
		nameButton.setText("Name");
		listen(nameButton);
	
		templateButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		templateButton.setBounds(10, 41, 154, 25);
		templateButton.setText("Template");
		listen(templateButton);
		
		solutionButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		solutionButton.setBounds(10, 134, 154, 25);
		solutionButton.setText("Solution");
		listen(solutionButton);
		
		contextButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		contextButton.setBounds(10, 72, 154, 25);
		contextButton.setText("Context");
		listen(contextButton);
		
		forcesButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		forcesButton.setBounds(10, 103, 154, 25);
		forcesButton.setText("Forces");
		listen(forcesButton);
		
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
		setSize(340, 374);

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
	
	private void listen(Button button) {
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(button.getText());
				new TextWindowGUI(display);
			}
		});
	}
}