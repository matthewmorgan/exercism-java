import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.IntStream;

public class PrimeFactors {

//    public static ArrayList<Long> getForNumber(Long num) {
//        ArrayList<Long> factors=new ArrayList<>();
//        Long currentFactor=2l;
//        Long remaining=num;
//        while (remaining!=1l){
//            if (remaining % currentFactor == 0l){
//                factors.add(currentFactor);
//                remaining/=currentFactor;
//                currentFactor=2l;
//            } else {
//                currentFactor++;
//            }
//        }
//        return factors;
//    }

    public static ArrayList<Long> getForNumber(Long num){
        ArrayList<Long> factors=new ArrayList<>();
        Factor factor=new Factor(num, 2l);
        while (factor.remaining!=1){
            factors.add(factor.currentFactor);
            factor=factor.getNextFactor(factor);
        }
        return factors;
    }

    static class Factor {
        long remaining, currentFactor;

        public Factor(long remaining, long currentFactor){
            this.remaining=remaining;
            this.currentFactor=currentFactor;
        }

        public Factor getNextFactor(Factor lastFactor){
            this.remaining=lastFactor.remaining/lastFactor.currentFactor;
            this.currentFactor=2l;
            while (remaining!=1l){
                if (remaining % currentFactor == 0l){
                    return new Factor(remaining, currentFactor);
                } else {
                    currentFactor++;
                }
            }
            return null;
        }


    }
}
