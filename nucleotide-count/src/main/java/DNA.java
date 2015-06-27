import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class DNA {
    Character[] els={'A','C','G','T'};
    Pattern re = Pattern.compile("[^ACGT]+");
    String strand="";
    public DNA(String strand){
        this.strand=strand;
    }
    public Integer count(Character nuc){
        if (re.matcher(nuc.toString()).matches()) throw (new IllegalArgumentException());
        int count=0;
        for (int ii=0;ii<strand.length();ii++){
            if (strand.charAt(ii)==nuc){ count++;}
        }
        return count;
    }

    public Map<Character, Integer> nucleotideCounts(){
        HashMap<Character, Integer> histogram=new HashMap<>();
        Arrays.stream(els).forEach((el)->{
            histogram.put(el, count(el));
        });
        return histogram;
    }
}
