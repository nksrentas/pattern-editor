package save.file;

public class DataTxt extends DataFile{

	public DataTxt() {
	}
	
	@Override
	public void writeFile(String line) {
		try {
			printWriter.println(line);
		} catch(Exception ex) {
	         ex.printStackTrace();
	    }
	}
}
