import java.util.stream.Stream;

public class Hexadecimal {
    private static final String HEXES = "0123456789abcdef";

    public static int toDecimal(String input) {
        Stream<String> hexStream = input.matches("^[0-9a-f]+")
                ? Stream.of(input.split("")) : Stream.of("0");
        return hexStream
                .map(HEXES::indexOf)
                .reduce(0, (decimal, hex) -> decimal * 16 + hex);

    }
}