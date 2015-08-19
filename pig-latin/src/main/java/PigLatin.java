import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PigLatin {

    private static Pattern consonants = Pattern.compile("^((ch)|(th[r]?)|(sch)|(qu)|(squ))");
    private static Pattern vowels = Pattern.compile("^([aeiou]|(yt)|(xr))");

    private static String translateVowelStart(String word){
        return word+"ay";
    }

    private static String translateConsonantStart(String word){
        Matcher consMatcher= consonants.matcher(word);
        int suffixStart=consMatcher.find() ? consMatcher.end() : 1;
        return getPigWord(word, word.substring(suffixStart));
    }

    private static String getPigWord(String wholeWord, String suffix){
        String prefix=wholeWord.substring(0,wholeWord.length()-suffix.length());
        return suffix+prefix+"ay";
    }

    public static String translate(String englishPhrase){
        return Arrays.asList(englishPhrase.split(" ")).stream()
                .map(word -> vowels.matcher(word).find() ? translateVowelStart(word)
                        : translateConsonantStart(word))
                .collect(Collectors.joining(" "));
    }

}
