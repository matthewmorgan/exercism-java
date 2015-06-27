import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagram {
    String[] word;
    String sortedWord="";

    public Anagram(String word){
        this.word=word.toLowerCase().split("");
        Arrays.sort(this.word);
        sortedWord=Arrays.toString(this.word);
    }

    public List<String> match(List<String> possibles){
        ArrayList<String> matches=new ArrayList<>();
        possibles.stream().forEach((possible)->{
            String[] sorted=possible.toLowerCase().split("");
            Arrays.sort(sorted);
            if (Arrays.toString(sorted).equals(sortedWord)){ matches.add(possible); }
        });
        return matches;
    }
}
