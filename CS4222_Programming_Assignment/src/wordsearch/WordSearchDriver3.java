package wordsearch;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class WordSearchDriver3 {
	public static char[][] puzzle;
	
    public static void main(String[] args){
        List<String> userSpecifiedWords = new ArrayList<String>(Arrays.asList("english", "irish", "maths", "history", "geography", "french", "german", "biology", "chemistry", "physics"));
        WordSearchPuzzle instance = new WordSearchPuzzle(userSpecifiedWords);
        puzzle = instance.getPuzzleAsGrid();
        getGrid(puzzle);
        System.out.println(instance.getPuzzleAsString());
        System.out.println();
        System.out.println(instance.getWordSearchList());
        instance.showWordSearchPuzzle(false);
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
