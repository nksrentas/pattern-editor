package data.source;

import java.io.IOException;

public class DataAddTabs extends DataDecorator{
	private DataFile dataFile;
	private int numberOfLines = 1;

	public DataAddTabs(DataFile dataFile) {
		this.dataFile = dataFile;
	}

	@Override
	public void writeFile(String line) {
		if (numberOfLines % 2 == 0) {
			dataFile.writeFile("\t" + line);
		} else {
			dataFile.writeFile(line);
		}
		numberOfLines++;
	}
	
	@Override
	public void closeFile() {
		dataFile.printWriter.close();
	}
	
	public void saveName(String patternName) {
		dataFile.writeFile(patternName);
	}

	@Override
	public void readFile() throws IOException {
	
	}
}
