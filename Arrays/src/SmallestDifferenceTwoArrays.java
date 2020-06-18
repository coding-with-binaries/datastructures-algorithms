/*
 * Author - Varun Sharma
 * Complexity - O(nlogn)
 */

import java.util.Arrays;
import java.util.Scanner;

public class SmallestDifferenceTwoArrays {
    private static int getSmallestDifference(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int a = 0, b = 0;
        int min = Integer.MAX_VALUE;
        while (a < A.length && b < B.length) {
            int diff = Math.abs(A[a] - B[b]);
            if (diff < min) {
                min = diff;
            }
            if (A[a] < B[b]) {
                a++;
            } else {
                b++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements in first array");
        int lenA = scanner.nextInt();
        System.out.println("Enter number of elements in second array");
        int lenB = scanner.nextInt();

        int[] A = new int[lenA], B = new int[lenB];
        System.out.println("Enter elements of first array");
        for (int a = 0; a < lenA; a++) {
            A[a] = scanner.nextInt();
        }

        System.out.println("Enter elements of second array");
        for (int b = 0; b < lenB; b++) {
            B[b] = scanner.nextInt();
        }

        int minDifference = getSmallestDifference(A, B);
        System.out.println("Smallest difference between elements of arrays is: " + minDifference);
    }
}
