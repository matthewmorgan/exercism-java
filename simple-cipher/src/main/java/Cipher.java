import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.*;

public class Cipher {

    private static final int START =97;
    private static final int END =122;
    private static final int ALPHABET_LEN=26;
    private String[] key;
    private Pattern re= Pattern.compile("[^a-z]+");

    public Cipher(){
        this.key=generateKey();
    }

    public Cipher(String key) {
        if (key.length()==0 || re.matcher(key).find()) throw new IllegalArgumentException();
        this.key=key.split("");
    }

    private String[] generateKey(){
        return IntStream.range(0, 100).parallel()
                .mapToObj(val -> {
                    Double code=Math.floor(Math.random()*ALPHABET_LEN)+ START;
                    return (Character.toString((char) code.intValue()));
                })
                .collect(Collectors.toList()).toArray(new String[100]);
    }

    private String xCode(String input, boolean encode){
        AtomicInteger index = new AtomicInteger();
        return Arrays.stream(input.split(""))
                .map(letter -> {
                    int offset = ((int) key[index.getAndIncrement() % key.length].charAt(0)) - START;
                    offset = encode ? offset : -offset;
                    int newCharCode = ((int) letter.charAt(0)) + offset;
                    int wrapOffset = encode ? -ALPHABET_LEN : ALPHABET_LEN;
                    newCharCode = (newCharCode > END || newCharCode < START) ? newCharCode + wrapOffset : newCharCode;
                    return (Character.toString((char) newCharCode));
                })
                .collect(Collectors.joining(""));
    }

    public String encode(String plain){
        return xCode(plain, true);
    }

    public String decode(String cipher){
        return xCode(cipher, false);
    }

    public String getKey() {
        return Arrays.stream(key).collect(Collectors.joining(""));
    }
}
