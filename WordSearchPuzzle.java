package wordsearch;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class WordSearchPuzzle {
	private char[][]puzzle;
	private static List<String> puzzleWords;
	
	public static void main(String[]args) {
		WordSearchPuzzle call = new WordSearchPuzzle(puzzleWords);
		call.getPuzzleAsString();
		
		
	}
	
	

	public WordSearchPuzzle(List<String> userSpecifiedWords) {
		
	}
	
	public WordSearchPuzzle(String wordFile, int wordCount, int shortest, int longest) {
		
	}
	
	public List<String> getWordSearchList(){
		ArrayList<String> listOfWords = new  ArrayList<String>(Arrays.asList());
		return listOfWords;
	}
	
	public char[][] getPuzzleAsGrid(){
		//System.out.println(Arrays.deepToString(puzzle));
		//char[] puzzle2 = getPuzzleAsString().toCharArray();
		//int row = 0,col = 0;
		//for(int i = row; i < puzzle.length;i++ ) {
			//for(int j = col; j < puzzle[0].length;j++) {
				//puzzle = puzzle[row][col];
			//}
		//}
		return puzzle;
	}
	
	public String getPuzzleAsString() {
		return Arrays.deepToString(puzzle);
	}
	
	public void showWordSearchPuzzle(boolean hide) {
		
	}
	
	private void generateWordSearchpuzzle() {
	
	}

}
