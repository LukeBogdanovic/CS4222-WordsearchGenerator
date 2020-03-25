package wordsearch;

public class Driver {

	public static void main(String[] args) {
		WordSearchPuzzle call = new WordSearchPuzzle("BNCwords.txt", 8, 4, 10);
		call.getWordSearchList();
		call.getPuzzleAsGrid();
		call.getPuzzleAsString();
		call.showWordSearchPuzzle(false);
	}
	
}
