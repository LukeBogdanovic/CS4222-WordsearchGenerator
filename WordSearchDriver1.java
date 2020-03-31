public class WordSearchDriver1{
    public static void main(String[] args){
        WordSearchPuzzle instance1 = new WordSearchPuzzle("BNCwords.txt", 8, 4, 9);
        instance1.getPuzzleAsGrid();
        System.out.println(instance1.getPuzzleAsString());
        instance1.showWordSearchPuzzle(false);
        System.out.println(instance1.getWordSearchList());
        System.out.println();
        
        WordSearchPuzzle instance2 = new WordSearchPuzzle("BNCwords.txt", 12, 3, 10);
        System.out.println(instance2.getWordSearchList());
        System.out.println();
        instance2.getPuzzleAsGrid();
        instance2.showWordSearchPuzzle(true);
        System.out.println(instance2.getPuzzleAsString());
    }
}