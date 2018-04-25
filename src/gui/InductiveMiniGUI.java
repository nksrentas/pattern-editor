package gui;

import java.util.ArrayList;
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

import datamodel.Pattern;
import datamodel.PatternComponent;
import datamodel.PatternComposite;
import save.file.DataAddTabs;
import save.file.DataFile;
import save.file.DataLatextSyntax;
import save.file.DataTxt;

public class InductiveMiniGUI extends Shell {
	private Monitor primary;
	private Display display;
	private String test;
	private MessageFactory messageFactory;
	private String[] data = new String[5];
	
	public InductiveMiniGUI(Display display, String patternLanguageName) {
		super(display, SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(InductiveMiniGUI.class, "/gui/icons8-code-fork-50.png"));
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
		
		Button button = new Button(this, SWT.NONE);
		button.setText("Save TXT");
		button.setSelection(true);
		button.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		button.setBounds(10, 249, 154, 25);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Save to kathe leaf
				Pattern pattern = new Pattern();
				pattern.init();
				pattern.getInductiveMiniPattern().getLeaf1().setContents(data[0]);
				pattern.getInductiveMiniPattern().getLeaf2().setContents(data[1]);
				pattern.getInductiveMiniPattern().getLeaf3().setContents(data[2]);
				pattern.getInductiveMiniPattern().getLeaf4().setContents(data[3]);
				pattern.getInductiveMiniPattern().getLeaf5().setContents(data[4]);
				

				ArrayList<PatternComponent> kappa = ((PatternComposite) pattern.getInductiveMiniPattern().getContainer())
						.getComponents();

				if (hasAllEmptyContents(kappa)) {
					messageFactory = new MessageErrorDialog();
					messageFactory.renderDialogWindow();
				} else {
					// Print sto arxeio TXT
					DataFile dataFile = new DataTxt();
					dataFile.initStream(patternLanguageName, "txt");
					dataFile = new DataAddTabs(dataFile);

					for (int i = 0; i < kappa.size(); i++) {
						dataFile.writeFile(kappa.get(i).getTitle());
						dataFile.writeFile(kappa.get(i).getContents());
					}
					((DataAddTabs) dataFile).closeFile();
				}
			}
		});
		
		Button button_1 = new Button(this, SWT.NONE);
		button_1.setText("Save Latex");
		button_1.setSelection(true);
		button_1.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		button_1.setBounds(10, 280, 154, 25);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Save to kathe leaf
				Pattern pattern = new Pattern();
				pattern.init();
				pattern.getInductiveMiniPattern().getLeaf1().setContents(data[0]);
				pattern.getInductiveMiniPattern().getLeaf2().setContents(data[1]);
				pattern.getInductiveMiniPattern().getLeaf3().setContents(data[2]);
				pattern.getInductiveMiniPattern().getLeaf4().setContents(data[3]);
				pattern.getInductiveMiniPattern().getLeaf5().setContents(data[4]);

				ArrayList<PatternComponent> kappa = ((PatternComposite) pattern.getInductiveMiniPattern().getContainer())
						.getComponents();
				if (hasAllEmptyContents(kappa)) {
					messageFactory = new MessageErrorDialog();
					messageFactory.renderDialogWindow();
				} else {
					// Print sto arxeio LATEX
					DataFile dataFileLatex = new DataTxt();
					dataFileLatex.initStream(patternLanguageName, "tex");
					dataFileLatex = new DataLatextSyntax(dataFileLatex, patternLanguageName);

					for (int i = 1; i < kappa.size(); i++) {
						dataFileLatex.writeFile(kappa.get(i).getTitle());
						dataFileLatex.writeFile(kappa.get(i).getContents());
					}
					((DataLatextSyntax) dataFileLatex).closeFile();
				}
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
		case "Context":
			data[2] = textWindowGUI.getTextInput();
			break;
		case "Forces":
			data[3] = textWindowGUI.getTextInput();
			break;
		case "Solution":
			data[4] = textWindowGUI.getTextInput();
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
		case "Context":
			return data[2];
		case "Forces":
			return data[3];
		case "Solution":
			return data[4];
		default:
			System.out.println("Input problem");
			break;
		}	
		return "Error";
	}
	
	private boolean hasAllEmptyContents(ArrayList<PatternComponent> list) {
		int counter = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getContents().isEmpty()) {
				counter++;
			}
		}

		if (counter == list.size() - 1) {
			return true;
		}

		return false;
	}
}