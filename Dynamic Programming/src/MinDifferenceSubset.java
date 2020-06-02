/*
 * Author - Varun Sharma
 * Time Complexity - O(n*sum) - Pseudo Polynomial Time Complexity
 * Space Complexity - O(n*sum)
 */


import java.util.Arrays;
import java.util.Scanner;

public class MinDifferenceSubset {
    private static int getMinDifferenceInSubsets(int A[]) {
        int len = A.length;

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += A[i];
        }

        boolean cache[][] = new boolean[len + 1][sum + 1];

        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0) {
                    cache[i][j] = false;
                } else if (j == 0) {
                    cache[i][j] = true;
                } else if (A[i - 1] > j) {
                    cache[i][j] = cache[i - 1][j];
                } else {
                    // Excluding element in the sum
                    boolean case1 = cache[i - 1][j];
                    // Including element in the sum
                    boolean case2 = cache[i - 1][j - A[i - 1]];
                    cache[i][j] = case1 || case2;
                }
            }
        }

        for (int i = sum / 2; i >= 0; i--) {
            if (cache[len][i]) {
                return sum - 2 * i;
            }
        }

        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of items in array");
        int totalItems = scanner.nextInt();
        int A[] = new int[totalItems];
        System.out.println("Enter the items in array");
        for (int i = 0; i < totalItems; i++) {
            A[i] = scanner.nextInt();
        }

        int minDifference = getMinDifferenceInSubsets(A);
        System.out.println(String.format("Minimum Difference in the subsets of %s is %s", Arrays.toString(A), minDifference));
    }
}
