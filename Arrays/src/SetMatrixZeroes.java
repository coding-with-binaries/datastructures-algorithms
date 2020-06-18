/*
 * Author - Varun Sharma
 * Time Complexity - O(n^2)
 * Space Complexity - Constant Space
 */

import java.util.Scanner;

public class SetMatrixZeroes {
    private static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstRowZero = false;
        for (int c = 0; c < cols; c++) {
            if (matrix[0][c] == 0) {
                firstRowZero = true;
                break;
            }
        }
        boolean firstColumnZero = false;
        for (int r = 0; r < rows; r++) {
            if (matrix[r][0] == 0) {
                firstColumnZero = true;
                break;
            }
        }
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        for (int c = 0; c < cols; c++) {
            if (firstRowZero) {
                matrix[0][c] = 0;
            }
        }

        for (int r = 0; r < rows; r++) {
            if (firstColumnZero) {
                matrix[r][0] = 0;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(matrix[r][c] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of rows in matrix");
        int rows = scanner.nextInt();
        System.out.println("Enter number of columns in matrix");
        int columns = scanner.nextInt();

        int[][] matrix = new int[rows][columns];

        for (int r = 0; r < rows; r++) {
            System.out.println("Enter items in row:" + (r + 1));
            for (int c = 0; c < columns; c++) {
                matrix[r][c] = scanner.nextInt();
            }
        }
        System.out.println("Matrix entered is:");
        printMatrix(matrix);
        setZeroes(matrix);
        System.out.println("Matrix after setting zeroes is:");
        printMatrix(matrix);
    }
}
