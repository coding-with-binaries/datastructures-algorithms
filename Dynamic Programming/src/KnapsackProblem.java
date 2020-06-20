import java.util.Scanner;

public class KnapsackProblem {
    private static int getMaximumValue_Recursive(int[] weights, int[] values, int capacity, int current) {
        if (capacity == 0 || current == weights.length) {
            return 0;
        }

        if (weights[current] > capacity) {
            return getMaximumValue_Recursive(weights, values, capacity, current + 1);
        }

        // Taking the current weight
        int case1 = values[current] + getMaximumValue_Recursive(weights, values, capacity - weights[current], current + 1);
        // Not taking the current weight
        int case2 = getMaximumValue_Recursive(weights, values, capacity, current + 1);
        return Math.max(case1, case2);
    }

    private static int getMaximumValue_Recursive(int[] weights, int[] values, int capacity) {
        return getMaximumValue_Recursive(weights, values, capacity, 0);
    }

    private static int getMaximumValue_Memoize(int[] weights, int[] values, int capacity, int current, int[][] cache) {
        if (capacity == 0 || current == weights.length) {
            return 0;
        }

        if (cache[current][capacity] != -1) {
            return cache[current][capacity];
        }

        if (weights[current] > capacity) {
            cache[current][capacity] = getMaximumValue_Memoize(weights, values, capacity, current + 1, cache);
            return cache[current][capacity];
        }

        // Taking the current weight
        int case1 = values[current] + getMaximumValue_Memoize(weights, values, capacity - weights[current], current + 1, cache);
        // Not taking the current weight
        int case2 = getMaximumValue_Memoize(weights, values, capacity, current + 1, cache);
        cache[current][capacity] = Math.max(case1, case2);
        return cache[current][capacity];
    }

    private static int getMaximumValue_Memoize(int[] weights, int[] values, int capacity) {
        int len = weights.length;
        int[][] cache = new int[len + 1][capacity + 1];
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= capacity; j++) {
                cache[i][j] = -1;
            }
        }

        return getMaximumValue_Memoize(weights, values, capacity, 0, cache);
    }

    private static int getMaximumValue_DP(int[] weights, int[] values, int capacity) {
        int len = weights.length;
        int[][] cache = new int[len + 1][capacity + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i - 1] > j) {
                    cache[i][j] = cache[i - 1][j];
                } else {
                    // Include the ith weight
                    int case1 = values[i - 1] + cache[i - 1][j - weights[i - 1]];
                    // Not include the ith weight
                    int case2 = cache[i - 1][j];
                    cache[i][j] = Math.max(case1, case2);
                }
            }
        }

        return cache[len][capacity];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter total number of weights");
        int totalWeights = scanner.nextInt();
        int[] weights = new int[totalWeights], values = new int[totalWeights];
        System.out.println("Enter each weight and the value associated with it");
        for (int i = 0; i < totalWeights; i++) {
            weights[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
        }

        System.out.println("Enter the total capacity of the knapsack");
        int capacity = scanner.nextInt();

        int maxValue_DP = getMaximumValue_DP(weights, values, capacity);
        System.out.println("DP: Maximum value possible is: " + maxValue_DP);

        int maxValue_Memoization = getMaximumValue_Memoize(weights, values, capacity);
        System.out.println("Memoization: Maximum value possible is: " + maxValue_Memoization);

        int maxValue_Recursion = getMaximumValue_Recursive(weights, values, capacity);
        System.out.println("Recursion: Maximum value possible is: " + maxValue_Recursion);
    }
}
