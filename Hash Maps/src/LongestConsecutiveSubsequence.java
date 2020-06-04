import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class LongestConsecutiveSubsequence {
    private static int getLongestConsecutiveSubsequence(int[] A) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int item : A) {
            map.put(item, false);
        }

        int longestLength = 0;
        for (int item : A) {
            int currentLength = 0;
            int current = item;
            while (map.containsKey(current) && !map.get(current)) {
                currentLength++;
                current++;
            }
            current = item - 1;
            while (map.containsKey(current) && !map.get(current)) {
                current--;
                currentLength++;
            }

            if (currentLength > longestLength) {
                longestLength = currentLength;
            }
        }

        return longestLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of items in the array");
        int n = scanner.nextInt();
        System.out.println("Enter items in the array");
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        int longestConsecutiveSubsequence = getLongestConsecutiveSubsequence(A);
        System.out.println(String.format("Length of longest consecutive subsequence in %s is: %s", Arrays.toString(A), longestConsecutiveSubsequence));
    }
}
