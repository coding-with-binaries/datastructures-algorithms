/*
 * Author - Varun Sharma
 * Complexity - O(n^2)
 */

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    private static int getLongestIncreasingSubsequence(int[] A) {
        int len = A.length;
        if (len == 0) {
            return 0;
        }
        int[] storage = new int[len];

        int longestIncreasingSubsequence = 1;
        for (int i = 0; i < len; i++) {
            int maxSequence = 1, currentSequence = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (A[i] > A[j]) {
                    currentSequence = 1 + storage[j];
                }
                if (currentSequence > maxSequence) {
                    maxSequence = currentSequence;
                }
            }
            storage[i] = maxSequence;
            if (maxSequence > longestIncreasingSubsequence) {
                longestIncreasingSubsequence = maxSequence;
            }
        }
        return longestIncreasingSubsequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements");
        int len = scanner.nextInt();
        System.out.println("Enter elements of the sequence");
        int[] A = new int[len];
        for (int i = 0; i < len; i++) {
            A[i] = scanner.nextInt();
        }

        int longestIncreasingSubsequence = getLongestIncreasingSubsequence(A);
        System.out.println(String.format("Longest Increasing Subsequence in the sequence %s is: %s", Arrays.toString(A), longestIncreasingSubsequence));
    }
}
