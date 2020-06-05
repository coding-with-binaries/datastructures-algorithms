import java.util.Scanner;

public class MatrixLongestIncreasingPath {
    private static int getLongestIncreasingPath(int[][] matrix, int i, int j, int[][] cache) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        if (i < 0 || i >= rows || j < 0 || j >= columns) {
            return 0;
        }

        if (cache[i][j] != -1) {
            return cache[i][j];
        }

        int up = Integer.MIN_VALUE, down = Integer.MIN_VALUE, left = Integer.MIN_VALUE, right = Integer.MIN_VALUE;

        if (i > 0 && matrix[i][j] < matrix[i - 1][j]) {
            up = 1 + getLongestIncreasingPath(matrix, i - 1, j, cache);
        }

        if (i < rows - 1 && matrix[i][j] < matrix[i + 1][j]) {
            down = 1 + getLongestIncreasingPath(matrix, i + 1, j, cache);
        }

        if (j > 0 && matrix[i][j] < matrix[i][j - 1]) {
            left = 1 + getLongestIncreasingPath(matrix, i, j - 1, cache);
        }

        if (j < columns - 1 && matrix[i][j] < matrix[i][j + 1]) {
            right = 1 + getLongestIncreasingPath(matrix, i, j + 1, cache);
        }

        cache[i][j] = Math.max(up, Math.max(down, Math.max(left, Math.max(right, 1))));
        return cache[i][j];
    }

    private static int getLongestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        int columns = matrix[0].length;

        int[][] cache = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cache[i][j] = -1;
            }
        }

        int result = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int current = getLongestIncreasingPath(matrix, i, j, cache);
                if (current > result) {
                    result = current;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of rows in matrix");
        int rows = scanner.nextInt();
        System.out.println("Enter number of columns in matrix");
        int columns = scanner.nextInt();

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            System.out.println("Enter items in row:" + (i + 1));
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int longestIncreasingPath = getLongestIncreasingPath(matrix);
        System.out.println(String.format("Length of longest increasing path in matrix is: %s", longestIncreasingPath));
    }
}
