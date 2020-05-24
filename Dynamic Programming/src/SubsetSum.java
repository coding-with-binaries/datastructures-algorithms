/*
 * Author - Varun Sharma
 * Time Complexity - O(n*sum) - Pseudo Polynomial Time Complexity
 * Space Complexity - O(n*sum)
 */


import java.util.Arrays;
import java.util.Scanner;

public class SubsetSum {
    private static boolean isSubsetPresentWithSum_Recursive(int A[], int sum, int start) {
        int len = A.length;

        if (sum == 0) {
            return true;
        }

        if (start == len) {
            return false;
        }

        if (A[start] > sum) {
            return isSubsetPresentWithSum_Recursive(A, sum, start + 1);
        }

        // Including start element in sum
        boolean case1 = isSubsetPresentWithSum_Recursive(A, sum - A[start], start + 1);
        // Not including start element in sum
        boolean case2 = isSubsetPresentWithSum_Recursive(A, sum, start + 1);
        return case1 || case2;
    }

    private static boolean isSubsetPresentWithSum_Recursive(int A[], int sum) {
        return isSubsetPresentWithSum_Recursive(A, sum, 0);
    }

    private static boolean isSubsetPresentWithSum_Memoize(int A[], int sum, int start, int[][] cache) {
        if (cache[start][sum] != -1) {
            return cache[start][sum] == 1;
        }
        int len = A.length;

        if (sum == 0) {
            cache[start][sum] = 1;
            return true;
        }

        if (start == len) {
            cache[start][sum] = 0;
            return false;
        }

        if (A[start] > sum) {
            boolean isPresent = isSubsetPresentWithSum_Memoize(A, sum, start + 1, cache);
            cache[start][sum] = isPresent ? 1 : 0;
            return isPresent;
        }

        // Including start element in sum
        boolean case1 = isSubsetPresentWithSum_Memoize(A, sum - A[start], start + 1, cache);
        // Not including start element in sum
        boolean case2 = isSubsetPresentWithSum_Memoize(A, sum, start + 1, cache);
        boolean isPresent = case1 || case2;
        cache[start][sum] = isPresent ? 1 : 0;
        return isPresent;
    }

    private static boolean isSubsetPresentWithSum_Memoize(int A[], int sum) {
        int len = A.length;
        int[][] cache = new int[len + 1][sum + 1];
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= sum; j++) {
                cache[i][j] = -1;
            }
        }
        return isSubsetPresentWithSum_Memoize(A, sum, 0, cache);
    }

    private static boolean isSubsetPresentWithSum_DP(int A[], int sum) {
        int len = A.length;
        boolean[][] cache = new boolean[len + 1][sum + 1];
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0) {
                    cache[i][j] = false;
                } else if (j == 0) {
                    cache[i][j] = true;
                } else if (A[i - 1] == j) {
                    cache[i][j] = true;
                } else if (A[i - 1] > j) {
                    cache[i][j] = cache[i - 1][j];
                } else {
                    // Including start element in sum
                    boolean case1 = cache[i - 1][j - A[i - 1]];
                    // Not including start element in sum
                    boolean case2 = cache[i - 1][j];
                    cache[i][j] = case1 || case2;
                }
            }
        }
        return cache[len][sum];
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

        System.out.println("Enter desired sum");
        int sum = scanner.nextInt();

        String isSubsetSumPresent_DP = isSubsetPresentWithSum_DP(A, sum) ? "PRESENT" : "NOT PRESENT";
        System.out.println(String.format("DP: A subset with sum %s is %s in the array %s", sum, isSubsetSumPresent_DP, Arrays.toString(A)));

        String isSubsetSumPresent_Memoize = isSubsetPresentWithSum_Memoize(A, sum) ? "PRESENT" : "NOT PRESENT";
        System.out.println(String.format("Memoization: A subset with sum %s is %s in the array %s", sum, isSubsetSumPresent_Memoize, Arrays.toString(A)));

        String isSubsetSumPresent_Recursive = isSubsetPresentWithSum_Recursive(A, sum) ? "PRESENT" : "NOT PRESENT";
        System.out.println(String.format("Recursive: A subset with sum %s is %s in the array %s", sum, isSubsetSumPresent_Recursive, Arrays.toString(A)));
    }
}
