import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.*;

public class Cipher {

    private static final int KEY_LEN = 100;
    private static final String alph="abcdefghijklmnopqrstuvwxyz";
    private String[] key;
    private static final Pattern re= Pattern.compile("[^a-z]+");

    public Cipher(){
        this.key=generateKey();
    }

    public Cipher(String key) {
        if (key.length()==0 || re.matcher(key).find()) throw new IllegalArgumentException();
        this.key=key.split("");
    }

    private static String[] generateKey(){
        return IntStream.range(0,KEY_LEN)
                .mapToObj(val -> {
                    int randomIndex=new Double(Math.floor(Math.random()*alph.length())).intValue();
                    return alph.substring(randomIndex, randomIndex+1);
                })
                .collect(Collectors.toList()).toArray(new String[KEY_LEN]);
    }

    private String xCode(String input, boolean encode){
        AtomicInteger ii = new AtomicInteger();
        return Arrays.stream(input.split(""))
                .map(letter -> {
                    String keyChar = key[ii.getAndIncrement() % KEY_LEN];
                    int offset = encode ? alph.indexOf(keyChar) : -alph.indexOf(keyChar);
                    int xCodedIndex = Math.floorMod(alph.indexOf(letter) + offset, alph.length());
                    return alph.substring(xCodedIndex, xCodedIndex+1);
                })
                .collect(Collectors.joining(""));
    }

    public String encode(String plain){
        return xCode(plain, true);
    }

    public String decode(String cipher){
        return xCode(cipher, false);
    }

    public String getKey() { return Arrays.stream(key).collect(Collectors.joining("")); }

}


