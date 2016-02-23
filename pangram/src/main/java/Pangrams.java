import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Pangrams {
    private static final int sizeOfAlphabet = 26;
    private static final String alphas = "[^a-zA-Z]";

    public final static boolean isPangram(String input) {
        return uniqueLettersFrom(input).size() == sizeOfAlphabet;
    }

    private final static Set uniqueLettersFrom(String input) {
        return Arrays.stream(input.replaceAll(alphas, "").toLowerCase().split(""))
                .collect(Collectors.toSet());
    }
}
