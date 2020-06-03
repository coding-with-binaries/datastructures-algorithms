import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KSortedArray {
    private static void sortKSortedArray(int[] A, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i <= k; i++) {
            minHeap.add(A[i]);
        }

        int index = 0;
        for (int i = k + 1; i < A.length; i++) {
            A[index++] = minHeap.poll();
            minHeap.add(A[i]);
        }

        while (!minHeap.isEmpty()) {
            A[index++] = minHeap.poll();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter value of K in K Sorted array");
        int k = scanner.nextInt();

        System.out.println("Enter number of items in array");
        int totalItems = scanner.nextInt();
        int A[] = new int[totalItems];
        System.out.println("Enter the items in array");
        for (int i = 0; i < totalItems; i++) {
            A[i] = scanner.nextInt();
        }

        sortKSortedArray(A, k);

        System.out.println("Sorted Array is: " + Arrays.toString(A));
    }
}
