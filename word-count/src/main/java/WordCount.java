import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public final class WordCount {
    private final static Pattern onSpace = Pattern.compile("\\s+");
    private final static String nonAlpha = "[^0-9A-Za-z\\s]";

    public final static Map<String, Integer> phrase(String input) {
        return onSpace
                .splitAsStream(cleaned(input))
                .collect(toMapOfCountsByWord);
    }

    private static final String cleaned(String input) {
        return input.replaceAll(nonAlpha, "").toLowerCase();
    }

    private static final Collector<String, ?, Map<String, Integer>> toMapOfCountsByWord =
            Collectors.groupingBy(String::new, Collectors.mapping(Function.identity(), Collectors.summingInt(word -> 1)));
}
