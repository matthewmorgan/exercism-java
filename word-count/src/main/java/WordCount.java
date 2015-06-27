import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

public class WordCount {
    public Map<String, Integer> Phrase(String input){
        input=input.replaceAll("[^0-9a-zA-Z\\s]", "");
        HashMap<String, Integer> result=new HashMap<>();
        Pattern white = Pattern.compile("\\s");

        Arrays.stream(white.split(input.toLowerCase())).forEach((word)->{
            if (word.trim().length()>0){
                if (Objects.nonNull(result.get(word))){
                    result.put(word, result.get(word)+1);
                } else {
                    result.put(word, 1);
                }
            }
        });
        return result;
    }
}
