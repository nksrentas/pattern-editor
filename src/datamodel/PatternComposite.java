package datamodel;

import java.util.ArrayList;
import java.util.Iterator;

public class PatternComposite extends PatternComponent {
	private String nameOfPatternTemplate;
	protected ArrayList<PatternComponent> components = new ArrayList<PatternComponent>();
	
	public PatternComposite() {}
	
	public PatternComposite(String nameOfPatternTemplate) {
		this.nameOfPatternTemplate = nameOfPatternTemplate;
	}

	public void saveContents() {
		// TODO phase 2
	}

	public void add(PatternComponent patternComponent) {
		components.add(patternComponent);
	}

	public void remove(String patternComponentTitle) {
		for(int i = 0; i < components.size(); i++) {
			if (components.get(i).getContents().equals(patternComponentTitle)) {
				components.remove(i);
			}
		}
	}
	
	public ArrayList<PatternComponent> getChild() {
		return components;
	}
	
	@Override
	public String getTitle() {
		return nameOfPatternTemplate;
	}
	
	@Override
	public String toString() {
		return "PatternComposite [nameOfPatternTemplate=" + nameOfPatternTemplate + "]";
	}

	@Override
	public String getContents() {
		return nameOfPatternTemplate;
	}
	
	public void print() {
		for(int i = 0; i < components.size(); i++) {
			System.out.println(components.get(i).getTitle());
			System.out.println(components.get(i).getContents());
		}
	}

	@Override
	public void setContents(String contents) {
	}
}
