package wordsearch;

public class WordSearchDriver2{
	public static char[][] puzzle;
	
    public static void main(String[] args){
        WordSearchPuzzle instance1 = new WordSearchPuzzle("BasicEnglish.txt", 7, 3, 8);
        System.out.println(instance1.getWordSearchList());
        System.out.println();
        puzzle = instance1.getPuzzleAsGrid();
        getGrid(puzzle);
        System.out.println(instance1.getPuzzleAsString());
        instance1.showWordSearchPuzzle(true);
        
        WordSearchPuzzle instance2 = new WordSearchPuzzle("BasicEnglish.txt", 5, 5, 6);
        System.out.println(instance2.getPuzzleAsString());
        System.out.println();
        puzzle = instance2.getPuzzleAsGrid();
        getGrid(puzzle);
        instance2.showWordSearchPuzzle(false);
        System.out.println(instance2.getWordSearchList());
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