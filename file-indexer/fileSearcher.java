import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class FileSearcher {
	public static BinarySearchTree<Word> BiTree = new BinarySearchTree<Word>();
	public static Scanner textreader, scan = new Scanner(System.in);
	public static ArrayList<String> files = new ArrayList<String>();
	public static String stop = "no";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		scanFiles(new File(args[0])); 
		
		boolean nowPlaying = true;
		
		while (nowPlaying) {
			System.out.println("Please enter a command (a, s, or q)>>");
			String response = scan.nextLine();
			if (response.equals("a")){
				BiTree.printTree(); 
			}
			if (response.equals("s")){
				System.out.println("Word to find>>");
				String wordToFind = scan.nextLine();
				Object result = searchWord(wordToFind);
				if (result != null) {
					System.out.println(result);
				}
				else
					System.out.println("this word does not exist");
			}
			if (response.equals("q")) {
				break;
			}
			}
	}
	
	public static void scanFiles(File folder) throws IOException {
		//get all files / subdirectories in folder
		File[] list = folder.listFiles();
		for(File file:list) {
			if(!file.isHidden() && file.getName().charAt(0)!= '.')
				if(file.isDirectory())
					scanFiles(file);
				else {
					String[] words = readFile(file); 
					textToBST(words, file);
				}		
		}
	}
	
	public static void textToBST(String[] texts, File file) {
		for (String text: texts) {
			//System.out.println(text);
			Word w = new Word(text);
			if(BiTree.contains(w)) {
				BiTree.find(w).addToFile(file.getName());
			}
			else {
				w.addToFile(file.getName());
				BiTree.insert(w);
			}
		}
	}
	
	public static String[] readFile(File file) throws IOException{
		Scanner fr = new Scanner(file);
		String words = " ";
		while (fr.hasNextLine()) {
			String line = fr.nextLine();
			words += line ;
		}
		String newWords = "";
		for (int i =0; i <words.length(); i++) { 
			if (Character.isLetter(words.charAt(i)) == true || Character.isDigit(words.charAt(i)) || words.charAt(i) == ' ' ) {
				String hold = Character.toString(words.charAt(i));
				newWords += hold;
			}
		}
		fr.close();
		return newWords.split(" ");
	}
	
	public static Object searchWord(String wordToFind) {
		Word w = new Word(wordToFind);
		if(BiTree.contains(w)) 
			return BiTree.find(w).toString();
		return null;
	}
}
