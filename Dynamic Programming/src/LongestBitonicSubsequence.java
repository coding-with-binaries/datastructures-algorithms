import java.util.Arrays;
import java.util.Scanner;

public class LongestBitonicSubsequence {
    private static int getLongestBitonicSubsequence(int[] A) {
        int len = A.length;
        if (len == 0) {
            return 0;
        }
        int[] longestIncreasingStore = new int[len], longestDecreasingStore = new int[len];

        // Find Longest Increasing Subsequence and Longest Decreasing Subsequence
        longestIncreasingStore[0] = 1;
        longestDecreasingStore[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            int maxIncreasingSequence = 1;
            int maxDecreasingSequence = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    maxIncreasingSequence = Math.max(maxIncreasingSequence, longestIncreasingStore[j] + 1);
                }
                if (A[len - 1 - i] > A[len - 1 - j]) {
                    maxDecreasingSequence = Math.max(maxDecreasingSequence, longestDecreasingStore[len - 1 - j] + 1);
                }
            }
            longestIncreasingStore[i] = maxIncreasingSequence;
            longestDecreasingStore[len - 1 - i] = maxDecreasingSequence;
        }

        int longestBitonicSequence = 1;
        for (int i = 0; i < len; i++) {
            int currentSequence = longestIncreasingStore[i] + longestDecreasingStore[i] - 1;
            if (currentSequence > longestBitonicSequence) {
                longestBitonicSequence = currentSequence;
            }
        }
        return longestBitonicSequence;
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

        int longestBitonicSubsequence = getLongestBitonicSubsequence(A);
        System.out.println(String.format("Longest Bitonic Subsequence in the sequence %s is: %s", Arrays.toString(A), longestBitonicSubsequence));
    }
}
