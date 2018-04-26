package read.latex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import gui.DeductiveMiniGUI;
import gui.InductiveMiniGUI;
import gui.MessageErrorDialog;
import gui.MessageFactory;
import gui.MicroPatternGUI;
import gui.PatternMain;
import gui.SystemOfPatternsGUI;

public class LatexReader {
	private static final String SUBSECTION_START = "\\subsection{";
	private static final String SUBSECTION_END = "}";
	private String patternTypeName;
	private MessageFactory messageFactory;
	private ArrayList<String> microData = new ArrayList<>();
	private ArrayList<String> inductiveData = new ArrayList<>();
	private ArrayList<String> deductiveData = new ArrayList<>();
	private ArrayList<String> gangData = new ArrayList<>();
	private ArrayList<String> systemData = new ArrayList<>();
	private boolean microPattern = false;
	private boolean inductivePattern = false;
	private boolean deductivePattern = false;
	private boolean gangPattern = false;
	private boolean systemPattern = false;
	
	public LatexReader(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(
				fileName));
		String line = reader.readLine();
		while (line != null) {
			patternName(line);
			if (patternTypeName != null) {
				if (patternTypeName.equals("Micro-Pattern Template")) {
					microData.add(line);
				} else if (patternTypeName.equals("Inductive Mini-Pattern")) {
					inductiveData.add(line);
				} else if (patternTypeName.equals("Deductive Mini-Pattern")) {
					deductiveData.add(line);
				} else if (patternTypeName.equals("Gang-of-Four Pattern")) {
					gangData.add(line);
				} else if (patternTypeName.equals("System of Patterns Template")) {
					systemData.add(line);
				} 
			}

			line = reader.readLine();
		}
		reader.close();

