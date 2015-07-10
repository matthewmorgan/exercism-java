import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Accumulate {

    public static <T> List<T> accumulate(List <T> input, Function<T, T> op) {
        List<T> result=new ArrayList<>();
        input.stream().forEach((el)->{
            result.add(op.apply(el));
        });
        return result;
    }
}
