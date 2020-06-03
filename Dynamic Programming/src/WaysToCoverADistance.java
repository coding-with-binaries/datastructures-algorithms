import java.util.Scanner;

public class WaysToCoverADistance {
    private static int getTotalWays_Recursive(int distance) {
        if (distance < 0) {
            return 0;
        }

        // If distance is 0 there is one possible way. Not moving
        if (distance == 0) {
            return 1;
        }

        // The idea is to find number of paths where moving will bring me to distance 0
        // Other way to put it is: A step is only valid if I can reach the end i.e distance 0
        // Only in that case the case will be counted as 1
        int case1 = getTotalWays_Recursive(distance - 1);
        int case2 = getTotalWays_Recursive(distance - 2);
        int case3 = getTotalWays_Recursive(distance - 3);

        return case1 + case2 + case3;
    }

    private static int getTotalWays_Memoize(int distance, int[] cache) {
        if (distance < 0) {
            return 0;
        }

        if (cache[distance] != 0) {
            return cache[distance];
        }

        // The idea is to find number of paths where moving will bring me to distance 0
        // Other way to put it is: A step is only valid if I can reach the end i.e distance 0
        // Only in that case the case will be counted as 1
        int case1 = getTotalWays_Memoize(distance - 1, cache);
        int case2 = getTotalWays_Memoize(distance - 2, cache);
        int case3 = getTotalWays_Memoize(distance - 3, cache);

        cache[distance] = case1 + case2 + case3;
        return cache[distance];
    }

    private static int getTotalWays_Memoize(int distance) {
        int[] cache = new int[distance + 1];
        cache[0] = 1;

        return getTotalWays_Memoize(distance, cache);
    }

    private static int getTotalWays_DP(int distance) {
        int[] cache = new int[distance + 1];
        cache[0] = 1;

        for (int i = 1; i <= distance; i++) {
            int case1 = cache[i - 1];
            int case2 = 0;
            int case3 = 0;
            if (i > 1) {
                case2 = cache[i - 2];
                if (i > 2) {
                    case3 = cache[i - 3];
                }
            }
            cache[i] = case1 + case2 + case3;
        }
        return cache[distance];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the distance to be covered");
        int distance = scanner.nextInt();

        int totalWays_DP = getTotalWays_DP(distance);
        System.out.println(String.format("DP: Total ways to cover the distance %s by taking 1,2 or 3 steps is: %s", distance, totalWays_DP));

        int totalWays_Memoization = getTotalWays_Memoize(distance);
        System.out.println(String.format("Memoization: Total ways to cover the distance %s by taking 1,2 or 3 steps is: %s", distance, totalWays_Memoization));

        int totalWays_Recursive = getTotalWays_Recursive(distance);
        System.out.println(String.format("Recursive: Total ways to cover the distance %s by taking 1,2 or 3 steps is: %s", distance, totalWays_Recursive));
    }
}
