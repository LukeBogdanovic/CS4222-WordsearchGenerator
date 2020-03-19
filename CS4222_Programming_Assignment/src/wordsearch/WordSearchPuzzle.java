package wordsearch;
import java.util.*;
import java.io.*;

public class WordSearchPuzzle {
	private char[][]puzzle;
	private List<String> puzzleWords;
	
	public WordSearchPuzzle(List<String> userSpecifiedWords) {
		
	}
	
	public WordSearchPuzzle(String wordFile, int wordCount, int shortest, int longest) {
		List<String> File = new ArrayList<String>(loadWordsFromFile(wordFile));
		List<String> words = new ArrayList<String>(wordCount);
		for(int i = 0; i < wordCount; i++) {
			Random r = new Random();
			int index = r.nextInt(File.size());
			if(File.get(i).length() >= shortest || File.get(i).length() <= longest ) {
				words.add(i, File.get(index));
			}else {
				i--;
			}
		}
		puzzleWords = words;
		System.out.println(puzzleWords);
	}
	
	public List<String> getWordSearchList(){
		return puzzleWords.get(i);
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
			for(int i = 0; i < puzzleWords.size();i++) {
				
			}
		}else {
			System.out.println(getWordSearchList());
			getWordSearchList();
		}
	}
	
	private void generateWordSearchpuzzle() {
		int rRow,rCol,rWord;
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
