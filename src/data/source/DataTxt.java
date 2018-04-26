package data.source;

import java.io.IOException;
import java.util.ArrayList;

import gui.DeductiveMiniGUI;
import gui.InductiveMiniGUI;
import gui.MessageErrorDialog;
import gui.MessageFactory;
import gui.MicroPatternGUI;
import gui.PatternMain;
import gui.SystemOfPatternsGUI;

public class DataTxt extends DataFile {
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

	public DataTxt() {
	}

	@Override
	public void writeFile(String line) {
		try {
			printWriter.println(line);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void readFile() throws IOException {
		String line = reader.readLine();
		while (line != null) {
			patternName(line);
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
		if (microData.contains(PatternMain.getPattern().getMicroPattern().getLeaf1().getTitle())
				& microData.contains(PatternMain.getPattern().getMicroPattern().getLeaf2().getTitle())
				& microData.contains(PatternMain.getPattern().getMicroPattern().getLeaf3().getTitle())
				& microData.contains(PatternMain.getPattern().getMicroPattern().getLeaf4().getTitle())) {
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
		if (inductiveData.contains(PatternMain.getPattern().getInductiveMiniPattern().getLeaf1().getTitle())
				& inductiveData.contains(PatternMain.getPattern().getInductiveMiniPattern().getLeaf2().getTitle())
				& inductiveData.contains(PatternMain.getPattern().getInductiveMiniPattern().getLeaf3().getTitle())
				& inductiveData.contains(PatternMain.getPattern().getInductiveMiniPattern().getLeaf4().getTitle())
				& inductiveData.contains(PatternMain.getPattern().getInductiveMiniPattern().getLeaf5().getTitle())) {
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
		if (deductiveData.contains(PatternMain.getPattern().getDeductiveMiniPattern().getLeaf1().getTitle())
				& deductiveData.contains(PatternMain.getPattern().getDeductiveMiniPattern().getLeaf2().getTitle())
				& deductiveData.contains(PatternMain.getPattern().getDeductiveMiniPattern().getLeaf3().getTitle())
				& deductiveData.contains(PatternMain.getPattern().getDeductiveMiniPattern().getLeaf4().getTitle())
				& deductiveData.contains(PatternMain.getPattern().getDeductiveMiniPattern().getLeaf5().getTitle())
				& deductiveData.contains(PatternMain.getPattern().getDeductiveMiniPattern().getLeaf6().getTitle())) {
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
		if (gangData.contains(PatternMain.getPattern().getGangOfFourPattern().getLeaf1().getTitle())
				& gangData.contains(PatternMain.getPattern().getGangOfFourPattern().getLeaf2().getTitle())
				& gangData.contains(PatternMain.getPattern().getGangOfFourPattern().getLeaf3().getTitle())
				& gangData.contains(PatternMain.getPattern().getGangOfFourPattern().getLeaf4().getTitle())
				& gangData.contains(PatternMain.getPattern().getGangOfFourPattern().getLeaf5().getTitle())
				& gangData.contains(PatternMain.getPattern().getGangOfFourPattern().getLeaf6().getTitle())
				& gangData.contains(PatternMain.getPattern().getGangOfFourPattern().getLeaf7().getTitle())
				& gangData.contains(PatternMain.getPattern().getGangOfFourPattern().getLeaf8().getTitle())
				& gangData.contains(PatternMain.getPattern().getGangOfFourPattern().getLeaf9().getTitle())
				& gangData.contains(PatternMain.getPattern().getGangOfFourPattern().getLeaf10().getTitle())
				& gangData.contains(PatternMain.getPattern().getGangOfFourPattern().getLeaf11().getTitle())
				& gangData.contains(PatternMain.getPattern().getGangOfFourPattern().getLeaf12().getTitle())
				& gangData.contains(PatternMain.getPattern().getGangOfFourPattern().getLeaf13().getTitle())
				& gangData.contains(PatternMain.getPattern().getGangOfFourPattern().getLeaf14().getTitle())
				& gangData.contains(PatternMain.getPattern().getGangOfFourPattern().getLeaf15().getTitle())) {
			
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
		if (systemData.contains(PatternMain.getPattern().getSystemOfPattern().getLeaf1().getTitle())
				& systemData.contains(PatternMain.getPattern().getSystemOfPattern().getLeaf2().getTitle())
				& systemData.contains(PatternMain.getPattern().getSystemOfPattern().getLeaf3().getTitle())
				& systemData.contains(PatternMain.getPattern().getSystemOfPattern().getLeaf4().getTitle())
				& systemData.contains(PatternMain.getPattern().getSystemOfPattern().getLeaf5().getTitle())
				& systemData.contains(PatternMain.getPattern().getSystemOfPattern().getLeaf6().getTitle())
				& systemData.contains(PatternMain.getPattern().getSystemOfPattern().getLeaf7().getTitle())
				& systemData.contains(PatternMain.getPattern().getSystemOfPattern().getLeaf8().getTitle())
				& systemData.contains(PatternMain.getPattern().getSystemOfPattern().getLeaf9().getTitle())
				& systemData.contains(PatternMain.getPattern().getSystemOfPattern().getLeaf10().getTitle())
				& systemData.contains(PatternMain.getPattern().getSystemOfPattern().getLeaf11().getTitle())
				& systemData.contains(PatternMain.getPattern().getSystemOfPattern().getLeaf12().getTitle())
				& systemData.contains(PatternMain.getPattern().getSystemOfPattern().getLeaf13().getTitle())) {
			
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
		if (name.equals("Micro-Pattern Template")) {
			patternTypeName = "Micro-Pattern Template";
			microPattern = true;
		} else if (name.equals("Inductive Mini-Pattern")) {
			patternTypeName = "Inductive Mini-Pattern";
			inductivePattern = true;
		} else if (name.equals("Deductive Mini-Pattern")) {
			patternTypeName = "Deductive Mini-Pattern";
			deductivePattern = true;
		} else if (name.equals("Gang-of-Four Pattern")) {
			patternTypeName = "Gang-of-Four Pattern";
			gangPattern = true;
		} else if (name.equals("System of Patterns Template")) {
			patternTypeName = "System of Patterns Template";
			systemPattern = true;
		}
	}
}
