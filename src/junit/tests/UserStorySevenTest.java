package junit.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import data.source.DataAddTabs;
import data.source.DataFile;
import data.source.DataLatextSyntax;
import data.source.DataTxt;
import datamodel.MicroPattern;
import datamodel.Pattern;

class UserStorySevenTest {

	@Test
	void test() {
		// Write to file
				Pattern pattern = new Pattern();
				pattern.init();
				MicroPattern microPattern = pattern.getMicroPattern();
				
				DataFile dataFileLatex = new DataTxt();
				dataFileLatex.initStream("TESTING_LATEX", "tex");
				dataFileLatex = new DataLatextSyntax(dataFileLatex, "TESTING_LATEX");
				
				dataFileLatex.writeFile(microPattern.getContainer().getTitle());
				dataFileLatex.writeFile(microPattern.getContainer().getContents());
				
				dataFileLatex.writeFile(microPattern.getLeaf1().getTitle());
				dataFileLatex.writeFile(microPattern.getLeaf1().getContents());
				
				dataFileLatex.writeFile(microPattern.getLeaf2().getTitle());
				dataFileLatex.writeFile(microPattern.getLeaf2().getContents());

				dataFileLatex.writeFile(microPattern.getLeaf3().getTitle());
				dataFileLatex.writeFile(microPattern.getLeaf3().getContents());

				dataFileLatex.writeFile(microPattern.getLeaf4().getTitle());
				dataFileLatex.writeFile(microPattern.getLeaf4().getContents());
				
				((DataLatextSyntax) dataFileLatex).closeFile();
	
				// Read from file
				ArrayList<String> data = new ArrayList<String>();
				BufferedReader reader;
				try {
					reader = new BufferedReader(new FileReader(
							"TESTING_LATEX.tex"));
					String line = reader.readLine();
					while (line != null) {
						data.add(line);
						line = reader.readLine();
					}
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

				assertEquals("\\subsection{Name: What shall this pattern be called by practitioners?}", data.get(6));
				assertEquals("\\subsection{Template: Which template is followed for the pattern specification?}", data.get(8));
				assertEquals("\\subsection{Problem: What is motivation us to apply this pattern?}", data.get(10));
				assertEquals("\\subsection{Solution: How do we solve the problem?}" , data.get(12));
				
	}

}
