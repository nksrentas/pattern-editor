package save.file;

public class DataLatextSyntax extends DataDecorator{
	private static final String LATEX_TYPE = "\\document{article}";
	private static final String LATEX_OPEN_TAG_BEGIN = "\\begin{document}";
	private static final String LATEX_CLOSE_TAG_BEGIN = "\\end{document}";
	private static final String LATEX_MAKE_TITLE_TAG = "\\maketitle";
	private static final String LATEX_TITLE_TAG = "\\title";
	private static final String LATEX_SECTION_TAG = "\\section";
	private static final String LATEX_SUBSECTION_TAG = "\\subsection";
	private static final String LATEX_OPEN_CURLY_BRACKET = "{";
	private static final String LATEX_CLOSE_CURLY_BRACKET = "}";
	private int contextLine = 1;
	private DataFile dataFile;
	
	public DataLatextSyntax(DataFile dataFile) {
		this.dataFile = dataFile;
		createStubLatexCode();
	}

	@Override
	public void writeFile(String line) {
		if (contextLine % 2 != 0) {
			dataFile.writeFile(LATEX_SUBSECTION_TAG + LATEX_OPEN_CURLY_BRACKET + line + LATEX_CLOSE_CURLY_BRACKET);
		} else {
			dataFile.writeFile(line);
		}
		contextLine++;
	}

	@Override
	public void closeFile() {
		dataFile.writeFile(LATEX_CLOSE_TAG_BEGIN);
		dataFile.printWriter.close();
	}
	
	private void createStubLatexCode() {
		dataFile.writeFile(LATEX_TYPE);
		dataFile.writeFile(LATEX_OPEN_TAG_BEGIN);
		dataFile.writeFile(LATEX_TITLE_TAG + LATEX_OPEN_CURLY_BRACKET + "temp name" + LATEX_CLOSE_CURLY_BRACKET);
		dataFile.writeFile(LATEX_MAKE_TITLE_TAG);	
	}
	
	public void writeSectionStart() {
		dataFile.writeFile(LATEX_SECTION_TAG + LATEX_OPEN_CURLY_BRACKET + "TEMP PATTERN LANGUAGE" + LATEX_CLOSE_CURLY_BRACKET);
	}
}
