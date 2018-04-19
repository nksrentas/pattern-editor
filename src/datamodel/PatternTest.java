package datamodel;

public abstract class PatternTest extends PatternComposite {
	protected static final String PATTERN_NAME_MICRO = "Micro-Pattern Template";
	protected static final String PATTERN_NAME_INDUCTIVE = "Inductive Mini-Pattern";
	protected static final String PATTERN_NAME_DEDUCTIVE = "Deductive Mini-Pattern";
	protected static final String PATTERN_NAME_GANG_OF_FOUR = "Gang-of-Four Pattern";
	protected static final String PATTERN_NAME_SYSTEM = "System of Patterns Template";
	protected final static String PART_TITLE_NAME = "Name: What shall this pattern be called by practitioners?";
	protected final static String PART_TITLE_TEMPLATE = "Template: Which template is followed for the pattern specification?";
	protected static final String PART_TITLE_PROBLEM = "Problem: What is motivation us to apply this pattern?";
	protected static final String PART_TITLE_SOLUTION = "Solution: How do we solve the problem?";
	protected static final String PART_TITLE_CONTEXT = "Context: what are the assume enviroment or priori assumption "
			+ "for applying this pattern?";
	protected static final String PART_TITLE_FORCES = "Forces: What are the different design motivations that must be balance?";
	protected static final String PART_TITLE_BENEFIT = "Benefit: What are the potential positive outcomes of applying this pattern?";
	protected static final String PART_TITLE_CONSEQUENCES = "Consequences: What are the pontential shortcomings and consequences of appyling this pattern?";
	protected static final String PART_TITLE_PATTERN_CLASSIFICATION = "Pattern Classification: Is the pattern creational, structual, or behavioral?";
	protected static final String PART_TITLE_INTENT = "Intent: What problem does this pattern solve?";
	protected static final String PART_TITLE_ALSO_KNOWN_AS = "Also know as: What are other name for this pattern?";
	protected static final String PART_TITLE_MOTIVATION = "Motivation: What is an example scenario for applying this pattern?";
	protected static final String PART_TITLE_APPLICABILITY = "Applicability: When does this pattern apply?";
	protected static final String PART_TITLE_STRUCTURE = "Structure: Which are the classes of the objects in this pattern?";
	protected static final String PART_TITLE_PARTICIPANTS = "Participants: What are the objects that participate in this pattern?";
	protected static final String PART_TITLE_COLLABORATIONS = "Collaborations: How do these objects interoperate?";
	protected static final String PART_TITLE_IMPLEMETATION = "Implemetation: Which techniques or issues arise in applying this pattern?";
	protected static final String PART_TITLE_SAMPLE_CODE = "Sample code: What are some examples of real ssytems using this pattern?";
	protected static final String PART_TITLE_KNOWN_USES = "Known uses: What are some examples of real systems using this pattern?";
	protected static final String PART_TITLE_RELATED_PATTERNS = "Related patterns: What other patterns from this pattern collection are related to this pattern?";
	protected static final String PART_TITLE_EXAMPLE = "Example: What is a example of the need for this pattern?";
	protected static final String PART_TITLE_DYNAMIC = "Dynamic: How do these objects collaborate?";
	protected static final String PART_TITLE_EXAMPLE_RESOLVED = "Example resolved: Show how the previous example is resolved using the pattern?";
	protected static final String PART_TITLE_VARIANTS = "Variants: What are the impotant varations of this pattern?";
	
	public abstract PatternTest clone();
}
