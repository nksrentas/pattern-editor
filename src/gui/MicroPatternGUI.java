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

import datamodel.MicroPattern;
import datamodel.Pattern;
import datamodel.PatternComposite;
import datamodel.PatternTestCache;
import datamodel.PatternComponent;
import datamodel.*;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;

public class MicroPatternGUI extends Shell {
	private Monitor primary;
	private Display display;
	private String[] data = new String[4];
	
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
		
		Arrays.fill(data, "");
		
		MenuItem mntmFile = new MenuItem(menu, SWT.CASCADE);
		mntmFile.setText("Add pattern");
		
		Menu menu_1 = new Menu(mntmFile);
		mntmFile.setMenu(menu_1);
		
		MenuItem mntmAddPattern = new MenuItem(menu_1, SWT.NONE);
		mntmAddPattern.setText("Add pattern");
		
		Button nameButton = new Button(this, SWT.NONE);
		nameButton.setText("Name");
		nameButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		nameButton.setBounds(10, 10, 154, 25);
		listen(nameButton);
		
		Button templateButton = new Button(this, SWT.NONE);
		templateButton.setText("Template");
		templateButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		templateButton.setBounds(10, 41, 154, 25);
		listen(templateButton);
		
		Button problemButton = new Button(this, SWT.NONE);
		problemButton.setText("Problem");
		problemButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		problemButton.setBounds(10, 72, 154, 25);
		listen(problemButton);
		
		Button solutionButton = new Button(this, SWT.NONE);
		solutionButton.setText("Solution");
		solutionButton.setSelection(true);
		solutionButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		solutionButton.setBounds(10, 103, 154, 25);
		listen(solutionButton);
		
		Button saveButton = new Button(this, SWT.NONE);
		saveButton.setText("Save");
		saveButton.setSelection(true);
		saveButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		saveButton.setBounds(10, 241, 154, 25);
		saveButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				for(int i =0 ; i < data.length; i++) {
					System.out.println(data[i]);
				}
			
				// me init
				Pattern pattern = new Pattern();
				pattern.init();
				pattern.getMicroPattern().getLeaf1().setContents(data[0]);
				pattern.getMicroPattern().getLeaf2().setContents(data[1]);
				pattern.getMicroPattern().getLeaf3().setContents(data[2]);
				pattern.getMicroPattern().getLeaf4().setContents(data[3]);
				
				((PatternComposite) pattern.getMicroPattern().getContainer()).print();
				
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
		setSize(249, 335);

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
				TextWindowGUI textWindowGUI = new TextWindowGUI(display, parseData(button.getText()));
				saveData(button.getText(), textWindowGUI);
			}
		});
	}
	
	private void saveData(String buttonText, TextWindowGUI textWindowGUI) {
		switch (buttonText) {
		case "Name":
			data[0] = textWindowGUI.getTextInput();
			break;
		case "Template":
			data[1] = textWindowGUI.getTextInput();
			break;
		case "Problem":
			data[2] = textWindowGUI.getTextInput();
			break;
		case "Solution":
			data[3] = textWindowGUI.getTextInput();
			break;
		default:
			System.out.println("Input problem");
			break;
		}
	}
	
	private String parseData(String buttonText) {
		switch (buttonText) {
		case "Name":
			return data[0];
		case "Template":
			return data[1];
		case "Problem":
			return data[2];
		case "Solution":
			return data[3];
		default:
			System.out.println("Input problem");
			break;
		}
		return "Error";
	}
}