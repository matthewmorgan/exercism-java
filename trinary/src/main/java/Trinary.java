import java.util.Arrays;
import java.util.regex.Pattern;

public class Trinary {
    private static Pattern re = Pattern.compile("[^012]+");

    public static int toDecimal(String input) {
        if (input == null | re.matcher(input).find()) { input = "0"; }

        return Arrays.stream(input.split("")).
                map(trinaryDigit -> Integer.parseInt(trinaryDigit))
                .reduce(0, (decimal, trinaryDigit)->{
                    decimal*=3;
                    return decimal+=trinaryDigit;
                });
    }
}
