package datamodel;

import java.util.HashMap;

public class PatternTestCache {	
	public HashMap<String, PatternTest> cache = new HashMap<String, PatternTest>();
	
	public PatternTestCache() {
		MicroPattern microPattern = new MicroPattern();
		InductiveMiniPattern inductiveMiniPattern = new InductiveMiniPattern();
		DeductiveMiniPattern deductiveMiniPattern = new DeductiveMiniPattern();
		GangOfFourPattern gangOfFourPattern = new GangOfFourPattern();
		SystemOfPattern systemOfPattern = new SystemOfPattern();
		
		put("Micro", microPattern);
		put("Inductive", inductiveMiniPattern);
		put("Deductive", deductiveMiniPattern);
		put("Gang", gangOfFourPattern);
		put("System", systemOfPattern);
	}

    public PatternTest put(String key, PatternTest patternTest) {
        cache.put(key, patternTest);
        return patternTest;
    }

    public PatternTest get(String key) {
        return cache.get(key).clone();
    }
}
