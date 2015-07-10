import java.util.Arrays;
import java.util.stream.Collectors;

public class RnaTranscription {

    private enum RNA {
        G("C"), C("G"), T("A"), A("U");

        public String y;
        RNA(String y) { this.y = y; }
        public static String get(String x) { return RNA.valueOf(x).y; }
    }

    public static String ofDna(String input) {
        return input.isEmpty()
                ? ""
                : Arrays.stream(input.split("")).parallel()
                    .map(el -> RNA.get(el))
                    .collect(Collectors.joining(""));
    }

}
