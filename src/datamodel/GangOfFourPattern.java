package datamodel;

public class GangOfFourPattern extends PatternTest {
	PatternComponent leaf1;
	PatternComponent leaf2;
	PatternComponent leaf3;
	PatternComponent leaf4;
	PatternComponent leaf5;
	PatternComponent leaf6;
	PatternComponent leaf7;
	PatternComponent leaf8;
	PatternComponent leaf9;
	PatternComponent leaf10;
	PatternComponent leaf11;
	PatternComponent leaf12;
	PatternComponent leaf13;
	PatternComponent leaf14;
	PatternComponent leaf15;
	PatternComponent container;

	public GangOfFourPattern() {
		container = new PatternComposite(PATTERN_NAME_GANG_OF_FOUR);
		leaf1 = new PatternPart(PART_TITLE_NAME, "ena");
		leaf2 = new PatternPart(PART_TITLE_TEMPLATE, "dio");
		leaf3 = new PatternPart(PART_TITLE_PATTERN_CLASSIFICATION, "tria");
		leaf4 = new PatternPart(PART_TITLE_INTENT, "tessera");
		leaf5 = new PatternPart(PART_TITLE_ALSO_KNOWN_AS, "pente");
		leaf6 = new PatternPart(PART_TITLE_MOTIVATION, "exi");
		leaf7 = new PatternPart(PART_TITLE_APPLICABILITY, "efta");
		leaf8 = new PatternPart(PART_TITLE_STRUCTURE, "okto");
		leaf9 = new PatternPart(PART_TITLE_PARTICIPANTS, "enea");
		leaf10 = new PatternPart(PART_TITLE_COLLABORATIONS, "deka");
		leaf11 = new PatternPart(PART_TITLE_CONSEQUENCES, "enteka");
		leaf12 = new PatternPart(PART_TITLE_IMPLEMETATION, "dwdeka");
		leaf13 = new PatternPart(PART_TITLE_SAMPLE_CODE, "deka-tria");
		leaf14 = new PatternPart(PART_TITLE_KNOWN_USES, "deka-tessera");
		leaf15 = new PatternPart(PART_TITLE_RELATED_PATTERNS, "deka-pente");
		doAddCool();
	}

	public GangOfFourPattern(GangOfFourPattern gangOfFourPattern) {
		this.container = new PatternComposite(gangOfFourPattern.container.getTitle());
		this.leaf1 = new PatternPart(gangOfFourPattern.leaf1.getTitle(), gangOfFourPattern.leaf1.getContents());
		this.leaf2 = new PatternPart(gangOfFourPattern.leaf2.getTitle(), gangOfFourPattern.leaf2.getContents());
		this.leaf3 = new PatternPart(gangOfFourPattern.leaf3.getTitle(), gangOfFourPattern.leaf3.getContents());
		this.leaf4 = new PatternPart(gangOfFourPattern.leaf4.getTitle(), gangOfFourPattern.leaf4.getContents());
		this.leaf5 = new PatternPart(gangOfFourPattern.leaf5.getTitle(), gangOfFourPattern.leaf5.getContents());
		this.leaf6 = new PatternPart(gangOfFourPattern.leaf6.getTitle(), gangOfFourPattern.leaf6.getContents());
		this.leaf7 = new PatternPart(gangOfFourPattern.leaf7.getTitle(), gangOfFourPattern.leaf7.getContents());
		this.leaf8 = new PatternPart(gangOfFourPattern.leaf8.getTitle(), gangOfFourPattern.leaf8.getContents());
		this.leaf9 = new PatternPart(gangOfFourPattern.leaf9.getTitle(), gangOfFourPattern.leaf9.getContents());
		this.leaf10 = new PatternPart(gangOfFourPattern.leaf10.getTitle(), gangOfFourPattern.leaf10.getContents());
		this.leaf11 = new PatternPart(gangOfFourPattern.leaf11.getTitle(), gangOfFourPattern.leaf11.getContents());
		this.leaf12 = new PatternPart(gangOfFourPattern.leaf12.getTitle(), gangOfFourPattern.leaf12.getContents());
		this.leaf13 = new PatternPart(gangOfFourPattern.leaf13.getTitle(), gangOfFourPattern.leaf13.getContents());
		this.leaf14 = new PatternPart(gangOfFourPattern.leaf14.getTitle(), gangOfFourPattern.leaf14.getContents());
		this.leaf15 = new PatternPart(gangOfFourPattern.leaf15.getTitle(), gangOfFourPattern.leaf15.getContents());
		doAddCool();
	}

	public void doAddCool() {
		container.add(container);
		container.add(leaf1);
		container.add(leaf2);
		container.add(leaf3);
		container.add(leaf4);
		container.add(leaf5);
		container.add(leaf6);
		container.add(leaf7);
		container.add(leaf8);
		container.add(leaf9);
		container.add(leaf10);
		container.add(leaf11);
		container.add(leaf12);
		container.add(leaf13);
		container.add(leaf14);
		container.add(leaf15);
	}

	@Override
	public PatternTest clone() {
		return new GangOfFourPattern(this);
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

	public PatternComponent getLeaf6() {
		return leaf6;
	}

	public PatternComponent getLeaf7() {
		return leaf7;
	}

	public PatternComponent getLeaf8() {
		return leaf8;
	}

	public PatternComponent getLeaf9() {
		return leaf9;
	}

	public PatternComponent getLeaf10() {
		return leaf10;
	}

	public PatternComponent getLeaf11() {
		return leaf11;
	}

	public PatternComponent getLeaf12() {
		return leaf12;
	}

	public PatternComponent getLeaf13() {
		return leaf13;
	}

	public PatternComponent getLeaf14() {
		return leaf14;
	}

	public PatternComponent getLeaf15() {
		return leaf15;
	}

	public PatternComponent getContainer() {
		return container;
	}
	
	
}
