package datamodel;

public class PatternPart extends PatternComponent{
	private String title;
	private String contents;

	public PatternPart(String title, String contents) {
		this.title = title;
		this.contents = contents;
	}

	public String getContents() {
		return contents;
	}

	@Override
	public void setContents(String contents) {
		System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE" + contents);
		this.contents = contents;
		System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE" + this.contents);
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void add(PatternComponent patternComponent) {
		// this is leaf node so this method is not applicable to this class.
	}

	@Override
	public void remove(String patternComponentTitle) {
		// this is leaf node so this method is not applicable to this class.
	}
	
	@Override
	public String toString() {
		return "PatternPart [title=" + title + ", contents=" + contents + "]";
	}
}
