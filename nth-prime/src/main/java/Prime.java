public class Prime {

    // see http://en.wikipedia.org/wiki/Prime_number_theorem#Approximations_for_the_nth_prime_number
    public static Integer nth(Integer n){
            if (n < 1) throw new IllegalArgumentException();

            Double approximateLimit = n * Math.log(n) + n * Math.log(Math.log(n));

            if (approximateLimit < 15d) {
                approximateLimit = 15d;
            }

            //my Sieve class from the exercise of the same name
            return Sieve.getPrimes(approximateLimit.intValue()).get(n-1);
    }
}
