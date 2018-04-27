package gui;

import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import data.source.DataFile;
import data.source.DataTxt;
import datamodel.Pattern;
import read.latex.LatexReader;

public class PatternMain {
	private final static String MICRO_PATTERN_TEMPLATE = "Micro-Pattern Template";
	private final static String INDUCTIVE_MINI_PATTERN = "Inductive Mini-Pattern";
	private final static String DEDUCTIVE_MINI_PATTERN = "Deductive Mini-Pattern";
	private final static String GANG_OF__FOUR_PATTERN = "Gang-of-Four Pattern";
	private final static String SYSTEM_OF_PATTERNS_TEMPLATE = "System of Patterns Template";
	private final static String TEXT_FONT = "Yu Gothic UI Semilight";
	private final static String DEFAULT_PATTERN_NAME = "Default name";
	private Button createPatternButton;
	private static String selectedRadioButton = "";
	protected static Shell shlPatternsEditor;
	private Text patternLanguageNameTextField;
	private Button microPatternRadio;
	private static MessageFactory messageFactory;
	private Monitor primary;
	private static Display display;
	private static Pattern pattern;

	public static void main(String[] args) {
		try {
			PatternMain window = new PatternMain();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {
		display = Display.getDefault();
		createContents();
		setWindowsPosition();
		shlPatternsEditor.open();
		shlPatternsEditor.layout();
		while (!shlPatternsEditor.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	protected void createContents() {
		shlPatternsEditor = new Shell(SWT.DIALOG_TRIM);
		shlPatternsEditor.setImage(SWTResourceManager.getImage(PatternMain.class, "/gui/icons8-code-fork-50.png"));
		shlPatternsEditor.setMinimumSize(new Point(136, 41));
		shlPatternsEditor.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		shlPatternsEditor.setSize(392, 374);
		shlPatternsEditor.setText("Patterns Editor");
		shlPatternsEditor.setLayout(null);

		pattern = new Pattern();
		pattern.init();

		CLabel topHeader = new CLabel(shlPatternsEditor, SWT.CENTER);
		topHeader.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		topHeader.setFont(SWTResourceManager.getFont(TEXT_FONT, 13, SWT.NORMAL));
		topHeader.setBounds(0, 0, 386, 55);
		topHeader.setText("Create your own pattern language");

		Label patternLanguageNameLabel = new Label(shlPatternsEditor, SWT.NONE);
		patternLanguageNameLabel.setFont(SWTResourceManager.getFont(TEXT_FONT, 12, SWT.NORMAL));
		patternLanguageNameLabel.setBounds(10, 74, 189, 21);
		patternLanguageNameLabel.setText("Pattern language name");

		patternLanguageNameTextField = new Text(shlPatternsEditor, SWT.BORDER);
		patternLanguageNameTextField.setToolTipText("Enter pattern language name");
		patternLanguageNameTextField.setFont(SWTResourceManager.getFont(TEXT_FONT, 12, SWT.NORMAL));
		patternLanguageNameTextField.setBounds(10, 101, 367, 31);

		Label patternLanguageTemplateLabel = new Label(shlPatternsEditor, SWT.NONE);
		patternLanguageTemplateLabel.setFont(SWTResourceManager.getFont(TEXT_FONT, 12, SWT.NORMAL));
		patternLanguageTemplateLabel.setBounds(10, 148, 208, 21);
		patternLanguageTemplateLabel.setText("Pattern language template");

		Group radioButtonGroup = new Group(shlPatternsEditor, SWT.SHADOW_OUT);
		radioButtonGroup.setFont(SWTResourceManager.getFont(TEXT_FONT, 12, SWT.NORMAL));
		radioButtonGroup.setBounds(10, 175, 367, 82);

		SelectionListener selectionListener = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				Button button = ((Button) event.widget);
				if (button.getSelection()) {
					selectedRadioButton = button.getText();
				}
			};
		};

		microPatternRadio = new Button(radioButtonGroup, SWT.RADIO);
		microPatternRadio.setFont(SWTResourceManager.getFont(TEXT_FONT, 10, SWT.NORMAL));
		microPatternRadio.setBounds(10, 12, 151, 17);
		microPatternRadio.setText(MICRO_PATTERN_TEMPLATE);
		microPatternRadio.addSelectionListener(selectionListener);

		Button inductiveRadio = new Button(radioButtonGroup, SWT.RADIO);
		inductiveRadio.setFont(SWTResourceManager.getFont(TEXT_FONT, 10, SWT.NORMAL));
		inductiveRadio.setBounds(10, 34, 151, 16);
		inductiveRadio.setText(INDUCTIVE_MINI_PATTERN);
		inductiveRadio.addSelectionListener(selectionListener);

		Button deductiveRadio = new Button(radioButtonGroup, SWT.RADIO);
		deductiveRadio.setFont(SWTResourceManager.getFont(TEXT_FONT, 10, SWT.NORMAL));
		deductiveRadio.setBounds(10, 56, 151, 16);
		deductiveRadio.setText(DEDUCTIVE_MINI_PATTERN);
		deductiveRadio.addSelectionListener(selectionListener);

		Button gangFourRadio = new Button(radioButtonGroup, SWT.RADIO);
		gangFourRadio.setFont(SWTResourceManager.getFont(TEXT_FONT, 10, SWT.NORMAL));
		gangFourRadio.setBounds(183, 12, 142, 22);
		gangFourRadio.setText(GANG_OF__FOUR_PATTERN);
		gangFourRadio.addSelectionListener(selectionListener);

		Button systemPatternRadio = new Button(radioButtonGroup, SWT.RADIO);
		systemPatternRadio.setFont(SWTResourceManager.getFont(TEXT_FONT, 10, SWT.NORMAL));
		systemPatternRadio.setBounds(183, 31, 181, 22);
		systemPatternRadio.setText(SYSTEM_OF_PATTERNS_TEMPLATE);
		systemPatternRadio.addSelectionListener(selectionListener);

		createPatternButton = new Button(shlPatternsEditor, SWT.FLAT | SWT.CENTER);
		createPatternButton.setFont(SWTResourceManager.getFont(TEXT_FONT, 12, SWT.NORMAL));
		createPatternButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (checkEmptyTextField() | checkEmptyRadioButton()) {
					messageFactory = new MessageInfoDialog();
					messageFactory.renderDialogWindow();
				}

				switch (selectedRadioButton) {
				case MICRO_PATTERN_TEMPLATE:
					new MicroPatternGUI(display, patternLanguageNameTextField.getText());
					break;
				case INDUCTIVE_MINI_PATTERN:
					new InductiveMiniGUI(display, patternLanguageNameTextField.getText());
					break;
				case DEDUCTIVE_MINI_PATTERN:
					new DeductiveMiniGUI(display, patternLanguageNameTextField.getText());
					break;
				case GANG_OF__FOUR_PATTERN:
					new GangFourGUI(display, patternLanguageNameTextField.getText());
					break;
				case SYSTEM_OF_PATTERNS_TEMPLATE:
					new SystemOfPatternsGUI(display, patternLanguageNameTextField.getText());
					break;
				default:
					new MicroPatternGUI(display, patternLanguageNameTextField.getText());
					break;
				}
			}
		});
		createPatternButton.setBounds(10, 276, 109, 31);
		createPatternButton.setText("Create");

