import java.util.Arrays;
import java.util.Scanner;

public class DutchNationalFlag {
    private static void sort012(int[] A) {
        int len = A.length;
        int low = 0, mid = 0, high = len - 1;

        while (mid<=high){
            if (A[mid] == 0) {
                int temp = A[low];
                A[low] = A[mid];
                A[mid] = temp;
                low++;
                mid++;
            } else if (A[mid] == 2) {
                int temp = A[high];
                A[high] = A[mid];
                A[mid] = temp;
                high--;
            } else {
                mid++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int totalElements = scanner.nextInt();
        System.out.println("Enter the value of each element");
        int[] A = new int[totalElements];
        for (int i = 0; i < totalElements; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println("Entered array is: " + Arrays.toString(A));
        sort012(A);
        System.out.println("Sorted array is: " + Arrays.toString(A));
    }
}
