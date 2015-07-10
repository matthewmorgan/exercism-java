import java.util.Arrays;
import java.util.regex.Pattern;

public class Binary {
    Pattern re= Pattern.compile("[^01]+");
    int decimal=0;
    public Binary(String input){
        if (input == null | re.matcher(input).find()) { input = "0"; }
        parseDecimal(input.split(""));
    }

    public int getDecimal(){
        return decimal;
    }

    private void parseDecimal(String[] binary){
        Arrays.stream(binary).forEach((binaryDigit)->{
            decimal*=2;
            decimal+=Integer.parseInt(binaryDigit);
        });
    }
}
