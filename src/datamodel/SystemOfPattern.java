package datamodel;

public class SystemOfPattern extends PatternTest {
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
	PatternComponent container;

	public SystemOfPattern() {
		container = new PatternComposite(PATTERN_NAME_SYSTEM);
		leaf1 = new PatternPart(PART_TITLE_NAME, "ena");
		leaf2 = new PatternPart(PART_TITLE_TEMPLATE, "dio");
		leaf3 = new PatternPart(PART_TITLE_ALSO_KNOWN_AS, "tria");
		leaf4 = new PatternPart(PART_TITLE_EXAMPLE, "tessera");
		leaf5 = new PatternPart(PART_TITLE_CONTEXT, "pente");
		leaf6 = new PatternPart(PART_TITLE_PROBLEM, "exi");
		leaf7 = new PatternPart(PART_TITLE_SOLUTION, "efta");
		leaf8 = new PatternPart(PART_TITLE_STRUCTURE, "okto");
		leaf9 = new PatternPart(PART_TITLE_DYNAMIC, "enea");
		leaf10 = new PatternPart(PART_TITLE_IMPLEMETATION, "deka");
		leaf11 = new PatternPart(PART_TITLE_EXAMPLE_RESOLVED, "enteka");
		leaf12 = new PatternPart(PART_TITLE_VARIANTS, "dwdeka");
		leaf13 = new PatternPart(PART_TITLE_KNOWN_USES, "deka-tria");
		doAddCool();
	}

	public SystemOfPattern(SystemOfPattern systemOfPattern) {
		this.container = new PatternComposite(systemOfPattern.container.getTitle());
		this.leaf1 = new PatternPart(systemOfPattern.leaf1.getTitle(), systemOfPattern.leaf1.getContents());
		this.leaf2 = new PatternPart(systemOfPattern.leaf2.getTitle(), systemOfPattern.leaf2.getContents());
		this.leaf3 = new PatternPart(systemOfPattern.leaf3.getTitle(), systemOfPattern.leaf3.getContents());
		this.leaf4 = new PatternPart(systemOfPattern.leaf4.getTitle(), systemOfPattern.leaf4.getContents());
		this.leaf5 = new PatternPart(systemOfPattern.leaf5.getTitle(), systemOfPattern.leaf5.getContents());
		this.leaf6 = new PatternPart(systemOfPattern.leaf6.getTitle(), systemOfPattern.leaf6.getContents());
		this.leaf7 = new PatternPart(systemOfPattern.leaf7.getTitle(), systemOfPattern.leaf7.getContents());
		this.leaf8 = new PatternPart(systemOfPattern.leaf8.getTitle(), systemOfPattern.leaf8.getContents());
		this.leaf9 = new PatternPart(systemOfPattern.leaf9.getTitle(), systemOfPattern.leaf9.getContents());
		this.leaf10 = new PatternPart(systemOfPattern.leaf10.getTitle(), systemOfPattern.leaf10.getContents());
		this.leaf11 = new PatternPart(systemOfPattern.leaf11.getTitle(), systemOfPattern.leaf11.getContents());
		this.leaf12 = new PatternPart(systemOfPattern.leaf12.getTitle(), systemOfPattern.leaf12.getContents());
		this.leaf13 = new PatternPart(systemOfPattern.leaf13.getTitle(), systemOfPattern.leaf13.getContents());
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
	}

	@Override
	public PatternTest clone() {
		return new SystemOfPattern(this);
	}
}
