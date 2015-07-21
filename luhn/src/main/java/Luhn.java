import java.util.Arrays;
import java.util.stream.IntStream;

public class Luhn {

    private static String[] digits;

    public Luhn(Integer accountNumber) {
        this.digits = new StringBuilder(accountNumber.toString()).reverse().toString().split("");
    }

    public Luhn(String accountNumber) {
        this.digits = new StringBuilder(accountNumber).reverse().toString().split("");
    }

    public static int[] getAddends() {
        return IntStream.rangeClosed(1, digits.length)
                .map(ii -> {
                    int index=digits.length-ii;
                    int digit = new Integer(digits[index])*2;
                    return index % 2 != 0 ?
                            digit> 9 ? digit - 9 : digit
                            : digit/2;
                }).toArray();
    }

    public int getCheckDigit() {
        return new Integer(digits[0]);
    }

    public static int getCheckSum() {
        return Arrays.stream(getAddends()).sum();
    }

    public Boolean isValid() {
        return getCheckSum() % 10 == 0;
    }

    public static long create(Integer input) {
        Integer checkDigit = 0;
        Luhn luhn = new Luhn(input.toString() + checkDigit.toString());
        while (!luhn.isValid()) {
            checkDigit++;
            luhn = new Luhn(input.toString() + checkDigit.toString());
        }
        return Long.parseLong(input.toString() + checkDigit.toString());
    }
}
