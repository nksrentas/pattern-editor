package junit.tests;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gui.PatternMain;

class UserStoryOne {

	@Test
	void test() {
		PatternMain patternMain = new PatternMain();
		patternMain.setPatternLanguageNameTextField(null);
		assertNull("Check empty pattern language name", patternMain.getPatternLanguageNameTextField());
		
	}

}
