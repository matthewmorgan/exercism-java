import java.util.Arrays;
import java.util.List;

public class Atbash {
    static List<String> key = Arrays.asList("zyxwvutsrqponmlkjihgfedcba".split(""));

    public static String encode(String input) {
        String[] plain = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().split("");
        StringBuilder result = new StringBuilder();
        for (int ii = 0; ii < plain.length; ii++) {
            String encoded = plain[ii].matches("[0-9]")
                    ? plain[ii]
                    : key.get(key.size()-1 - key.indexOf(plain[ii]));
            result.append(encoded);
            result.append((ii + 1) % 5 == 0 ? " " : "");
        }
        return result.toString().trim();
    }
}
