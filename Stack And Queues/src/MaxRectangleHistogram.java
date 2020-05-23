/*
 * Author - Varun Sharma
 * Complexity - O(n)
 */

import java.util.Scanner;
import java.util.Stack;

public class MaxRectangleHistogram {
    private static int getMaxRectangleArea(int[] histogram) {
        int A[] = new int[histogram.length + 2];
        System.arraycopy(histogram, 0, A, 1, histogram.length);
        int len = A.length;
        A[0] = A[len - 1] = -1;
        // Using increasing stack we can find the first smaller element on left and right of a bar in O(1)
        Stack<Integer> increasingStack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < len; i++) {
            while (!increasingStack.isEmpty() && A[i] < A[increasingStack.peek()]) {
                // We calculate the max area of histogram including the popped bar with its actual height
                int heightOfBar = A[increasingStack.pop()];
                // The element which pops the bar (i.e. 'i') is the first smaller on right
                // The current stack top is the first smaller element on left
                int area = heightOfBar * (i - increasingStack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
            increasingStack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of bars in histogram");
        int n = scanner.nextInt();
        System.out.println("Enter heights of bar in histogram");
        int histogramBars[] = new int[n];
        for (int i = 0; i < n; i++) {
            histogramBars[i] = scanner.nextInt();
        }
        int maxRectangleArea = getMaxRectangleArea(histogramBars);
        System.out.println("Max Rectangle Area in Histogram is: " + maxRectangleArea);
    }
}
