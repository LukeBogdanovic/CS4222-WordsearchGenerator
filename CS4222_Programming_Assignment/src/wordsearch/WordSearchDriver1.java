package wordsearch;

public class WordSearchDriver1{
	public static char[][] puzzle;
	
    public static void main(String[] args){
        WordSearchPuzzle instance1 = new WordSearchPuzzle("BNCwords.txt", 8, 4, 9);
        puzzle = instance1.getPuzzleAsGrid();
        getGrid(puzzle);
        System.out.println(instance1.getPuzzleAsString());
        instance1.showWordSearchPuzzle(false);
        System.out.println(instance1.getWordSearchList());
        System.out.println();
        
        WordSearchPuzzle instance2 = new WordSearchPuzzle("BNCwords.txt", 12, 3, 10);
        System.out.println(instance2.getWordSearchList());
        System.out.println();
        puzzle = instance2.getPuzzleAsGrid();
        getGrid(puzzle);
        instance2.showWordSearchPuzzle(true);
        System.out.println(instance2.getPuzzleAsString());
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