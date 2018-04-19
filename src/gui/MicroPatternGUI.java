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

import datamodel.Pattern;
import datamodel.PatternComposite;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;

public class MicroPatternGUI extends Shell {
	private Monitor primary;
	private Text nameText;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Display display;
	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public MicroPatternGUI(Display display) {
		super(display, SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(MicroPatternGUI.class, "/gui/icons8-code-fork-50.png"));
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
		
		Label lblName = new Label(this, SWT.NONE);
		lblName.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		lblName.setBounds(10, 10, 55, 25);
		lblName.setText("Name");
		
		nameText = new Text(this, SWT.BORDER | SWT.MULTI);
		nameText.setBounds(10, 41, 376, 84);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		lblNewLabel.setBounds(10, 131, 98, 25);
		lblNewLabel.setText("Template");
		
		text = new Text(this, SWT.BORDER | SWT.MULTI);
		text.setBounds(10, 162, 376, 84);
		
		Label lblProblem = new Label(this, SWT.NONE);
		lblProblem.setText("Problem");
		lblProblem.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		lblProblem.setBounds(10, 252, 98, 25);
		
		text_1 = new Text(this, SWT.BORDER | SWT.MULTI);
		text_1.setBounds(10, 283, 376, 84);
		
		Label lblSolution = new Label(this, SWT.NONE);
		lblSolution.setText("Solution");
		lblSolution.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		lblSolution.setBounds(10, 373, 98, 25);
		
		text_2 = new Text(this, SWT.BORDER | SWT.MULTI);
		text_2.setBounds(10, 404, 376, 84);
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		btnNewButton.setBounds(311, 503, 75, 25);
		btnNewButton.setText("Save");
		listen(btnNewButton);
		
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
		setSize(412, 597);

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
				
			}
		});
	}
}