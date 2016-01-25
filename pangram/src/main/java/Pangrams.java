import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Pangrams {
    private static final int numberOfLettersInAlphabet = 26;

    public final static boolean isPangram(String input){
        return getUniqueLettersInSentence(input).size() == numberOfLettersInAlphabet;
    }

    private final static Set getUniqueLettersInSentence(String input){
        return Arrays.stream(input.replaceAll("[^a-zA-Z]","").toLowerCase().split(""))
                .collect(Collectors.toSet());
    }
}
