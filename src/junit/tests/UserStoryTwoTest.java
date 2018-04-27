package junit.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import datamodel.DeductiveMiniPattern;
import datamodel.GangOfFourPattern;
import datamodel.InductiveMiniPattern;
import datamodel.MicroPattern;
import datamodel.Pattern;
import datamodel.SystemOfPattern;

class UserStoryTwoTest {
	@Test
	void testMicro() {
		Pattern pattern = new Pattern();
		pattern.init();
		
		MicroPattern microPattern = pattern.getMicroPattern();
		assertEquals("Name: What shall this pattern be called by practitioners?", microPattern.getLeaf1().getTitle());
		assertEquals("Template: Which template is followed for the pattern specification?", microPattern.getLeaf2().getTitle());
		assertEquals("Problem: What is motivation us to apply this pattern?", microPattern.getLeaf3().getTitle());
		assertEquals("Solution: How do we solve the problem?" , microPattern.getLeaf4().getTitle());
		
		
		microPattern.getLeaf4().setContents("DUMMY DATA");
		assertEquals("DUMMY DATA" , microPattern.getLeaf4().getContents());
	}
	
	@Test
	void testInductive() {
		Pattern pattern = new Pattern();
		pattern.init();
		
		InductiveMiniPattern inductive = pattern.getInductiveMiniPattern();
		assertEquals("Name: What shall this pattern be called by practitioners?", inductive.getLeaf1().getTitle());
		assertEquals("Template: Which template is followed for the pattern specification?", inductive.getLeaf2().getTitle());
		assertEquals( "Context: what are the assume enviroment or priori assumption "
				+ "for applying this pattern?", inductive.getLeaf3().getTitle());
		assertEquals("Forces: What are the different design motivations that must be balance?" ,inductive.getLeaf4().getTitle());
		assertEquals("Solution: How do we solve the problem?" , inductive.getLeaf5().getTitle());
		
		inductive.getLeaf4().setContents("DUMMY DATA");
		assertEquals("DUMMY DATA" , inductive.getLeaf4().getContents());
	}
	
	@Test
	void testDeductive() {
		Pattern pattern = new Pattern();
		pattern.init();
		
		DeductiveMiniPattern deductive = pattern.getDeductiveMiniPattern();
		assertEquals("Name: What shall this pattern be called by practitioners?", deductive.getLeaf1().getTitle());
		assertEquals("Template: Which template is followed for the pattern specification?", deductive.getLeaf2().getTitle());
		assertEquals("Problem: What is motivation us to apply this pattern?", deductive.getLeaf3().getTitle());
		assertEquals("Solution: How do we solve the problem?" ,deductive.getLeaf4().getTitle());
		assertEquals("Benefit: What are the potential positive outcomes of applying this pattern?" , deductive.getLeaf5().getTitle());
		assertEquals("Consequences: What are the pontential shortcomings and consequences of appyling this pattern?" , deductive.getLeaf6().getTitle());
		
		deductive.getLeaf4().setContents("DUMMY DATA");
		assertEquals("DUMMY DATA" , deductive.getLeaf4().getContents());
	}
	
	@Test
	void testGang() {
		Pattern pattern = new Pattern();
		pattern.init();
		
		GangOfFourPattern gang = pattern.getGangOfFourPattern();
		assertEquals("Name: What shall this pattern be called by practitioners?", gang.getLeaf1().getTitle());
		assertEquals("Template: Which template is followed for the pattern specification?", gang.getLeaf2().getTitle());
		assertEquals("Pattern Classification: Is the pattern creational, structual, or behavioral?", gang.getLeaf3().getTitle());
		assertEquals("Intent: What problem does this pattern solve?" ,gang.getLeaf4().getTitle());
		assertEquals("Also know as: What are other name for this pattern?" , gang.getLeaf5().getTitle());
		assertEquals("Motivation: What is an example scenario for applying this pattern?" , gang.getLeaf6().getTitle());
		assertEquals("Applicability: When does this pattern apply?" , gang.getLeaf7().getTitle());
		assertEquals("Structure: Which are the classes of the objects in this pattern?" , gang.getLeaf8().getTitle());
		assertEquals("Participants: What are the objects that participate in this pattern?" , gang.getLeaf9().getTitle());
		assertEquals("Collaborations: How do these objects interoperate?" , gang.getLeaf10().getTitle());
		assertEquals("Consequences: What are the pontential shortcomings and consequences of appyling this pattern?" , gang.getLeaf11().getTitle());
		assertEquals("Implemetation: Which techniques or issues arise in applying this pattern?" , gang.getLeaf12().getTitle());
		assertEquals("Sample code: What are some examples of real ssytems using this pattern?" , gang.getLeaf13().getTitle());
		assertEquals("Known uses: What are some examples of real systems using this pattern?" , gang.getLeaf14().getTitle());
		assertEquals("Related patterns: What other patterns from this pattern collection are related to this pattern?" , gang.getLeaf15().getTitle());
		
		gang.getLeaf4().setContents("DUMMY DATA");
		assertEquals("DUMMY DATA" , gang.getLeaf4().getContents());
	}
	
	@Test
	void testSystem() {
		Pattern pattern = new Pattern();
		pattern.init();
		
		SystemOfPattern system = pattern.getSystemOfPattern();
		assertEquals("Name: What shall this pattern be called by practitioners?", system.getLeaf1().getTitle());
		assertEquals("Template: Which template is followed for the pattern specification?", system.getLeaf2().getTitle());
		assertEquals("Also know as: What are other name for this pattern?", system.getLeaf3().getTitle());
		assertEquals("Example: What is a example of the need for this pattern?" ,system.getLeaf4().getTitle());
		assertEquals("Context: what are the assume enviroment or priori assumption "
				+ "for applying this pattern?", system.getLeaf5().getTitle());
		assertEquals("Problem: What is motivation us to apply this pattern?" , system.getLeaf6().getTitle());
		assertEquals("Solution: How do we solve the problem?" , system.getLeaf7().getTitle());
		assertEquals("Structure: Which are the classes of the objects in this pattern?" , system.getLeaf8().getTitle());
		assertEquals("Dynamic: How do these objects collaborate?" , system.getLeaf9().getTitle());
		assertEquals("Implemetation: Which techniques or issues arise in applying this pattern?" , system.getLeaf10().getTitle());
		assertEquals("Example resolved: Show how the previous example is resolved using the pattern?" , system.getLeaf11().getTitle());
		assertEquals("Variants: What are the impotant varations of this pattern?" , system.getLeaf12().getTitle());
		assertEquals("Known uses: What are some examples of real systems using this pattern?" , system.getLeaf13().getTitle());
		
		system.getLeaf4().setContents("DUMMY DATA");
		assertEquals("DUMMY DATA" , system.getLeaf4().getContents());
	}
}
