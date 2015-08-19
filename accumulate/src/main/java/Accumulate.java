import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Accumulate {

    public static <T> List<T> accumulate(List <T> input, Function<T, T> op) {
        return input.stream()
                .map(el -> op.apply(el))
                .collect(Collectors.toList());
    }
}
