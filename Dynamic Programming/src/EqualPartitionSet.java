import java.util.Arrays;
import java.util.Scanner;

public class EqualPartitionSet {
    private static boolean hasEqualPartitionSets(int A[]) {
        int len = A.length;
        int sumOfElements = 0;
        for (int i = 0; i < len; i++) {
            sumOfElements += A[i];
        }
        if (sumOfElements % 2 == 0) {
            int sumForEqualPartition = sumOfElements / 2;
            // Now this becomes subset sum problem
            // We have to find any subset with sum as half the total
            boolean cache[][] = new boolean[len + 1][sumForEqualPartition + 1];
            for (int i = 0; i <= len; i++) {
                for (int j = 0; j <= sumForEqualPartition; j++) {
                    if (i == 0) {
                        cache[i][j] = false;
                    } else if (j == 0) {
                        cache[i][j] = true;
                    } else if (A[i - 1] > j) {
                        cache[i][j] = cache[i - 1][j];
                    } else {
                        boolean case1 = cache[i - 1][j - A[i - 1]];
                        boolean case2 = cache[i - 1][j];
                        cache[i][j] = case1 || case2;
                    }
                }
            }
            return cache[len][sumForEqualPartition];
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of items in array");
        int totalItems = scanner.nextInt();
        int A[] = new int[totalItems];
        System.out.println("Enter the items in array");
        for (int i = 0; i < totalItems; i++) {
            A[i] = scanner.nextInt();
        }

        String equalPartitionPresent = hasEqualPartitionSets(A) ? "PRESENT" : "NOT PRESENT";
        System.out.println(String.format("Equal partition set is %s in the array %s", equalPartitionPresent, Arrays.toString(A)));
    }
}
