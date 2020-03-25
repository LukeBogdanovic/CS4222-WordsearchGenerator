package wordsearch;
import java.util.*;
import java.io.*;

public class WordSearchPuzzle {
	private char[][]puzzle;
	private List<String> puzzleWords;
	private int[] direction;//storage for placement direction of words
	private int[] row;//storage for first row position of word
	private int[] col;//storage for first col position of word
	
	public WordSearchPuzzle(List<String> userSpecifiedWords) {
		List<String> words = new ArrayList<String>(userSpecifiedWords);
		puzzleWords = words;
		getWordSearchList();//must be gotten before generation so positions listed are correct
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
		getWordSearchList();//must be gotten before generation so positions listed are correct 
		generateWordSearchpuzzle();
	}
	
	public List<String> getWordSearchList(){
		puzzleWords.sort(Comparator.naturalOrder());//puzzleWords are listed alphabetically
		return puzzleWords;
	}
	
	public char[][] getPuzzleAsGrid(){
		for(int row = 0; row < puzzle.length;row++ ) {
			for(int col = 0; col < puzzle[0].length;col++) {
				puzzle[row][col] = puzzle[row][col];
				System.out.print(puzzle[row][col] + " ");
			}
			System.out.println();
		}
		return puzzle;
	}
	
	public String getPuzzleAsString() {
		return Arrays.deepToString(puzzle).replace("],", "]\n");
	}
	
	public void showWordSearchPuzzle(boolean hide) {
		if(hide == false) {
			for(int i = 0; i < direction.length;i++) {
				int placement = direction[i];
			    String word = puzzleWords.get(i);
			    switch(placement) {
			    case 1:
			    	System.out.println(word + "[" + row[i] + "]" +"[" + (col[i]) +"]" + "(R)");
			    	break;
			    case 2:
			    	System.out.println(word + "[" + row[i] + "]" +"[" + (col[i]) +"]" + "(L)" );
			    	break;
			    case 3:
			    	System.out.println(word + "[" + row[i] + "]" +"[" + (col[i]) +"]" + "(D)" );
			    	break;
			    case 4:
			    	System.out.println(word + "[" + row[i] + "]" +"[" + (col[i]) +"]" + "(U)" );
			    	break;
			    }
			}
		}else {
			for(int i = 0; i < puzzleWords.size();i++) {
				System.out.println(puzzleWords.get(i));
			}
		}
	}
	
	private void generateWordSearchpuzzle() {
		direction = new int[puzzleWords.size()];
		row = new int[puzzleWords.size()];
		col = new int[puzzleWords.size()];
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
		puzzle = new char[length][length];
	}
	
	private void fill() {
		int rCol,rRow2;//rCol = placement method for horizontal placement. rRow2 = placement method for vertical placement.
		int place = 0;
		for(int i = 0; i < puzzleWords.size();i++) {
		    int placement = (int)(Math.random()* 4) + 1;
		    direction[i] = placement;
		    String word = puzzleWords.get(i);
		    char[] chars = new char[word.length()];
		    int rRow = (int)(Math.random()*puzzle.length);
		    int rCol2 = (int)(Math.random()*puzzle.length);
		    word.getChars(0, word.length(), chars, 0);
		    switch(placement){
		    case 1: 		   
			   place = puzzle.length - word.length();
			   rCol = (int)(Math.random()*place);
			   row[i] = rRow;
			   col[i] = rCol;
			   for(int j = 0; j < chars.length;j++) {
				   puzzle[rRow][rCol] = chars[j];
				   rCol++;
			   }
			   break;
		    case 2:
			   place = word.length();			   
			   rCol = (int)(Math.random()*(puzzle.length - place) + place)-1;
			   row[i] = rRow;
			   col[i] = rCol;
			   for(int j = 0; j < chars.length;j++) {
				   puzzle[rRow][rCol] = chars[j];
				   rCol--;
			   }
			   break;
		    case 3:
		    	place = puzzle.length - word.length();
				rRow2 = (int)(Math.random()*place);
				row[i] = rRow2;
				col[i] = rCol2;
				for(int j = 0; j < chars.length;j++) {
					   puzzle[rRow2][rCol2] = chars[j];
					   rRow2++;
				}
			   break;
		    case 4: 
		    	place = word.length();			   
				rRow2 = (int)(Math.random()*(puzzle.length - place) + place)-1;
				row[i] = rRow2;
				col[i] = rCol2;
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
				if(puzzle[row][col] == '\0') {
					char letter = (char) rand.nextInt(26);
					char ch = abc.toUpperCase().charAt(letter);
					puzzle[row][col] = ch;
				}
				
			}
		}
		
	}
	//used code from load file example 
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
