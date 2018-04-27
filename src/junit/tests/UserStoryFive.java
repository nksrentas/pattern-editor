package junit.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import data.source.DataAddTabs;
import data.source.DataFile;
import data.source.DataTxt;
import datamodel.InductiveMiniPattern;
import datamodel.MicroPattern;
import datamodel.Pattern;

class UserStoryFive {

	@Test
	void test() {
		// Write to file
		Pattern pattern = new Pattern();
		pattern.init();
		MicroPattern microPattern = pattern.getMicroPattern();
		
		DataFile dataFile = new DataTxt();
		dataFile.initStream("TESTING_TXT", "txt");
		dataFile = new DataAddTabs(dataFile);
		
		dataFile.writeFile(microPattern.getContainer().getTitle());
		
		dataFile.writeFile(microPattern.getLeaf1().getTitle());
		dataFile.writeFile(microPattern.getLeaf1().getContents());
		
		dataFile.writeFile(microPattern.getLeaf2().getTitle());
		dataFile.writeFile(microPattern.getLeaf2().getContents());

		dataFile.writeFile(microPattern.getLeaf3().getTitle());
		dataFile.writeFile(microPattern.getLeaf3().getContents());

		dataFile.writeFile(microPattern.getLeaf4().getTitle());
		dataFile.writeFile(microPattern.getLeaf4().getContents());
		
		((DataAddTabs) dataFile).closeFile();
		
		
		
		
		// Read from file
		ArrayList<String> data = new ArrayList<String>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"TESTING_TXT.txt"));
			String line = reader.readLine();
			while (line != null) {
				data.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		System.out.println(data.toString());
		
		MicroPattern microPatternNew = pattern.getMicroPattern();
		assertEquals("\tName: What shall this pattern be called by practitioners?", data.get(1));
		assertEquals("\tTemplate: Which template is followed for the pattern specification?", data.get(3));
		assertEquals("\tProblem: What is motivation us to apply this pattern?", data.get(5));
		assertEquals("\tSolution: How do we solve the problem?" , data.get(7));
		
		
		
	}

}
