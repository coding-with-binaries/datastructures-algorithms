import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianFinder {
    // This will be a max heap
    private final PriorityQueue<Integer> lowerHalf;
    // This will be a min heap
    private final PriorityQueue<Integer> upperHalf;

    public MedianFinder() {
        lowerHalf = new PriorityQueue<>(Comparator.reverseOrder());
        upperHalf = new PriorityQueue<>();
    }

    public void addNumber(int n) {
        // We always add first number in upper half minHeap.
        upperHalf.add(n);
        // Then to ensure that all the numbers in upper half is greater than lower half move the smallest element to the lower half maxHeap
        lowerHalf.add(upperHalf.remove());

        // Maintaining the condition that upperHalf will always have equal or more elements
        // So since upper half will always have 1 more or equal either median is in upper half or its the average.
        if (upperHalf.size() < lowerHalf.size()) {
            upperHalf.add(lowerHalf.remove());
        }
    }

    public double findMedian() {
        if (upperHalf.size() > lowerHalf.size()) {
            return upperHalf.peek();
        } else {
            return (lowerHalf.peek() + upperHalf.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of items in array");
        int totalItems = scanner.nextInt();
        int[] N = new int[totalItems];
        System.out.println("Enter the items in array");
        for (int i = 0; i < totalItems; i++) {
            N[i] = scanner.nextInt();
        }

        MedianFinder medianFinder = new MedianFinder();
        System.out.println("Running Median is:");
        for (int i = 0; i < totalItems; i++) {
            medianFinder.addNumber(N[i]);
            System.out.print(medianFinder.findMedian());
            if (i != totalItems - 1) {
                System.out.print(", ");
            }
        }
    }
}
