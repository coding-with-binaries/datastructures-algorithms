import java.util.Arrays;
import java.util.Scanner;

public class CoinsInALine {
    private static int getMaximumValue_Recursive(int[] coins, int i, int j) {

        if (i > j) {
            return 0;
        }

        // Pick coin at index i
        // Since the opponent is smart he will try to make sure we get to choose the minimum
        // If opponent picks coin at index j we have next option for coin at index i+1 or j-1
        // If opponent picks coin at index i+1 we have next option for coin at index i+2 or j
        int case1 = coins[i] + Math.min(getMaximumValue_Recursive(coins, i + 1, j - 1), getMaximumValue_Recursive(coins, i + 2, j));

        // Pick coin at index j
        // Since the opponent is smart he will try to make sure we get to choose the minimum
        // If opponent picks coin at index i we have next option for coin at index i+1 or j-1
        // If opponent picks coin at index j-1 we have next option for coin at index i or j-2
        int case2 = coins[j] + Math.min(getMaximumValue_Recursive(coins, i + 1, j - 1), getMaximumValue_Recursive(coins, i, j - 2));

        // Note: Cases 1 and 2 have a same recursive function. So we do not ideally need to calculate it twice.
        // It can be saved in one computation.
        // We have to get maximum value
        return Math.max(case1, case2);
    }

    private static int getMaximumValue_Recursive(int[] coins) {

        int totalCoins = coins.length;
        return getMaximumValue_Recursive(coins, 0, totalCoins - 1);
    }

    private static int getMaximumValue_Memoize(int[] coins, int i, int j, int[][] cache) {

        if (i > j) {
            return 0;
        }

        if (cache[i][j] != -1) {
            return cache[i][j];
        }

        // Pick coin at index i
        // Since the opponent is smart he will try to make sure we get to choose the minimum
        // If opponent picks coin at index j we have next option for coin at index i+1 or j-1
        // If opponent picks coin at index i+1 we have next option for coin at index i+2 or j
        int case1 = coins[i] + Math.min(getMaximumValue_Memoize(coins, i + 1, j - 1, cache), getMaximumValue_Memoize(coins, i + 2, j, cache));

        // Pick coin at index j
        // Since the opponent is smart he will try to make sure we get to choose the minimum
        // If opponent picks coin at index i we have next option for coin at index i+1 or j-1
        // If opponent picks coin at index j-1 we have next option for coin at index i or j-2
        int case2 = coins[j] + Math.min(getMaximumValue_Memoize(coins, i + 1, j - 1, cache), getMaximumValue_Memoize(coins, i, j - 2, cache));

        // We have to get maximum value
        cache[i][j] = Math.max(case1, case2);
        return cache[i][j];
    }

    private static int getMaximumValue_Memoize(int[] coins) {
        int totalCoins = coins.length;
        int[][] cache = new int[totalCoins][totalCoins];
        for (int i = 0; i < totalCoins; i++) {
            for (int j = 0; j < totalCoins; j++) {
                cache[i][j] = -1;
            }
        }
        return getMaximumValue_Memoize(coins, 0, totalCoins - 1, cache);
    }

    private static int getMaximumValue_DP(int[] coins) {
        int totalCoins = coins.length;
        int[][] cache = new int[totalCoins][totalCoins];

        // Here if we observe the above recursive functions we need to have the diagonals ready
        // Also we are not interested in filling when i>j (i.e. lower triangle) since its 0 anyway
        // Diagonal elements always start filling from i=0
        for (int d = 0; d < totalCoins; d++) {
            for (int i = 0, j = d; j < totalCoins; i++, j++) {
                // As we can see in above recursive solutions there are only 3 next cases
                // Next case 1 corresponds to the scenario when either we or opponent picked coin at j
                int nextCase1 = i + 1 < totalCoins && j > 0 ? cache[i + 1][j - 1] : 0;

                // Next case 2 corresponds to the scenario when we picked coin at i and opponent picked i+1
                int nextCase2 = i + 2 < totalCoins ? cache[i + 2][j] : 0;

                // Next case 2 corresponds to the scenario when we picked coin at j and opponent picked j-1
                int nextCase3 = j - 2 >= 0 ? cache[i][j - 2] : 0;

                int case1 = coins[i] + Math.min(nextCase1, nextCase2);
                int case2 = coins[j] + Math.min(nextCase1, nextCase3);

                cache[i][j] = Math.max(case1, case2);
            }
        }
        return cache[0][totalCoins - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of coins");
        int totalCoins = scanner.nextInt();
        System.out.println("Enter value of each coin");
        int[] coins = new int[totalCoins];
        for (int i = 0; i < totalCoins; i++) {
            coins[i] = scanner.nextInt();
        }

        int maximumValue_DP = getMaximumValue_DP(coins);
        System.out.println(String.format("DP: Maximum obtainable value on playing first with the coins of value %s is: %s", Arrays.toString(coins), maximumValue_DP));

        int maximumValue_Memoization = getMaximumValue_Memoize(coins);
        System.out.println(String.format("Memoization: Maximum obtainable value on playing first with the coins of value %s is: %s", Arrays.toString(coins), maximumValue_Memoization));

        int maximumValue_Recursive = getMaximumValue_Recursive(coins);
        System.out.println(String.format("Recursive: Maximum obtainable value on playing first with the coins of value %s is: %s", Arrays.toString(coins), maximumValue_Recursive));
    }
}
