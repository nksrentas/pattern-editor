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

public class SystemOfPatternsGUI extends Shell {
	private Monitor primary;
	private Display display;
	private String[] data = new String[13];
	/**
	 * Create the shell.
	 * 
	 * @param display
	 * @param string 
	 */
	public SystemOfPatternsGUI(Display display, String patternLanguageName) {
		super(display, SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(SystemOfPatternsGUI.class, "/gui/icons8-code-fork-50.png"));
		createContents();
		setWindowPosition(display);
		setLayout(null);
		this.display = display;
		Menu menu = new Menu(this, SWT.BAR);
		setMenuBar(menu);
		
		Arrays.fill(data, "");
		
		MenuItem mntmFile = new MenuItem(menu, SWT.CASCADE);
		mntmFile.setText("File");
		
		Menu menu_1 = new Menu(mntmFile);
		mntmFile.setMenu(menu_1);
		
		MenuItem mntmAddPattern = new MenuItem(menu_1, SWT.NONE);
		mntmAddPattern.setText("Add pattern");
		
		Button nameButton = new Button(this, SWT.NONE);
		Button templateButton = new Button(this, SWT.NONE);
		Button problemButton = new Button(this, SWT.NONE);
		Button solutionButton = new Button(this, SWT.NONE);
		Button contextButton = new Button(this, SWT.NONE);
		Button alsoKnowsButton = new Button(this, SWT.NONE);
		alsoKnowsButton.setSelection(true);
		Button structureButton = new Button(this, SWT.NONE);
		structureButton.setSelection(true);
		Button implementationButton = new Button(this, SWT.NONE);
		implementationButton.setSelection(true);
		Button knownUsesButton = new Button(this, SWT.NONE);
		Button exampleButton = new Button(this, SWT.NONE);
		Button dynamicButton = new Button(this, SWT.NONE);
		Button exampleResolvedButton = new Button(this, SWT.NONE);
		Button variantsButton = new Button(this, SWT.NONE);
		
		nameButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		nameButton.setBounds(10, 10, 154, 25);
		nameButton.setText("Name");
		listen(nameButton);
	
		templateButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		templateButton.setBounds(10, 41, 154, 25);
		templateButton.setText("Template");
		listen(templateButton);
		
		problemButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		problemButton.setBounds(10, 165, 154, 25);
		problemButton.setText("Problem");
		listen(problemButton);
		
		solutionButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		solutionButton.setBounds(10, 196, 154, 25);
		solutionButton.setText("Solution");
		listen(solutionButton);
		
		contextButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		contextButton.setBounds(10, 134, 154, 25);
		contextButton.setText("Context");
		listen(contextButton);
		
		alsoKnowsButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		alsoKnowsButton.setBounds(10, 72, 154, 25);
		alsoKnowsButton.setText("Also Known As");
		listen(alsoKnowsButton);
		
		structureButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		structureButton.setText("Structure");
		structureButton.setBounds(10, 227, 154, 25);
		listen(structureButton);
		
		implementationButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		implementationButton.setText("Implementation");
		implementationButton.setBounds(10, 289, 154, 25);
		listen(implementationButton);
		
		knownUsesButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		knownUsesButton.setText("Known Uses");
		knownUsesButton.setBounds(194, 10, 154, 25);
		listen(knownUsesButton);
		
		exampleButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		exampleButton.setText("Example");
		exampleButton.setBounds(10, 103, 154, 25);
		listen(exampleButton);
		
		dynamicButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		dynamicButton.setText("Dynamic");
		dynamicButton.setBounds(10, 258, 154, 25);
		listen(dynamicButton);
		
		exampleResolvedButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		exampleResolvedButton.setText("Example Resolved");
		exampleResolvedButton.setBounds(10, 320, 154, 25);
		listen(exampleResolvedButton);
		
		variantsButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		variantsButton.setText("Variants");
		variantsButton.setBounds(10, 351, 154, 25);
		listen(variantsButton);
		
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
		setSize(377, 457);

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
		case "Also Known As":
			data[2] = textWindowGUI.getTextInput();
			break;
		case "Example":
			data[3] = textWindowGUI.getTextInput();
			break;
		case "Context":
			data[4] = textWindowGUI.getTextInput();
			break;
		case "Problem":
			data[5] = textWindowGUI.getTextInput();
			break;
		case "Solution":
			data[6] = textWindowGUI.getTextInput();
			break;
		case "Structure":
			data[7] = textWindowGUI.getTextInput();
			break;
		case "Dynamic":
			data[8] = textWindowGUI.getTextInput();
			break;
		case "Implementation":
			data[9] = textWindowGUI.getTextInput();
			break;
		case "Example Resolved":
			data[10] = textWindowGUI.getTextInput();
			break;
		case "Variants":
			data[11] = textWindowGUI.getTextInput();
			break;
		case "Known Uses":
			data[12] = textWindowGUI.getTextInput();
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
		case "Also Known As":
			return data[2];
		case "Example":
			return data[3];
		case "Context":
			return data[4];
		case "Problem":
			return data[5];
		case "Solution":
			return data[6];
		case "Structure":
			return data[7];
		case "Dynamic":
			return data[8];
		case "Implementation":
			return data[9];
		case "Example Resolved":
			return data[10];
		case "Variants":
			return data[11];
		case "Known Uses":
			return data[12];
		default:
			System.out.println("Input problem");
			break;
		}	
		return "Error";
	}
}