import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Strain {

    public static<T> List<T> keep(List<T> input, Predicate<T> p){
        return filter(input, p, true);
    }

    public static<T> List<T> discard(List<T> input, Predicate<T> p){
        return filter(input, p, false);
    }

    private static<T> List<T> filter(List<T> input, Predicate<T> p, boolean keep){
        List<T> filtered=new ArrayList<T>();
        input.stream().forEach(el -> {
            if (keep==p.test(el)) filtered.add(el);
        });
        return filtered;
    };

}
