package datamodel;

public class Pattern extends PatternComposite{
	private static MicroPattern microPattern;
	private static InductiveMiniPattern inductiveMiniPattern;
	private static DeductiveMiniPattern deductiveMiniPattern;
	private static GangOfFourPattern gangOfFourPattern;
	private static SystemOfPattern systemOfPattern;

	public Pattern clone() {
		return null;
	}
	
	public void init() {
		/*PatternComponent leaf1 = new PatternPart("ena");
		PatternComponent leaf2 = new PatternPart("dio");
		PatternComponent leaf3 = new PatternPart("tria");
		PatternComponent leaf4 = new PatternPart("tessera");
		
		PatternComponent container = new PatternComposite("Micro");
		container.add(container);
		container.add(leaf1);
		container.add(leaf2);
		container.add(leaf3);
		container.add(leaf4);
		
		container.remove("ena");
		
		((PatternComposite) container).print();
		
		System.out.println("------------------------");
		PatternComponent leaf = new PatternPart("QQQQQQQQQQQQQQQQ");
		PatternComponent cont = new PatternComposite("MicroQQQQQQQQQQQ");
		cont.add(cont);
		cont.add(leaf);
		((PatternComposite) cont).print();
		
		
		System.out.println("------------GET CHILDREN------------");
		
		container.add(cont);

		ena = ((PatternComposite) cont).getChild();
		System.out.println(ena);*/
		
		PatternTestCache patternTestCache = new PatternTestCache();		// arxikopoihsi ton pattern template
		
		microPattern = (MicroPattern) patternTestCache.get("Micro");
		
		inductiveMiniPattern = (InductiveMiniPattern) patternTestCache.get("Inductive");
		//((PatternComposite) inductiveMiniPattern.container).print();
		
		deductiveMiniPattern = (DeductiveMiniPattern) patternTestCache.get("Deductive");
		//((PatternComposite) deductiveMiniPattern.container).print();
		
		gangOfFourPattern = (GangOfFourPattern) patternTestCache.get("Gang");
		//((PatternComposite) gangOfFourPattern.container).print();
		
		systemOfPattern = (SystemOfPattern) patternTestCache.get("System");
		//((PatternComposite) systemOfPattern.container).print();
		
		
	}
	
	public MicroPattern getMicroPattern() {
		return microPattern;
	}

	public InductiveMiniPattern getInductiveMiniPattern() {
		return inductiveMiniPattern;
	}

	public DeductiveMiniPattern getDeductiveMiniPattern() {
		return deductiveMiniPattern;
	}

	public GangOfFourPattern getGangOfFourPattern() {
		return gangOfFourPattern;
	}

	public SystemOfPattern getSystemOfPattern() {
		return systemOfPattern;
	}
}
