import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class DNA {
    private static Map<Character, Integer> map;

    public DNA(String strand) {
        map = getMapFromStrand(strand);
    }

    private static Map<Character, Integer> getMapFromStrand(String strand){
         return strand.chars().parallel()
                .collect(Counts::new, Counts::increment, Counts::combine)
                .buildMap();
    }

    public static int count(Character nuc) {
        if (!map.containsKey(nuc)) { throw new IllegalArgumentException(); }
        return map.get(nuc);
    }

    private static class Counts {
        private int a,c,g,t;

        private void increment(int nuc){
            switch (nuc){
                case 'A' : { a++; break; }
                case 'C' : { c++; break; }
                case 'G' : { g++; break; }
                case 'T' : { t++; break; }
            }
        }

        private void combine(Counts other){
            a+=other.a; c+=other.c; g+=other.g; t+=other.t;
        }

        private Map<Character, Integer> buildMap(){
            HashMap<Character, Integer> map=new HashMap<>();
            map.put('A',a);
            map.put('C',c);
            map.put('G',g);
            map.put('T',t);
            return Collections.unmodifiableMap(map);
        }
    }
    public static Map<Character, Integer> nucleotideCounts() {
        return map;
    }
}