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