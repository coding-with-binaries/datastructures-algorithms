import java.util.Scanner;

public class DiceThrow {
    /**
     * @param M Number of faces in the dice
     * @param N Number of throws allowed for the dice
     * @param S Desired sum to be achieved
     * @return Returns total ways to get the sum
     */
    private static int getNumberOfWaysForSum_Recursive(int M, int N, int S) {
        // If Sum becomes 0 only on the last throw then this case is possible.
        // Last throw since if N>0 its not possible to achieve the sum S
        if (S == 0 && N == 0) {
            return 1;
        }

        // If any of the below condition is present then the sum cannot be achieved
        if (S < 0 || N == 0 || S < N || S > (N * M)) {
            return 0;
        }

        int totalWays = 0;
        for (int i = 1; i <= M; i++) {
            totalWays += getNumberOfWaysForSum_Recursive(M, N - 1, S - i);
        }
        return totalWays;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of faces of the dice");
        int M = scanner.nextInt();
        System.out.println("Enter the number of throws allowed");
        int N = scanner.nextInt();
        System.out.println("Enter the desired sum");
        int S = scanner.nextInt();

        int totalWaysForSum_Recursion = getNumberOfWaysForSum_Recursive(M, N, S);
        System.out.println(String.format("Total ways to get the sum: %s is: %s", S, totalWaysForSum_Recursion));
    }
}
