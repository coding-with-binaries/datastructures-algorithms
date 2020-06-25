import java.util.Arrays;
import java.util.Scanner;

public class MergeSortedArrays {
    private static int[] getMergedArray(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;

        int lenC = lenA + lenB;
        int[] C = new int[lenC];

        int a = 0, b = 0, c = 0;
        while (a < lenA && b < lenB) {
            if (A[a] < B[b]) {
                C[c++] = A[a++];
            } else {
                C[c++] = B[b++];
            }
        }

        while (a < lenA) {
            C[c++] = A[a++];
        }

        while (b < lenB) {
            C[c++] = B[b++];
        }

        return C;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter length of first array");
        int lenA = scanner.nextInt();
        System.out.println("Enter length of second array");
        int lenB = scanner.nextInt();

        int[] A = new int[lenA], B = new int[lenB];
        System.out.println("Enter elements in first array in sorted order");
        for (int a = 0; a < lenA; a++) {
            A[a] = scanner.nextInt();
        }

        System.out.println("Enter elements in second array in sorted order");
        for (int b = 0; b < lenB; b++) {
            B[b] = scanner.nextInt();
        }

        int[] C = getMergedArray(A, B);
        System.out.println("Merged Array is: " + Arrays.toString(C));
    }
}
