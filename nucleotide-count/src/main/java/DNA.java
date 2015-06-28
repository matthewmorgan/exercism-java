import java.util.*;
import java.util.regex.Pattern;

public class DNA {
    Character[] els = {'A', 'C', 'G', 'T'};
    Pattern re = Pattern.compile("[^ACGT]+");
    List<String> strand;
    HashMap<Character, Integer> histogram;

    public DNA(String strand) {
        this.strand = Arrays.asList(strand.split(""));
        histogram = new HashMap<>();
        Arrays.stream(els).forEach((el) -> {
            histogram.put(el, count(el));
        });
    }

    public Integer count(Character nuc) {
        if (re.matcher(nuc.toString()).matches()) throw (new IllegalArgumentException());
        return Collections.frequency(strand, nuc.toString());
    }

    public Map<Character, Integer> nucleotideCounts() {
        return histogram;
    }
}
