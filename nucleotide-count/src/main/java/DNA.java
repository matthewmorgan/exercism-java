import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DNA {
    private static Character[] els = {'A', 'C', 'G', 'T'};
    private static Pattern re = Pattern.compile("[^ACGT]+");
    private static List<String> strand;
    private static Map histogram=new HashMap();

    public DNA(String strand) {
        this.strand = Arrays.asList(strand.split(""));
        histogram = Arrays.asList(els).stream().parallel()
                .collect(Collectors.toMap(
                        el -> el,
                        el -> countEls(el)));
    }

    private static Integer countEls (Character nuc){
        if (re.matcher(nuc.toString()).matches()) throw (new IllegalArgumentException());
        return Collections.frequency(strand, nuc.toString());
    }

    public static Integer count(Character nuc){
        return histogram.containsKey(nuc) ? (Integer)histogram.get(nuc) : countEls(nuc);
    }

    public Map<Character, Integer> nucleotideCounts() {
        return Collections.unmodifiableMap(histogram);
    }
}
