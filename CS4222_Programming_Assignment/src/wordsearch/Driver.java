package wordsearch;

public class Driver {
	public static char[][] puzzle;

	public static void main(String[] args) {
		WordSearchPuzzle call = new WordSearchPuzzle("BNCwords.txt", 8, 4, 15);
		call.getWordSearchList();
		puzzle = call.getPuzzleAsGrid();
		getGrid(puzzle);
		call.getPuzzleAsString();
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
/*words being allocated to space on wordsearch board is based heavily on the size of the board provided
If the amount of words asked for is increased the scaling factor must also be increased
This solves the problem of having an endless loop with the placement of the words
This decreases likelihood of an endless loop but does not eliminate it
The loop can be eliminated through decrease of the length of the words allowed
or through decrease of the amount of words allowed*/