package data.source;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import datamodel.PatternComposite;

public abstract class DataFile extends PatternComposite {
	protected PrintWriter printWriter;
	protected BufferedReader reader;
	
	public abstract void writeFile(String line);
	public abstract void readFile() throws IOException;
	
	public void initStream(String fileName, String fileType) {
		try {
			this.printWriter = new PrintWriter(fileName + "." + fileType);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void initReadStream(String fileName) {
			try {
				this.reader = new BufferedReader(new FileReader(
						fileName));
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