		if (microPattern) {
			isMicroPattern();
		}
		if (inductivePattern) {
			isInductivePattern();
		}
		if (deductivePattern) {
			isDeductivePattern();
		}
		if (gangPattern) {
			isGangPattern();
		}
		if (systemPattern) {
			isSystemPattern();
		}
	}
	
	private void isMicroPattern() {
		if (microData.contains(SUBSECTION_START + PatternMain.getPattern().getMicroPattern().getLeaf1().getTitle() + SUBSECTION_END)
				& microData.contains(SUBSECTION_START + PatternMain.getPattern().getMicroPattern().getLeaf2().getTitle() + SUBSECTION_END)
				& microData.contains(SUBSECTION_START + PatternMain.getPattern().getMicroPattern().getLeaf3().getTitle() + SUBSECTION_END)
				& microData.contains(SUBSECTION_START + PatternMain.getPattern().getMicroPattern().getLeaf4().getTitle() + SUBSECTION_END)) {
			PatternMain.getPattern().getMicroPattern().getLeaf1().setContents(microData.get(3));
			PatternMain.getPattern().getMicroPattern().getLeaf2().setContents(microData.get(5));
			PatternMain.getPattern().getMicroPattern().getLeaf3().setContents(microData.get(7));
			PatternMain.getPattern().getMicroPattern().getLeaf4().setContents(microData.get(9));
			new MicroPatternGUI(PatternMain.getDisplay(), "Testing");
		} else {
			messageFactory = new MessageErrorDialog();
			messageFactory.renderDialogWindow();
		}
	}

	private void isInductivePattern() {
		if (inductiveData.contains(SUBSECTION_START + PatternMain.getPattern().getInductiveMiniPattern().getLeaf1().getTitle() + SUBSECTION_END)
				& inductiveData.contains(SUBSECTION_START + PatternMain.getPattern().getInductiveMiniPattern().getLeaf2().getTitle() + SUBSECTION_END)
				& inductiveData.contains(SUBSECTION_START + PatternMain.getPattern().getInductiveMiniPattern().getLeaf3().getTitle() + SUBSECTION_END)
				& inductiveData.contains(SUBSECTION_START + PatternMain.getPattern().getInductiveMiniPattern().getLeaf4().getTitle() + SUBSECTION_END)
				& inductiveData.contains(SUBSECTION_START + PatternMain.getPattern().getInductiveMiniPattern().getLeaf5().getTitle() + SUBSECTION_END)) {
			PatternMain.getPattern().getInductiveMiniPattern().getLeaf1().setContents(inductiveData.get(3));
			PatternMain.getPattern().getInductiveMiniPattern().getLeaf2().setContents(inductiveData.get(5));
			PatternMain.getPattern().getInductiveMiniPattern().getLeaf3().setContents(inductiveData.get(7));
			PatternMain.getPattern().getInductiveMiniPattern().getLeaf4().setContents(inductiveData.get(9));
			PatternMain.getPattern().getInductiveMiniPattern().getLeaf5().setContents(inductiveData.get(11));
			new InductiveMiniGUI(PatternMain.getDisplay(), "Testing");
		} else {
			messageFactory = new MessageErrorDialog();
			messageFactory.renderDialogWindow();
		}
	}

	private void isDeductivePattern() {
		if (deductiveData.contains(SUBSECTION_START + PatternMain.getPattern().getDeductiveMiniPattern().getLeaf1().getTitle() + SUBSECTION_END)
				& deductiveData.contains(SUBSECTION_START + PatternMain.getPattern().getDeductiveMiniPattern().getLeaf2().getTitle() + SUBSECTION_END)
				& deductiveData.contains(SUBSECTION_START + PatternMain.getPattern().getDeductiveMiniPattern().getLeaf3().getTitle() + SUBSECTION_END)
				& deductiveData.contains(SUBSECTION_START + PatternMain.getPattern().getDeductiveMiniPattern().getLeaf4().getTitle() + SUBSECTION_END)
				& deductiveData.contains(SUBSECTION_START + PatternMain.getPattern().getDeductiveMiniPattern().getLeaf5().getTitle() + SUBSECTION_END)
				& deductiveData.contains(SUBSECTION_START + PatternMain.getPattern().getDeductiveMiniPattern().getLeaf6().getTitle() + SUBSECTION_END)) {
			PatternMain.getPattern().getDeductiveMiniPattern().getLeaf1().setContents(deductiveData.get(3));
			PatternMain.getPattern().getDeductiveMiniPattern().getLeaf2().setContents(deductiveData.get(5));
			PatternMain.getPattern().getDeductiveMiniPattern().getLeaf3().setContents(deductiveData.get(7));
			PatternMain.getPattern().getDeductiveMiniPattern().getLeaf4().setContents(deductiveData.get(9));
			PatternMain.getPattern().getDeductiveMiniPattern().getLeaf5().setContents(deductiveData.get(11));
			PatternMain.getPattern().getDeductiveMiniPattern().getLeaf6().setContents(deductiveData.get(13));
			new DeductiveMiniGUI(PatternMain.getDisplay(), "Testing");
		} else {
			messageFactory = new MessageErrorDialog();
			messageFactory.renderDialogWindow();
		}
	}

	private void isGangPattern() {
		if (gangData.contains(SUBSECTION_START + PatternMain.getPattern().getGangOfFourPattern().getLeaf1().getTitle())
				& gangData.contains(SUBSECTION_START + PatternMain.getPattern().getGangOfFourPattern().getLeaf2().getTitle() + SUBSECTION_END)
				& gangData.contains(SUBSECTION_START + PatternMain.getPattern().getGangOfFourPattern().getLeaf3().getTitle() + SUBSECTION_END)
				& gangData.contains(SUBSECTION_START + PatternMain.getPattern().getGangOfFourPattern().getLeaf4().getTitle() + SUBSECTION_END)
				& gangData.contains(SUBSECTION_START + PatternMain.getPattern().getGangOfFourPattern().getLeaf5().getTitle() + SUBSECTION_END)
				& gangData.contains(SUBSECTION_START + PatternMain.getPattern().getGangOfFourPattern().getLeaf6().getTitle() + SUBSECTION_END)
				& gangData.contains(SUBSECTION_START + PatternMain.getPattern().getGangOfFourPattern().getLeaf7().getTitle() + SUBSECTION_END)
				& gangData.contains(SUBSECTION_START + PatternMain.getPattern().getGangOfFourPattern().getLeaf8().getTitle() + SUBSECTION_END)
				& gangData.contains(SUBSECTION_START + PatternMain.getPattern().getGangOfFourPattern().getLeaf9().getTitle() + SUBSECTION_END)
				& gangData.contains(SUBSECTION_START + PatternMain.getPattern().getGangOfFourPattern().getLeaf10().getTitle() + SUBSECTION_END)
				& gangData.contains(SUBSECTION_START + PatternMain.getPattern().getGangOfFourPattern().getLeaf11().getTitle() + SUBSECTION_END)
				& gangData.contains(SUBSECTION_START + PatternMain.getPattern().getGangOfFourPattern().getLeaf12().getTitle() + SUBSECTION_END)
				& gangData.contains(SUBSECTION_START + PatternMain.getPattern().getGangOfFourPattern().getLeaf13().getTitle() + SUBSECTION_END)
				& gangData.contains(SUBSECTION_START + PatternMain.getPattern().getGangOfFourPattern().getLeaf14().getTitle() + SUBSECTION_END)
				& gangData.contains(SUBSECTION_START + PatternMain.getPattern().getGangOfFourPattern().getLeaf15().getTitle() + SUBSECTION_END)) {
			
			PatternMain.getPattern().getGangOfFourPattern().getLeaf1().setContents(gangData.get(3));
			PatternMain.getPattern().getGangOfFourPattern().getLeaf2().setContents(gangData.get(5));
			PatternMain.getPattern().getGangOfFourPattern().getLeaf3().setContents(gangData.get(7));
			PatternMain.getPattern().getGangOfFourPattern().getLeaf4().setContents(gangData.get(9));
			PatternMain.getPattern().getGangOfFourPattern().getLeaf5().setContents(gangData.get(11));
			PatternMain.getPattern().getGangOfFourPattern().getLeaf6().setContents(gangData.get(13));
			PatternMain.getPattern().getGangOfFourPattern().getLeaf7().setContents(gangData.get(15));
			PatternMain.getPattern().getGangOfFourPattern().getLeaf8().setContents(gangData.get(17));
			PatternMain.getPattern().getGangOfFourPattern().getLeaf9().setContents(gangData.get(19));
			PatternMain.getPattern().getGangOfFourPattern().getLeaf10().setContents(gangData.get(21));
			PatternMain.getPattern().getGangOfFourPattern().getLeaf11().setContents(gangData.get(23));
			PatternMain.getPattern().getGangOfFourPattern().getLeaf12().setContents(gangData.get(25));
			PatternMain.getPattern().getGangOfFourPattern().getLeaf13().setContents(gangData.get(27));
			PatternMain.getPattern().getGangOfFourPattern().getLeaf14().setContents(gangData.get(29));
			PatternMain.getPattern().getGangOfFourPattern().getLeaf15().setContents(gangData.get(31));
			new DeductiveMiniGUI(PatternMain.getDisplay(), "Testing");
		} else {
			messageFactory = new MessageErrorDialog();
			messageFactory.renderDialogWindow();
		}
	}
	
	private void isSystemPattern() {
		if (systemData.contains(SUBSECTION_START + PatternMain.getPattern().getSystemOfPattern().getLeaf1().getTitle() + SUBSECTION_END)
				& systemData.contains(SUBSECTION_START + PatternMain.getPattern().getSystemOfPattern().getLeaf2().getTitle() + SUBSECTION_END)
				& systemData.contains(SUBSECTION_START + PatternMain.getPattern().getSystemOfPattern().getLeaf3().getTitle() + SUBSECTION_END)
				& systemData.contains(SUBSECTION_START + PatternMain.getPattern().getSystemOfPattern().getLeaf4().getTitle() + SUBSECTION_END)
				& systemData.contains(SUBSECTION_START + PatternMain.getPattern().getSystemOfPattern().getLeaf5().getTitle() + SUBSECTION_END)
				& systemData.contains(SUBSECTION_START + PatternMain.getPattern().getSystemOfPattern().getLeaf6().getTitle() + SUBSECTION_END)
				& systemData.contains(SUBSECTION_START + PatternMain.getPattern().getSystemOfPattern().getLeaf7().getTitle() + SUBSECTION_END)
				& systemData.contains(SUBSECTION_START + PatternMain.getPattern().getSystemOfPattern().getLeaf8().getTitle() + SUBSECTION_END)
				& systemData.contains(SUBSECTION_START + PatternMain.getPattern().getSystemOfPattern().getLeaf9().getTitle() + SUBSECTION_END)
				& systemData.contains(SUBSECTION_START + PatternMain.getPattern().getSystemOfPattern().getLeaf10().getTitle() + SUBSECTION_END)
				& systemData.contains(SUBSECTION_START + PatternMain.getPattern().getSystemOfPattern().getLeaf11().getTitle() + SUBSECTION_END)
				& systemData.contains(SUBSECTION_START + PatternMain.getPattern().getSystemOfPattern().getLeaf12().getTitle() + SUBSECTION_END)
				& systemData.contains(SUBSECTION_START + PatternMain.getPattern().getSystemOfPattern().getLeaf13().getTitle() + SUBSECTION_END)) {
			
			PatternMain.getPattern().getSystemOfPattern().getLeaf1().setContents(systemData.get(3));
			PatternMain.getPattern().getSystemOfPattern().getLeaf2().setContents(systemData.get(5));
			PatternMain.getPattern().getSystemOfPattern().getLeaf3().setContents(systemData.get(7));
			PatternMain.getPattern().getSystemOfPattern().getLeaf4().setContents(systemData.get(9));
			PatternMain.getPattern().getSystemOfPattern().getLeaf5().setContents(systemData.get(11));
			PatternMain.getPattern().getSystemOfPattern().getLeaf6().setContents(systemData.get(13));
			PatternMain.getPattern().getSystemOfPattern().getLeaf7().setContents(systemData.get(15));
			PatternMain.getPattern().getSystemOfPattern().getLeaf8().setContents(systemData.get(17));
			PatternMain.getPattern().getSystemOfPattern().getLeaf9().setContents(systemData.get(19));
			PatternMain.getPattern().getSystemOfPattern().getLeaf10().setContents(systemData.get(21));
			PatternMain.getPattern().getSystemOfPattern().getLeaf11().setContents(systemData.get(23));
			PatternMain.getPattern().getSystemOfPattern().getLeaf12().setContents(systemData.get(25));
			PatternMain.getPattern().getSystemOfPattern().getLeaf13().setContents(systemData.get(27));
			new SystemOfPatternsGUI(PatternMain.getDisplay(), "Testing");
		} else {
			messageFactory = new MessageErrorDialog();
			messageFactory.renderDialogWindow();
		}
	}
	
	private void patternName(String name) {
		if (name.contains("Micro-Pattern Template")) {
			patternTypeName = "Micro-Pattern Template";
			microPattern = true;
		} else if (name.contains("Inductive Mini-Pattern")) {
			patternTypeName = "Inductive Mini-Pattern";
			inductivePattern = true;
		} else if (name.contains("Deductive Mini-Pattern")) {
			patternTypeName = "Deductive Mini-Pattern";
			deductivePattern = true;
		} else if (name.contains("Gang-of-Four Pattern")) {
			patternTypeName = "Gang-of-Four Pattern";
			gangPattern = true;
		} else if (name.contains("System of Patterns Template")) {
			patternTypeName = "System of Patterns Template";
			systemPattern = true;
		}
	}
}
