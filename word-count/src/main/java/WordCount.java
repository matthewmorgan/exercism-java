import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class WordCount {
    private final static Pattern onSpace = Pattern.compile("\\s");
    private final static String nonAlpha = "[^0-9A-Za-z\\s]";

    public final static Map<String, Integer> phrase(String input) {
        return onSpace.splitAsStream(input.replaceAll(nonAlpha, "").toLowerCase())
//                .filter(word -> word.length() > 0)
                .collect(Collectors.groupingBy(word -> word, Collectors.summingInt(word -> 1)));
    }
}