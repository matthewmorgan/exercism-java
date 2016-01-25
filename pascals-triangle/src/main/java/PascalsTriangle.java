import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PascalsTriangle {

    public static Integer[][] computeTriangle(int rowCount) {
        if (rowCount < 0) throw new IllegalArgumentException();
        return generateRows(rowCount);
    }

    private static Integer[][] generateRows(int rowCount){
        return IntStream.range(0, rowCount)
                .mapToObj(ii -> {
                    return IntStream.rangeClosed(0, ii)
                            .mapToObj(jj -> getCellValue(ii, jj))
                            .collect(Collectors.toList()).toArray(new Integer[ii]);
                })
                .collect(Collectors.toList()).toArray(new Integer[rowCount][]);
    }

    public static boolean isTriangle(int[][] triangle) {
        Integer[][] computed = computeTriangle(triangle.length);
        return IntStream.range(0, triangle.length)
                .allMatch(ii -> IntStream.range(0,triangle[ii].length).allMatch(jj -> triangle[ii][jj] == computed[ii][jj]));
    }

    private static int getCellValue(int n, int k) {
        return factorial(n) / factorial(k) / factorial(n - k);
    }

    private static int factorial(int n) {
        return IntStream.rangeClosed(1, n)
                .reduce(1, (result, factor) -> result * factor);
    }
}
