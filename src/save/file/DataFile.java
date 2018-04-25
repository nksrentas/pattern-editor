package save.file;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import datamodel.PatternComposite;

public abstract class DataFile extends PatternComposite {
	protected PrintWriter printWriter;
	
	public abstract void writeFile(String line);
	
	public void initStream() {
		try {
			this.printWriter = new PrintWriter("printedFile.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public PrintWriter getPrintWriter() {
		return printWriter;
	}

	public void setPrintWriter(PrintWriter printWriter) {
		this.printWriter = printWriter;
	}
}
