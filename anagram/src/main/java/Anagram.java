import java.util.*;
import java.util.stream.Collectors;

public class Anagram {
    String sortedLetters = "";

    public Anagram(String word) {
        sortedLetters = sortChars(word);
    }

    public List<String> match(List<String> possibles) {
        return possibles.stream()
                .filter(this::matches)
                .collect(Collectors.toList());
    }

    private boolean matches(String possibleWord) {
        return sortChars(possibleWord).equals(sortedLetters);
    }

    private String sortChars(String input){
        String[] sorted=input.toLowerCase().split("");
        Arrays.sort(sorted);
        return Arrays.toString(sorted);
    }
}
