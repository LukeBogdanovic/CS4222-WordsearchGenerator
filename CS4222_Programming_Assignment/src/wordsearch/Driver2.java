package wordsearch;
import java.util.*;

public class Driver2 {

	public static void main(String[] args) {
		List<String> words = new ArrayList<String>();
		words.add("cause");
		words.add("under");
		words.add("station");
		words.add("whenever");
		words.add("cause");
		words.add("checked");
		words.add("whatever");
		WordSearchPuzzle call = new WordSearchPuzzle(words);
		call.getPuzzleAsGrid();

	}

}
