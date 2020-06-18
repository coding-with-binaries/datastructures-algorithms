/*
 * Question: Find the minimum length sub-array sorting which makes the array sorted
 *
 * Author - Varun Sharma
 * Complexity - O(n)
 */

import java.util.Scanner;

public class SubArraySort {
    private static void printIndices(int[] A) {
        int len = A.length;
        int start;
        for (start = 0; start < len - 1; start++) {
            if (A[start] > A[start + 1]) {
                break;
            }
        }

        if (start == len - 1) {
            System.out.println("The array is already sorted");
            return;
        }

        int end;
        for (end = len - 1; end > 0; end--) {
            if (A[end] < A[end - 1]) {
                break;
            }
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (A[i] > max) {
                max = A[i];
            }
            if (A[i] < min) {
                min = A[i];
            }
        }

        for (int i = 0; i < start; i++) {
            if (A[i] > min) {
                start = i;
                break;
            }
        }

        for (int i = len - 1; i > end; i--) {
            if (A[i] < max) {
                end = i;
                break;
            }
        }

        System.out.println(String.format("Minimum length sub-array sorting which sorts the whole array is between indices (%s,%s)", start, end));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of items in the array");
        int N = scanner.nextInt();
        int[] A = new int[N];

        System.out.println("Enter the value of each item");
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        printIndices(A);
    }
}
