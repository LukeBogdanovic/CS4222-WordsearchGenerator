package wordsearch;
import java.util.*;
import java.io.*;

public class WordSearchPuzzle {
	private char[][]puzzle;
	private List<String> puzzleWords;
		
	public static void main(String args[]) {
		//WordSearchPuzzle call = new WordSearchPuzzle("C:\\Users\\godof\\Documents\\dictionary.txt", 8, 4, 10);
        //puzzleWords = 
		//System.out.println(puzzleWords);
		String words = "how who where what when why cause whatever";
	    List<String> usW = new ArrayList<String>(Arrays.asList(words));
		//System.out.println(usW);
		WordSearchPuzzle call = new WordSearchPuzzle(usW);
		//call.getPuzzleAsGrid();
	}
	
	public WordSearchPuzzle(List<String> userSpecifiedWords) {
		String[] str = userSpecifiedWords.toArray(new String[userSpecifiedWords.size()]);
		System.out.println(Arrays.deepToString(str));
		int i = 0;
		while(i < str.length) {
			puzzleWords.add(i,str[i]);
			i++;
		}
		
	}
	
	public WordSearchPuzzle(String wordFile, int wordCount, int shortest, int longest) {
		List<String> words = new ArrayList<String>(loadWordsFromFile(wordFile));
		
	}
	
	public List<String> getWordSearchList(){
		return puzzleWords;
	}
	
	public char[][] getPuzzleAsGrid(){
		char[][] grid = new char[puzzle.length][puzzle[0].length];
		for(int row = 0; row < puzzle.length;row++ ) {
			for(int col = 0; col < puzzle[0].length;col++) {
				grid[row][col] = puzzle[row][col];
			}
		}
		System.out.println(grid);
		return grid;
	}
	
	public String getPuzzleAsString() {
		return Arrays.deepToString(puzzle);
	}
	
	public void showWordSearchPuzzle(boolean hide) {
		
		if(hide == false) {
			getWordSearchList();
		}else {
			System.out.println(getWordSearchList());
			getWordSearchList();
		}
	}
	
	private void generateWordSearchpuzzle() {
		int rRow,rCol,rWord;
		String words = "how who where what when why cause whatever";
		ArrayList<String> uSW = new ArrayList<String>(Arrays.asList(words.split(" ")));
		String abc = "abcdefghijklmnopqrstuvwxyz";
		//if() {
			
		//}
		rWord = (int)(Math.random()* puzzleWords.size());
		rRow = (int)(Math.random()*puzzle.length);
		rCol = (int)(Math.random()*puzzle[0].length);
		for(int row = rRow;row < puzzleWords.size();row++) {
			for(int col = rCol;col < puzzleWords.size();col++) {
				//puzzle[row][col] = 
			}
		}
		for(int row = 0; row < puzzle.length; row++) {
			for(int col = 0; col < puzzle[0].length; col++) {
				if(puzzle[row][col] == ' ') {
					int r =(int)(Math.random()*abc.length());
					puzzle[row][col] = abc.charAt(r);
				}
			}
		}
			
	}
	
	private static ArrayList<String> loadWordsFromFile(String filename){
		try {
			FileReader aFileReader = new FileReader(filename);
			BufferedReader aBufferReader = new BufferedReader(aFileReader);
			ArrayList<String> words = new ArrayList<String>();
			String aWord;
			aWord = aBufferReader.readLine();
			while(aWord != null) {
				words.add(aWord.toUpperCase());
				aWord = aBufferReader.readLine();
			}
			aBufferReader.close();
			aFileReader.close();
			return words;
		}
		catch(IOException x) {
			return null;
		}
	}

}
