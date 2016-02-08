import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;

public class Bob {
    private static Pattern alphaOnly= Pattern.compile("[a-zA-Z]+");

    private static Function<String, Boolean> isSilent = input ->
            input.length()<1;

    private static Function<String, Boolean> isShouting = input ->
            input.toUpperCase().equals(input) && alphaOnly.matcher(input).find();

    private static Function<String, Boolean> isQuestion = input ->
            !isSilent.apply(input) && input.charAt(input.length() - 1) == '?';

    private static Map<Function, String> tests = new LinkedHashMap<>();

    static {
        tests.put(isSilent, "Fine. Be that way!");
        tests.put(isShouting, "Whoa, chill out!");
        tests.put(isQuestion, "Sure.");
        tests.put(anyOtherInput -> true, "Whatever.");
    }

    public String hey(String input){
        final String parsedInput = (input != null ? input.trim() : "");
        return tests.get(
                tests.keySet()
                .stream()
                .filter(test -> (Boolean) test.apply(parsedInput))
                .findFirst()
                .get()
        );
    }
}
