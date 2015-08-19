import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class WordCount {
    final static Pattern onSpace = Pattern.compile("\\s");

    public final static Map<String, Integer> Phrase(String input) {
        final String cleaned = input.replaceAll("[^0-9A-Za-z\\s]", "").toLowerCase();

        return onSpace.splitAsStream(cleaned)
                .filter(word -> word.length() > 0)
                .collect(Collectors.groupingBy(word -> word, Collectors.summingInt(word -> 1)));
    }
}
