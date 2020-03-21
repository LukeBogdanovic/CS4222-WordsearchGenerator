package wordsearch;
import java.util.*;
import java.io.*;

public class WordSearchPuzzle {
	private char[][]puzzle;
	private List<String> puzzleWords;
	
	public WordSearchPuzzle(List<String> userSpecifiedWords) {
		List<String> words = new ArrayList<String>(userSpecifiedWords);
		puzzleWords = words;
		System.out.println(puzzleWords);
		generateWordSearchpuzzle();
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
		generateWordSearchpuzzle();
	}
	
	public List<String> getWordSearchList(){
		Collections.sort(puzzleWords);
		puzzleWords.stream().forEachOrdered(System.out::println);
		return puzzleWords;
	}
	
	public char[][] getPuzzleAsGrid(){
		for(int row = 0; row < puzzle.length;row++ ) {
			for(int col = 0; col < puzzle[0].length;col++) {
				System.out.print(puzzle[row][col] + " ");
			}
			System.out.println();
		}
		return puzzle;
	}
	
	public String getPuzzleAsString() {
		System.out.println(Arrays.deepToString(puzzle));
		return Arrays.deepToString(puzzle);
	}
	
	public void showWordSearchPuzzle(boolean hide) {
		
		if(hide == false) {
			getWordSearchList();
			for(int i = 0; i < puzzleWords.size();i++) {
				
			}
		}else {
			System.out.println(getWordSearchList());
		}
	}
	
	private void generateWordSearchpuzzle() {
		size();
		fill();
		fillUnused();
	}
	
	private void size() {
		int sum = 0;
		for(int i = 0; i < puzzleWords.size();i++) {
			int wordLength = puzzleWords.get(i).length();
			sum = sum + wordLength;
		}
		int characters = (int) (sum * 1.5);
		int length = (int) (Math.sqrt(characters)) + 1;
		puzzle = new char[length][length];
	}
	
	private void fillUnused() {
		String abc = "abcdefghijklmnopqrstuvwxyz";
		for(int row = 0; row < puzzle.length; row++) {
			for(int col = 0; col < puzzle[0].length; col++) {
				if(puzzle[row][col] == ' ') {
					int rand =(int)(Math.random()*abc.length());
					puzzle[row][col] = abc.charAt(rand);
				}
			}
		}
	}
	
	private void fill() {
		int rRow,rCol;
		String word;
		
		   rRow = (int)(Math.random()*puzzle.length);
		   rCol = (int)(Math.random()*puzzle[0].length);
		   word = puzzleWords.get(i); 
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
