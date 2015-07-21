import java.util.Arrays;
import java.util.regex.Pattern;

public class Octal {
    private static Pattern re = Pattern.compile("[^01234567]+");
    private static String input;

    public Octal (String input){
        this.input=input;
    }

    public static int getDecimal() {
        if (input == null | re.matcher(input).find()) { input = "0"; }
        return Arrays.stream(input.split("")).
                map(octalDigit -> Integer.parseInt(octalDigit))
                .reduce(0, (decimal, octalDigit) -> {
                    decimal *= 8;
                    return decimal += octalDigit;
                });
    }
}
