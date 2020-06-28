import java.util.Scanner;

public class DiceThrow {
    /**
     * @param M Number of faces in the dice
     * @param N Number of throws allowed for the dice
     * @param S Desired sum to be achieved
     * @return Returns total ways to get the sum
     */
    private static long getNumberOfWaysForSum_Recursive(int M, int N, int S) {
        // If Sum becomes 0 only on the last throw then this case is possible.
        // Last throw since if N>0 its not possible to achieve the sum S
        if (S == 0 && N == 0) {
            return 1;
        }

        // If any of the below condition is present then the sum cannot be achieved
        if (S < 0 || N == 0 || S < N || S > (N * M)) {
            return 0;
        }

        long totalWays = 0;
        for (int i = 1; i <= M; i++) {
            totalWays += getNumberOfWaysForSum_Recursive(M, N - 1, S - i);
        }
        return totalWays;
    }

    private static long getNumberOfWaysForSum_Memoize(int M, int N, int S, long[][] cache) {
        // If Sum becomes 0 only on the last throw then this case is possible.
        // Last throw since if N>0 its not possible to achieve the sum S
        if (S == 0 && N == 0) {
            return 1;
        }

        // If any of the below condition is present then the sum cannot be achieved
        if (S < 0 || N == 0 || S < N || S > (N * M)) {
            return 0;
        }

        if (cache[N][S] != -1) {
            return cache[N][S];
        }

        long totalWays = 0;
        for (int i = 1; i <= M; i++) {
            totalWays += getNumberOfWaysForSum_Memoize(M, N - 1, S - i, cache);
        }
        return cache[N][S] = totalWays;
    }

    private static long getNumberOfWaysForSum_Memoize(int M, int N, int S) {
        long[][] cache = new long[N + 1][S + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= S; j++) {
                cache[i][j] = -1;
            }
        }

        return getNumberOfWaysForSum_Memoize(M, N, S, cache);
    }

    private static long getNumberOfWaysForSum_DP(int M, int N, int S) {
        long[][] cache = new long[N + 1][S + 1];
        cache[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= S; j++) {
                if (i == 1 && j <= M) {
                    // If only one dice and sum <= number of faces then only one solution
                    cache[i][j] = 1;
                } else {
                    for (int k = 1; k <= M && k < j; k++) {
                        cache[i][j] += cache[i - 1][j - k];
                    }
                }
            }
        }

        return cache[N][S];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of faces of the dice");
        int M = scanner.nextInt();
        System.out.println("Enter the number of throws allowed");
        int N = scanner.nextInt();
        System.out.println("Enter the desired sum");
        int S = scanner.nextInt();

        long totalWaysForSum_DP = getNumberOfWaysForSum_DP(M, N, S);
        System.out.println(String.format("DP: Total ways to get the sum: %s is: %s", S, totalWaysForSum_DP));

        long totalWaysForSum_Memoization = getNumberOfWaysForSum_Memoize(M, N, S);
        System.out.println(String.format("Memoization: Total ways to get the sum: %s is: %s", S, totalWaysForSum_Memoization));

        long totalWaysForSum_Recursion = getNumberOfWaysForSum_Recursive(M, N, S);
        System.out.println(String.format("Recursion: Total ways to get the sum: %s is: %s", S, totalWaysForSum_Recursion));
    }
}