		Button loadPatternButton = new Button(shlPatternsEditor, SWT.FLAT | SWT.CENTER);
		loadPatternButton.setText("Load");
		loadPatternButton.setFont(SWTResourceManager.getFont("Yu Gothic UI Semilight", 12, SWT.NORMAL));
		loadPatternButton.setBounds(125, 276, 109, 31);
		loadPatternButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialogSWT fileDialogSWT = new FileDialogSWT(display);
				String fileName = fileDialogSWT.getFileName();

				if (fileName.contains(".txt")) {
					// Read file
					DataFile dataFile = new DataTxt();
					dataFile.initReadStream(fileName);
					
					try {
						dataFile.readFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					try {
						LatexReader latexReader = new LatexReader(fileName);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}

	private boolean checkEmptyTextField() {
		if (patternLanguageNameTextField.getText().isEmpty()) {
			setDefaultTextField();
			return true;
		}
		return false;
	}

	private boolean checkEmptyRadioButton() {
		if (selectedRadioButton.isEmpty()) {
			setDefaultRadioButton();
			return true;
		}
		return false;
	}

	private void setDefaultRadioButton() {
		microPatternRadio.setSelection(true);
	}

	private void setDefaultTextField() {
		patternLanguageNameTextField.setText(DEFAULT_PATTERN_NAME);
	}

	private void setWindowsPosition() {
		primary = display.getPrimaryMonitor();
		Rectangle bounds = primary.getBounds();
		Rectangle rect = shlPatternsEditor.getBounds();
		int x = bounds.x + (bounds.width - rect.width) / 2;
		int y = bounds.y + (bounds.height - rect.height) / 2;
		shlPatternsEditor.setLocation(x, y);
	}

	public static Pattern getPattern() {
		return pattern;
	}

	public static void setPattern(Pattern pattern) {
		PatternMain.pattern = pattern;
	}

	public static Display getDisplay() {
		return display;
	}

	public Text getPatternLanguageNameTextField() {
		return patternLanguageNameTextField;
	}

	public void setPatternLanguageNameTextField(Text patternLanguageNameTextField) {
		this.patternLanguageNameTextField = patternLanguageNameTextField;
	}

	public Button getCreatePatternButton() {
		return createPatternButton;
	}
}
