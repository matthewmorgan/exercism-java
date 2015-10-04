import java.util.stream.IntStream;

public class Hamming {
    public static Integer compute(String a, String b){
        if (a.length()!=b.length()) throw (new IllegalArgumentException());
        return IntStream.range(0, a.length())
                .reduce(0, (count, ii)-> areDifferent(count, ii, a, b));
    }

    public static Integer areDifferent(int accum, int index, String a, String b){
        if (a.charAt(index) != b.charAt(index)) accum++;
        return accum;
    }
}
