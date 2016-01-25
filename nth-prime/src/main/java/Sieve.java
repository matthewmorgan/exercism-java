import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sieve {

    public static List<Integer> getPrimes(Integer limit) {
        int p = 2;
        HashMap<Integer, Boolean> range = new HashMap<>();
        List<Integer> primes = new ArrayList<>();
        for (int ii = 2; ii <= limit; ii++) {
            range.put(ii, true);
        }
        for (int ii = 2; ii <= limit / 2; ii++) {
            for (int jj = 2 * p; jj <= limit; jj += p) {
                range.put(jj, false);
            }
            p++;
        }
        for (int key : range.keySet()) {
            if (range.get(key)) {
                primes.add(key);
            }
        }
        return primes;
    }
}