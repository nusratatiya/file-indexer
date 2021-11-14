import java.util.ArrayList;

public class Word implements Comparable<Word>{
	private String word; // key for compareTo
	ArrayList<String> fileList = new ArrayList<String>(); // list of filenames containing this word
	
	public Word() {} //empty constructor
	
	
	public Word(String word) {
		this.word = word;
	}

	public void addToFile(String f) {
		fileList.add(f);
	}
	
	public String toString() {
		return ("files containing " + this.word + ": " + fileListString()); //fileListToString method
		
	}
	
	public int compareTo(Word other) {
		return other.word.compareTo(this.word);
	}
	
	public String fileListString() {
		String flString = " ";
		for(int i =0; i < fileList.size(); i++) {
			flString += fileList.get(i) + " ";
		}
		
		return flString;
	}
	//getters and setters
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	public ArrayList<String> getFileList() {
		return fileList;
	}

	public void setFileList(ArrayList<String> fileList) {
		this.fileList = fileList;
	}

}
