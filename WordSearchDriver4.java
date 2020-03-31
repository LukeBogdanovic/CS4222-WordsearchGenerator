import java.util.*;
import java.io.*;

public class WordSearchDriver4 {
    public static void main(String[] args){
        List<String> userSpecifiedWords = new ArrayList<String>(Arrays.asList("fox", "squirrel", "badger", "sloth", "aardvark"));
        WordSearchPuzzle instance = new WordSearchPuzzle(userSpecifiedWords);
        System.out.println(instance.getWordSearchList());
        System.out.println();
        instance.getPuzzleAsGrid();
        System.out.println(instance.getPuzzleAsString());
        instance.showWordSearchPuzzle(true);
    }
}
