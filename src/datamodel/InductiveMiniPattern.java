package datamodel;

public class InductiveMiniPattern extends PatternTest {
	PatternComponent leaf1;
	PatternComponent leaf2;
	PatternComponent leaf3;
	PatternComponent leaf4;
	PatternComponent leaf5;
	PatternComponent container;

	public InductiveMiniPattern() {
		container = new PatternComposite(PATTERN_NAME_INDUCTIVE);
		leaf1 = new PatternPart(PART_TITLE_NAME, "ena");
		leaf2 = new PatternPart(PART_TITLE_TEMPLATE, "dio");
		leaf3 = new PatternPart(PART_TITLE_CONTEXT, "tria");
		leaf4 = new PatternPart(PART_TITLE_FORCES, "tessera");
		leaf5 = new PatternPart(PART_TITLE_SOLUTION, "pente");
		doAddCool();
	}

	public InductiveMiniPattern(InductiveMiniPattern inductiveMiniPattern) {
		this.container = new PatternComposite(inductiveMiniPattern.container.getTitle());
		this.leaf1 = new PatternPart(inductiveMiniPattern.leaf1.getTitle(), inductiveMiniPattern.leaf1.getContents());
		this.leaf2 = new PatternPart(inductiveMiniPattern.leaf2.getTitle(), inductiveMiniPattern.leaf2.getContents());
		this.leaf3 = new PatternPart(inductiveMiniPattern.leaf3.getTitle(), inductiveMiniPattern.leaf3.getContents());
		this.leaf4 = new PatternPart(inductiveMiniPattern.leaf4.getTitle(), inductiveMiniPattern.leaf4.getContents());
		this.leaf5 = new PatternPart(inductiveMiniPattern.leaf5.getTitle(), inductiveMiniPattern.leaf5.getContents());
		doAddCool();
	}

	public void doAddCool() {
		container.add(container);
		container.add(leaf1);
		container.add(leaf2);
		container.add(leaf3);
		container.add(leaf4);
		container.add(leaf5);
	}

	@Override
	public PatternTest clone() {
		return new InductiveMiniPattern(this);
	}

	public PatternComponent getLeaf1() {
		return leaf1;
	}

	public PatternComponent getLeaf2() {
		return leaf2;
	}

	public PatternComponent getLeaf3() {
		return leaf3;
	}

	public PatternComponent getLeaf4() {
		return leaf4;
	}

	public PatternComponent getLeaf5() {
		return leaf5;
	}

	public PatternComponent getContainer() {
		return container;
	}
}
