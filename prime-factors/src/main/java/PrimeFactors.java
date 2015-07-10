import java.util.ArrayList;

public class PrimeFactors {

    public static ArrayList<Long> getForNumber(Long num) {
        ArrayList<Long> factors=new ArrayList<>();
        Long currentFactor=2L;
        Long remaining=num;
        while (remaining!=1){
            if (remaining % currentFactor == 0){
                factors.add(currentFactor);
                remaining=remaining/currentFactor;
                currentFactor=2L;
            } else {
                currentFactor++;
            }
        }
        return factors;
    }
}
