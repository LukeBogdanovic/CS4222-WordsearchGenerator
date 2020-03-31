public class WordSearchDriver2{
    public static void main(String[] args){
        WordSearchPuzzle instance1 = new WordSearchPuzzle("BasicEnglish.txt", 7, 3, 8);
        System.out.println(instance1.getWordSearchList());
        System.out.println();
        instance1.getPuzzleAsGrid();
        System.out.println(instance1.getPuzzleAsString());
        instance1.showWordSearchPuzzle(true);
        
        WordSearchPuzzle instance2 = new WordSearchPuzzle("BasicEnglish.txt", 5, 5, 6);
        System.out.println(instance2.getPuzzleAsString());
        System.out.println();
        instance2.getPuzzleAsGrid();
        instance2.showWordSearchPuzzle(false);
        System.out.println(instance2.getWordSearchList());
    }
}
