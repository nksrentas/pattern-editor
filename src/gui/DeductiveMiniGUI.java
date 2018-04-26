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

import data.source.DataAddTabs;
import data.source.DataFile;
import data.source.DataLatextSyntax;
import data.source.DataTxt;
import datamodel.Pattern;
import datamodel.PatternComponent;
import datamodel.PatternComposite;

public class DeductiveMiniGUI extends Shell {
	private Monitor primary;
	private Display display;
	private String[] data = new String[6];
	private MessageFactory messageFactory;
	private boolean microPattern = false;
	private boolean inductivePattern = false;
	private boolean deductivePattern = false;
	private boolean gangPattern = false;
	private boolean systemPattern = false;

	public DeductiveMiniGUI(Display display, String patternLanguageName) {
		super(display, SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(DeductiveMiniGUI.class, "/gui/icons8-code-fork-50.png"));
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

		MenuItem microPatternMenu = new MenuItem(menu_1, SWT.NONE);
		microPatternMenu.setText("Micro-Pattern");
		microPatternMenu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				microPattern = true;
				new MicroPatternGUI(display, patternLanguageName);
			}

		});

		MenuItem inductiveMiniPatternMenu = new MenuItem(menu_1, SWT.NONE);
		inductiveMiniPatternMenu.setText("Inductive mini pattern");
		inductiveMiniPatternMenu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				inductivePattern = true;
				new InductiveMiniGUI(display, patternLanguageName);
			}

		});

		MenuItem deductiveMenu = new MenuItem(menu_1, SWT.NONE);
		deductiveMenu.setText("Deductive mini pattern");
		deductiveMenu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				deductivePattern = true;
				new DeductiveMiniGUI(display, patternLanguageName);
			}

		});

		MenuItem gangOfFourMenu = new MenuItem(menu_1, SWT.NONE);
		gangOfFourMenu.setText("Gang of four");
		gangOfFourMenu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				gangPattern = true;
				new GangFourGUI(display, patternLanguageName);
			}

		});

		MenuItem systemofPatternsMenu = new MenuItem(menu_1, SWT.NONE);
		systemofPatternsMenu.setText("Systemof patterns");
		systemofPatternsMenu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				systemPattern = true;
				new SystemOfPatternsGUI(display, patternLanguageName);
			}

		});

		Button nameButton = new Button(this, SWT.NONE);
		Button templateButton = new Button(this, SWT.NONE);
		Button problemButton = new Button(this, SWT.NONE);
		Button solutionButton = new Button(this, SWT.NONE);
		Button benefitButton = new Button(this, SWT.NONE);
		benefitButton.setSelection(true);
		Button ConsequencesButton = new Button(this, SWT.NONE);
		ConsequencesButton.setSelection(true);

		nameButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		nameButton.setBounds(10, 10, 154, 25);
		nameButton.setText("Name");
		listen(nameButton);

		templateButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		templateButton.setBounds(10, 41, 154, 25);
		templateButton.setText("Template");
		listen(templateButton);

		problemButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		problemButton.setBounds(10, 72, 154, 25);
		problemButton.setText("Problem");
		listen(problemButton);

		solutionButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		solutionButton.setBounds(10, 103, 154, 25);
		solutionButton.setText("Solution");
		listen(solutionButton);

		benefitButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		benefitButton.setBounds(10, 134, 154, 25);
		benefitButton.setText("Benefit");
		listen(benefitButton);

		ConsequencesButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		ConsequencesButton.setText("Consequences");
		ConsequencesButton.setBounds(10, 165, 154, 25);
		listen(ConsequencesButton);
		
		Button btnSave = new Button(this, SWT.NONE);
		btnSave.setText("Save");
		btnSave.setSelection(true);
		btnSave.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		btnSave.setBounds(10, 236, 154, 25);
		btnSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Save to kathe leaf 
				/*PatternMain.getPattern().getDeductiveMiniPattern().getLeaf1().setContents(data[0]);
				PatternMain.getPattern().getDeductiveMiniPattern().getLeaf2().setContents(data[1]);
				PatternMain.getPattern().getDeductiveMiniPattern().getLeaf3().setContents(data[2]);
				PatternMain.getPattern().getDeductiveMiniPattern().getLeaf4().setContents(data[3]);
				PatternMain.getPattern().getDeductiveMiniPattern().getLeaf5().setContents(data[4]);
				PatternMain.getPattern().getDeductiveMiniPattern().getLeaf6().setContents(data[5]);*/
			}
		});

		Button button = new Button(this, SWT.NONE);
		button.setText("Save TXT");
		button.setSelection(true);
		button.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		button.setBounds(10, 267, 154, 25);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ArrayList<PatternComponent> kappa = ((PatternComposite) PatternMain.getPattern().getDeductiveMiniPattern()
						.getContainer()).getComponents();

				if (hasAllEmptyContents(kappa)) {
					messageFactory = new MessageErrorDialog();
					messageFactory.renderDialogWindow();
				} else {
					// Print sto arxeio TXT
					DataFile dataFile = new DataTxt();
					dataFile.initStream(patternLanguageName, "txt");
					dataFile = new DataAddTabs(dataFile);

					printToFile(dataFile, kappa);

					if (microPattern) {
						ArrayList<PatternComponent> kappa2 = ((PatternComposite) PatternMain.getPattern().getMicroPattern().getContainer())
								.getComponents();
						printToFile(dataFile, kappa2);
					} 
					
					if (inductivePattern) {
						ArrayList<PatternComponent> kappa2 = ((PatternComposite) PatternMain.getPattern().getInductiveMiniPattern().getContainer())
								.getComponents();
						printToFile(dataFile, kappa2);
					} 
					
					if (deductivePattern) {
						ArrayList<PatternComponent> kappa2 = ((PatternComposite) PatternMain.getPattern().getDeductiveMiniPattern().getContainer())
								.getComponents();
						printToFile(dataFile, kappa2);
					} 
					
					if (gangPattern) {
						ArrayList<PatternComponent> kappa2 = ((PatternComposite) PatternMain.getPattern().getGangOfFourPattern().getContainer())
								.getComponents();
						printToFile(dataFile, kappa2);
					} 
					
					if (systemPattern) {
						ArrayList<PatternComponent> kappa2 = ((PatternComposite) PatternMain.getPattern().getSystemOfPattern().getContainer())
								.getComponents();
						printToFile(dataFile, kappa2);
					}
					((DataAddTabs) dataFile).closeFile();
				}
			}
		});

		Button button_1 = new Button(this, SWT.NONE);
		button_1.setText("Save Latex");
		button_1.setSelection(true);
		button_1.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		button_1.setBounds(10, 298, 154, 25);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ArrayList<PatternComponent> kappa = ((PatternComposite) PatternMain.getPattern().getDeductiveMiniPattern()
						.getContainer()).getComponents();
				if (hasAllEmptyContents(kappa)) {
					messageFactory = new MessageErrorDialog();
					messageFactory.renderDialogWindow();
				} else {
					// Print sto arxeio LATEX
					DataFile dataFileLatex = new DataTxt();
					dataFileLatex.initStream(patternLanguageName, "tex");
					dataFileLatex = new DataLatextSyntax(dataFileLatex, patternLanguageName);

					printToFile(dataFileLatex, kappa);

					if (microPattern) {
						ArrayList<PatternComponent> kappa2 = ((PatternComposite) PatternMain.getPattern()
								.getMicroPattern().getContainer()).getComponents();
						printToFile(dataFileLatex, kappa2);
					}
					
					if (inductivePattern) {
						ArrayList<PatternComponent> kappa2 = ((PatternComposite) PatternMain.getPattern()
								.getInductiveMiniPattern().getContainer()).getComponents();
						printToFile(dataFileLatex, kappa2);
					}
					
					if (deductivePattern) {
						ArrayList<PatternComponent> kappa2 = ((PatternComposite) PatternMain.getPattern()
								.getDeductiveMiniPattern().getContainer()).getComponents();
						printToFile(dataFileLatex, kappa2);
					}
					
					if (gangPattern) {
						ArrayList<PatternComponent> kappa2 = ((PatternComposite) PatternMain.getPattern()
								.getGangOfFourPattern().getContainer()).getComponents();
						printToFile(dataFileLatex, kappa2);
					}
					
					if (systemPattern) {
						ArrayList<PatternComponent> kappa2 = ((PatternComposite) PatternMain.getPattern()
								.getSystemOfPattern().getContainer()).getComponents();
						printToFile(dataFileLatex, kappa2);
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
		setSize(340, 392);

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
			PatternMain.getPattern().getDeductiveMiniPattern().getLeaf1().setContents(textWindowGUI.getTextInput());
			break;
		case "Template":
			PatternMain.getPattern().getDeductiveMiniPattern().getLeaf2().setContents(textWindowGUI.getTextInput());
			break;
		case "Problem":
			PatternMain.getPattern().getDeductiveMiniPattern().getLeaf3().setContents(textWindowGUI.getTextInput());
			break;
		case "Solution":
			PatternMain.getPattern().getDeductiveMiniPattern().getLeaf4().setContents(textWindowGUI.getTextInput());
			break;
		case "Benefit":
			PatternMain.getPattern().getDeductiveMiniPattern().getLeaf5().setContents(textWindowGUI.getTextInput());
			break;
		case "Consequences":
			PatternMain.getPattern().getDeductiveMiniPattern().getLeaf6().setContents(textWindowGUI.getTextInput());
			break;
		default:
			System.out.println("Input problem");
			break;
		}
	}

	private String parseData(String buttonText) {
		switch (buttonText) {
		case "Name":
			return PatternMain.getPattern().getDeductiveMiniPattern().getLeaf1().getContents();
		case "Template":
			return PatternMain.getPattern().getDeductiveMiniPattern().getLeaf2().getContents();
		case "Problem":
			return PatternMain.getPattern().getDeductiveMiniPattern().getLeaf3().getContents();
		case "Solution":
			return PatternMain.getPattern().getDeductiveMiniPattern().getLeaf4().getContents();
		case "Benefit":
			return PatternMain.getPattern().getDeductiveMiniPattern().getLeaf5().getContents();
		case "Consequences":
			return PatternMain.getPattern().getDeductiveMiniPattern().getLeaf6().getContents();
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

	private void printToFile(DataFile dataFile, ArrayList<PatternComponent> list) {
		for (int i = 0; i < list.size(); i++) {
			dataFile.writeFile(list.get(i).getTitle());
			dataFile.writeFile(list.get(i).getContents());
		}
	}
}