//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.stream.IntStream;
//import java.util.stream.Collectors;
//
//public class Sieve {
//    private static Integer limit;
//    private static Map<Integer, Boolean> primesMap;
//
//    public Sieve(Integer limit) {
//        this.limit = limit;
//        generatePrimesMap(limit);
//    }
//
//    public static List getPrimes() {
//        return primesMap.keySet().stream()
//                .collect(Collectors.toList());
//    }
//
//    private static void generatePrimesMap(Integer limit) {
//        primesMap = IntStream.rangeClosed(2, limit)
//                .mapToObj(val -> val)
//                .collect(Collectors.toMap(val -> val, val -> true));
//        AtomicInteger p = new AtomicInteger(2);
//        IntStream.rangeClosed(2, limit / 2)
//                .forEach(loop -> {
//                    IntStream.rangeClosed(2 * p.get(), limit)
//                            .filter(jj -> jj % p.get() == 0)
//                            .forEach(jj -> primesMap.remove(jj));
//                    p.incrementAndGet();
//                });
//    }
//}

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Sieve {

    static Integer limit;

    public Sieve(Integer limit){
        this.limit=limit;
    }

    public Sieve() {
    }

    public static List getPrimes() {
        return IntStream.rangeClosed(2, limit)
                .parallel()
                .filter(number -> isPrime(number))
                .mapToObj(prime -> prime)
                .collect(Collectors.toList());
    }

    private static Boolean isPrime(int number){
        return IntStream.rangeClosed(2, number/2)
                .noneMatch(possibleFactor -> number % possibleFactor == 0);
    }
}