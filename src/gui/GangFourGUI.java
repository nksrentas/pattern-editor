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

public class GangFourGUI extends Shell {
	private Monitor primary;
	private Display display;
	private String[] data = new String[15];
	private MessageFactory messageFactory;
	private boolean microPattern = false;
	private boolean inductivePattern = false;
	private boolean deductivePattern = false;
	private boolean gangPattern = false;
	private boolean systemPattern = false;

	public GangFourGUI(Display display, String patternLanguageName) {
		super(display, SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(GangFourGUI.class, "/gui/icons8-code-fork-50.png"));
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
		Button ConsequencesButton = new Button(this, SWT.NONE);
		ConsequencesButton.setSelection(true);
		Button classificationButton = new Button(this, SWT.NONE);
		classificationButton.setSelection(true);
		Button intentButton = new Button(this, SWT.NONE);
		intentButton.setSelection(true);
		Button alsoKnowsButton = new Button(this, SWT.NONE);
		alsoKnowsButton.setSelection(true);
		Button motivationButton = new Button(this, SWT.NONE);
		motivationButton.setSelection(true);
		Button applicabilityButton = new Button(this, SWT.NONE);
		applicabilityButton.setSelection(true);
		Button structureButton = new Button(this, SWT.NONE);
		structureButton.setSelection(true);
		Button participantsButton = new Button(this, SWT.NONE);
		participantsButton.setSelection(true);
		Button collaborationButton = new Button(this, SWT.NONE);
		collaborationButton.setSelection(true);
		Button implementationButton = new Button(this, SWT.NONE);
		implementationButton.setSelection(true);
		Button sampleCodeButton = new Button(this, SWT.NONE);
		Button knownUsesButton = new Button(this, SWT.NONE);
		Button relatedPatternButton = new Button(this, SWT.NONE);

		nameButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		nameButton.setBounds(10, 10, 154, 25);
		nameButton.setText("Name");
		listen(nameButton);

		templateButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		templateButton.setBounds(10, 41, 154, 25);
		templateButton.setText("Template");
		listen(templateButton);

		ConsequencesButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		ConsequencesButton.setText("Consequences");
		ConsequencesButton.setBounds(10, 320, 154, 25);
		listen(ConsequencesButton);

		classificationButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		classificationButton.setBounds(10, 72, 154, 25);
		classificationButton.setText("Classification");
		listen(classificationButton);

		intentButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		intentButton.setBounds(10, 103, 154, 25);
		intentButton.setText("Intent");
		listen(intentButton);

		alsoKnowsButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		alsoKnowsButton.setBounds(10, 134, 154, 25);
		alsoKnowsButton.setText("Also Known As");
		listen(alsoKnowsButton);

		motivationButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		motivationButton.setBounds(10, 165, 154, 25);
		motivationButton.setText("Motivation");
		listen(motivationButton);

		applicabilityButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		applicabilityButton.setBounds(10, 196, 154, 25);
		applicabilityButton.setText("Applicability");
		listen(applicabilityButton);

		structureButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		structureButton.setText("Structure");
		structureButton.setBounds(10, 227, 154, 25);
		listen(structureButton);

		participantsButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		participantsButton.setText("Participants");
		participantsButton.setBounds(10, 258, 154, 25);
		listen(participantsButton);

		collaborationButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		collaborationButton.setText("Collaborations");
		collaborationButton.setBounds(10, 289, 154, 25);
		listen(collaborationButton);

		implementationButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		implementationButton.setText("Implementation");
		implementationButton.setBounds(194, 10, 154, 25);
		listen(implementationButton);

		sampleCodeButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		sampleCodeButton.setText("Sample Code");
		sampleCodeButton.setBounds(194, 41, 154, 25);
		listen(sampleCodeButton);

		knownUsesButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		knownUsesButton.setText("Known Uses");
		knownUsesButton.setBounds(194, 72, 154, 25);
		listen(knownUsesButton);

		relatedPatternButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		relatedPatternButton.setText("Related Pattern");
		relatedPatternButton.setBounds(194, 103, 154, 25);
		listen(relatedPatternButton);
		
		Button btnSave = new Button(this, SWT.NONE);
		btnSave.setText("Save");
		btnSave.setSelection(true);
		btnSave.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		btnSave.setBounds(194, 301, 154, 25);
		btnSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Save to kathe leaf 
				PatternMain.getPattern().getGangOfFourPattern().getLeaf1().setContents(data[0]);
				PatternMain.getPattern().getGangOfFourPattern().getLeaf2().setContents(data[1]);
				PatternMain.getPattern().getGangOfFourPattern().getLeaf3().setContents(data[2]);
				PatternMain.getPattern().getGangOfFourPattern().getLeaf4().setContents(data[3]);
				PatternMain.getPattern().getGangOfFourPattern().getLeaf5().setContents(data[4]);
				PatternMain.getPattern().getGangOfFourPattern().getLeaf6().setContents(data[5]);
				PatternMain.getPattern().getGangOfFourPattern().getLeaf7().setContents(data[6]);
				PatternMain.getPattern().getGangOfFourPattern().getLeaf8().setContents(data[7]);
				PatternMain.getPattern().getGangOfFourPattern().getLeaf9().setContents(data[8]);
				PatternMain.getPattern().getGangOfFourPattern().getLeaf10().setContents(data[9]);
				PatternMain.getPattern().getGangOfFourPattern().getLeaf11().setContents(data[10]);
				PatternMain.getPattern().getGangOfFourPattern().getLeaf12().setContents(data[11]);
				PatternMain.getPattern().getGangOfFourPattern().getLeaf13().setContents(data[12]);
				PatternMain.getPattern().getGangOfFourPattern().getLeaf14().setContents(data[13]);
				PatternMain.getPattern().getGangOfFourPattern().getLeaf15().setContents(data[14]);
			}
		});

		Button button = new Button(this, SWT.NONE);
		button.setText("Save TXT");
		button.setSelection(true);
		button.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		button.setBounds(194, 332, 154, 25);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ArrayList<PatternComponent> kappa = ((PatternComposite) PatternMain.getPattern().getGangOfFourPattern().getContainer())
						.getComponents();

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
		button_1.setBounds(194, 363, 154, 25);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ArrayList<PatternComponent> kappa = ((PatternComposite) PatternMain.getPattern().getGangOfFourPattern().getContainer())
						.getComponents();
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
		case "Classification":
			data[2] = textWindowGUI.getTextInput();
			break;
		case "Intent":
			data[3] = textWindowGUI.getTextInput();
			break;
		case "Also Known As":
			data[4] = textWindowGUI.getTextInput();
			break;
		case "Motivation":
			data[5] = textWindowGUI.getTextInput();
			break;
		case "Applicability":
			data[6] = textWindowGUI.getTextInput();
			break;
		case "Structure":
			data[7] = textWindowGUI.getTextInput();
			break;
		case "Participants":
			data[8] = textWindowGUI.getTextInput();
			break;
		case "Collaborations":
			data[9] = textWindowGUI.getTextInput();
			break;
		case "Consequences":
			data[10] = textWindowGUI.getTextInput();
			break;
		case "Implementation":
			data[11] = textWindowGUI.getTextInput();
			break;
		case "Sample Code":
			data[12] = textWindowGUI.getTextInput();
			break;
		case "Known Uses":
			data[13] = textWindowGUI.getTextInput();
			break;
		case "Related Pattern":
			data[14] = textWindowGUI.getTextInput();
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
		case "Classification":
			return data[2];
		case "Intent":
			return data[3];
		case "Also Known As":
			return data[4];
		case "Motivation":
			return data[5];
		case "Applicability":
			return data[6];
		case "Structure":
			return data[7];
		case "Participants":
			return data[8];
		case "Collaborations":
			return data[9];
		case "Consequences":
			return data[10];
		case "Implementation":
			return data[11];
		case "Sample Code":
			return data[12];
		case "Known Uses":
			return data[13];
		case "Related Pattern":
			return data[14];
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