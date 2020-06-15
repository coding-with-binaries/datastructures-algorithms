import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargestElement {
    private static int getKthLargestElement(int[] A, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int item : A) {
            maxHeap.add(item);
        }

        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }
        return maxHeap.remove();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of items in array");
        int totalItems = scanner.nextInt();
        int[] A = new int[totalItems];
        System.out.println("Enter the items in array");
        for (int i = 0; i < totalItems; i++) {
            A[i] = scanner.nextInt();
        }


        System.out.println("Enter value of K");
        int k = scanner.nextInt();

        int kthLargest = getKthLargestElement(A, k);
        System.out.println(String.format("Kth Largest Element in the array %s is: %s", Arrays.toString(A), kthLargest));
    }
}
