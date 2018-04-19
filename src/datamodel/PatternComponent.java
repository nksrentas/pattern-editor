package datamodel;

public abstract class PatternComponent {
	protected String name;
	public abstract void add(PatternComponent patternComponent);
	public abstract void remove(String patternComponentTitle);
	public abstract String getContents();
	public abstract void setContents(String contents);
	public abstract String getTitle();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
