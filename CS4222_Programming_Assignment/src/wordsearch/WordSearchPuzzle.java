package wordsearch;
import java.util.*;
import java.io.*;

public class WordSearchPuzzle {
	private char[][]puzzle;
	private List<String> puzzleWords;
	
	public static void main(String[] args) {
		
	}
	
	public WordSearchPuzzle(List<String> userSpecifiedWords) {
		List<String> words = new ArrayList<String>(userSpecifiedWords);
		puzzleWords = words;
		generateWordSearchpuzzle();/*private method generating/placing words on wordsearch grid as well as placing char in unused spaces
		calculates size of grid needed*/
	}
	
	public WordSearchPuzzle(String wordFile, int wordCount, int shortest, int longest) {
		List<String> File = new ArrayList<String>(loadWordsFromFile(wordFile));
		List<String> words = new ArrayList<String>(wordCount);
		for(int i = 0; i < wordCount; i++) {
			Random r = new Random();
			int index = r.nextInt(File.size());
			if(File.get(index).length() >= shortest && File.get(index).length() <= longest ) {
				words.add(i, File.get(index));
			}else {
				i--;
			}
		}
		puzzleWords = words;
		generateWordSearchpuzzle();
	}
	
	public List<String> getWordSearchList(){
		//List<String> sortedList = Collections.sort(puzzleWords);
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
		size();//calculates size of grid needed
		fill();//fills selected words onto grid at random
		fillUnused();//fills unused spaces with random chars from alphabet
	}
	
	private void size() {
		int sum = 0;
		for(int i = 0; i < puzzleWords.size();i++) {
			int wordLength = puzzleWords.get(i).length();
			sum = sum + wordLength;
		}
		int characters = (int) (sum * 1.75);
		int length = (int) (Math.sqrt(characters)) + 1;
		System.out.println(length);
		puzzle = new char[length][length];
	}
	
	private void fill() {
		Random rand = new Random();
		int rCol,rRow2;
		int place = 0;
		for(int i = 0; i < puzzleWords.size();i++) {
		    int placement = rand.nextInt(5); 
		    String word = puzzleWords.get(i);
		    char[] chars = new char[word.length()];
		    int rRow = (int)(Math.random()*puzzle.length);
		    int rCol2 = (int)(Math.random()*puzzle.length);
		    word.getChars(0, word.length(), chars, 0);
		    switch(placement){
		    case 1: 		   
			   place = puzzle.length - word.length();
			   rCol = (int)(Math.random()*place);
			   for(int j = 0; j < chars.length;j++) {
				   puzzle[rRow][rCol] = chars[j];
				   rCol++;
			   }
			   break;
		    case 2:
			   place = word.length();			   
			   rCol = (int)(Math.random()*(puzzle.length - place) + place)-1;
			   for(int j = 0; j < chars.length;j++) {
				   puzzle[rRow][rCol] = chars[j];
				   rCol--;
			   }
			   break;
		    case 3:
		    	place = puzzle.length - word.length();
				rRow2 = (int)(Math.random()*place);				   
				   for(int j = 0; j < chars.length;j++) {
					   puzzle[rRow2][rCol2] = chars[j];
					   rRow2++;
				   }
			   break;
		    case 4: 
		    	place = word.length();			   
				rRow2 = (int)(Math.random()*(puzzle.length - place) + place)-1;
				for(int j = 0; j < chars.length;j++) {
					puzzle[rRow2][rCol2] = chars[j];
					rRow2--;
				}
		       break;
		   }
	   }
    }	
	
	private void fillUnused() {
		Random rand = new Random();
		String abc = "abcdefghijklmnopqrstuvwxyz";
		for(int row = 0; row < puzzle.length; row++) {
			for(int col = 0; col < puzzle[0].length; col++) {
				if(puzzle[row][col] == ' ') {
					char letter = (char) rand.nextInt(26);
					System.out.println(rand);
					char ch = abc.toUpperCase().charAt(letter);
					puzzle[row][col] = ch;
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



    public boolean exists(int row, int col) {
	    return (row >= 0 && row < puzzle.length) && (col >= 0 && col < puzzle[0].length);
	}
}
