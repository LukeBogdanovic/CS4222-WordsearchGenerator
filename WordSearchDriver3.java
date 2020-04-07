import java.util.*;
import java.io.*;

public class WordSearchDriver3 {
    public static void main(String[] args){
        List<String> userSpecifiedWords = new ArrayList<String>(Arrays.asList("english", "irish", "maths", "history", "geography", "french", "german", "biology", "chemistry", "physics"));
        WordSearchPuzzle instance = new WordSearchPuzzle(userSpecifiedWords);
        instance.getPuzzleAsGrid();
        System.out.println(instance.getPuzzleAsString());
        System.out.println();
        System.out.println(instance.getWordSearchList());
        instance.showWordSearchPuzzle(false);
    }
}
