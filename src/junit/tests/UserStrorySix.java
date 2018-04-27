package junit.tests;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.swt.widgets.Display;
import org.junit.jupiter.api.Test;

import datamodel.MicroPattern;
import datamodel.Pattern;
import gui.FileDialogSWT;

class UserStrorySix {
	private ArrayList<String> microData = new ArrayList<>();
	@Test
	void test() {
		Pattern pattern = new Pattern();
		pattern.init();
		MicroPattern microPattern = pattern.getMicroPattern();
		
		FileDialogSWT fileDialogSWT = new FileDialogSWT(new Display());
		String fileName = fileDialogSWT.getFileName();
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					fileName));
			String line = reader.readLine();
			while (line != null) {
				microData.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		microPattern.getLeaf1().setContents(microData.get(3));
		microPattern.getLeaf2().setContents(microData.get(5));
		microPattern.getLeaf3().setContents(microData.get(7));
		microPattern.getLeaf4().setContents(microData.get(9));
		
		assertEquals("\tENA", microPattern.getLeaf1().getContents());
		assertEquals("\tDIO", microPattern.getLeaf2().getContents());
		assertEquals("\tTRIA", microPattern.getLeaf3().getContents());
		assertEquals("\tTESSERA" , microPattern.getLeaf4().getContents());
	}

}
