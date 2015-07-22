import java.util.Arrays;

public class PascalsTriangle {

    public static int[][] computeTriangle(int rowCount) {
        if (rowCount < 0) throw new IllegalArgumentException();
        return generateRows(rowCount);
    }

    private static int[][] generateRows(int rowCount){
        int[][] rows = new int[rowCount][];
        for (int ii = 0; ii < rowCount; ii++) {
            int[] row = new int[ii + 1];
            for (int jj = 0; jj < ii + 1; jj++) {
                row[jj] = getCellValue(ii, jj);
            }
            rows[ii] = row;
        }
        return rows;
    }

    public static boolean isTriangle(int[][] triangle) {
        return Arrays.deepEquals(triangle, computeTriangle(triangle.length));
    }

    private static int getCellValue(int n, int k) {
        return factorial(n) / factorial(k) / factorial(n - k);
    }

    private static int factorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }
}
