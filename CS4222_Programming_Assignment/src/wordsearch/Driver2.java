package wordsearch;
import java.util.*;

public class Driver2 {
	public static char[][] puzzle;

	public static void main(String[] args) {
		List<String> words = new ArrayList<String>();
		words.add("cause".toUpperCase());
		words.add("under".toUpperCase());
		words.add("station".toUpperCase());
		words.add("whenever".toUpperCase());
		words.add("nope".toUpperCase());
		words.add("checked".toUpperCase());
		words.add("whatever".toUpperCase());
		WordSearchPuzzle call = new WordSearchPuzzle(words);
		puzzle = call.getPuzzleAsGrid();
		getGrid(puzzle);
		call.getPuzzleAsGrid();
		call.showWordSearchPuzzle(false);

	}
	
	private static void getGrid(char[][] Grid) {
		for(int i = 0; i < puzzle.length; i++) {
			for(int j = 0; j < puzzle[0].length;j++) {
				System.out.print(puzzle[i][j] + " ");
		    }
		System.out.println();
		}
	}

}
