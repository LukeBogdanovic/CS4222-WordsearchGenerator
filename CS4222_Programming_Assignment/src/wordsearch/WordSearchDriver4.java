package wordsearch;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class WordSearchDriver4 {
	private static char[][]puzzle;
	
    public static void main(String[] args){
        List<String> userSpecifiedWords = new ArrayList<String>(Arrays.asList("fox", "squirrel", "badger", "sloth", "aardvark"));
        WordSearchPuzzle instance = new WordSearchPuzzle(userSpecifiedWords);
        System.out.println(instance.getWordSearchList());
        System.out.println();
        puzzle = instance.getPuzzleAsGrid();
        getGrid(puzzle);
        System.out.println();
        System.out.println(instance.getPuzzleAsString());
        instance.showWordSearchPuzzle(true);
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
