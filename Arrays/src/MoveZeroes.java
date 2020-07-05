import java.util.Arrays;
import java.util.Scanner;

public class MoveZeroes {
    private static void moveZeroes(int[] A) {
        int p = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != 0) {
                A[p++] = A[i];
            }
        }
        while (p < A.length) {
            A[p++] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int N = scanner.nextInt();
        int[] A = new int[N];
        System.out.println("Enter the numbers in the array");
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println("Given Array: " + Arrays.toString(A));
        moveZeroes(A);
        System.out.println("Array after moving zeroes: " + Arrays.toString(A));
    }
}
