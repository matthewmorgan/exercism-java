//import java.util.*;
//import java.util.stream.Collectors;
//
//public class Anagram {
//    String sortedLetters = "";
//
//    public Anagram(String word) {
//        sortedLetters = sortChars(word);
//    }
//
//    public List<String> match(List<String> possibles) {
//        return possibles.stream()
//                .filter(this::matches)
//                .collect(Collectors.toList());
//    }
//
//    private boolean matches(String possibleWord) {
//        return sortChars(possibleWord).equals(sortedLetters);
//    }
//
//    private String sortChars(String input){
//        String[] sorted=input.toLowerCase().split("");
//        Arrays.sort(sorted);
//        return Arrays.toString(sorted);
//    }
//}

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Anagram {

    private final String originalWord;
    private final String lowerCaseWord;

    public Anagram(String str) {
        originalWord  = str;
        lowerCaseWord = str.toLowerCase();
    }

    public List<String> match(List<String> strings) {
        return strings.stream()
                .filter( s -> isAnagram(s) )
                .collect(Collectors.toList());
    }

    public boolean isAnagram(String currentString) {
        String x = currentString.toLowerCase();
        String y = lowerCaseWord;

        return !x.equals(y) && frequencies(x).equals(frequencies(y));
    }

    private Map<Character, Long> frequencies(String str) {
        return str.chars().sorted().mapToObj( i -> (char) i )
                .collect(Collectors.groupingBy(c -> c,
                        Collectors.counting()));
    }

}