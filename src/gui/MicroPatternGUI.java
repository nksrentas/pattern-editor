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

public class MicroPatternGUI extends Shell {
	private Monitor primary;
	private Display display;
	private String[] data = new String[4];
	private MessageFactory messageFactory;
	private boolean microPattern = false;
	private boolean inductivePattern = false;
	private boolean deductivePattern = false;
	private boolean gangPattern = false;
	private boolean systemPattern = false;

	public MicroPatternGUI(Display display, String patternLanguageName) {
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

		Button btnSave = new Button(this, SWT.NONE);
		btnSave.setText("Save");
		btnSave.setSelection(true);
		btnSave.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		btnSave.setBounds(10, 164, 154, 25);
		btnSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Save to kathe leaf
				PatternMain.getPattern().getMicroPattern().getLeaf1().setContents(data[0]);
				PatternMain.getPattern().getMicroPattern().getLeaf2().setContents(data[1]);
				PatternMain.getPattern().getMicroPattern().getLeaf3().setContents(data[2]);
				PatternMain.getPattern().getMicroPattern().getLeaf4().setContents(data[3]);
			}
		});

		Button saveTXTButton = new Button(this, SWT.NONE);
		saveTXTButton.setText("Save TXT");
		saveTXTButton.setSelection(true);
		saveTXTButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		saveTXTButton.setBounds(10, 195, 154, 25);
		saveTXTButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ArrayList<PatternComponent> kappa = ((PatternComposite) PatternMain.getPattern().getMicroPattern()
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
						ArrayList<PatternComponent> kappa2 = ((PatternComposite) PatternMain.getPattern()
								.getMicroPattern().getContainer()).getComponents();
						printToFile(dataFile, kappa2);
					}

					if (inductivePattern) {
						ArrayList<PatternComponent> kappa2 = ((PatternComposite) PatternMain.getPattern()
								.getInductiveMiniPattern().getContainer()).getComponents();
						printToFile(dataFile, kappa2);
					}

					if (deductivePattern) {
						ArrayList<PatternComponent> kappa2 = ((PatternComposite) PatternMain.getPattern()
								.getDeductiveMiniPattern().getContainer()).getComponents();
						printToFile(dataFile, kappa2);
					}

					if (gangPattern) {
						ArrayList<PatternComponent> kappa2 = ((PatternComposite) PatternMain.getPattern()
								.getGangOfFourPattern().getContainer()).getComponents();
						printToFile(dataFile, kappa2);
					}

					if (systemPattern) {
						ArrayList<PatternComponent> kappa2 = ((PatternComposite) PatternMain.getPattern()
								.getSystemOfPattern().getContainer()).getComponents();
						printToFile(dataFile, kappa2);
					}

					((DataAddTabs) dataFile).closeFile();
				}
			}
		});

		Button btnSaveLatex = new Button(this, SWT.NONE);
		btnSaveLatex.setText("Save Latex");
		btnSaveLatex.setSelection(true);
		btnSaveLatex.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		btnSaveLatex.setBounds(10, 226, 154, 25);
		btnSaveLatex.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Save to kathe leaf

				ArrayList<PatternComponent> kappa = ((PatternComposite) PatternMain.getPattern().getMicroPattern()
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