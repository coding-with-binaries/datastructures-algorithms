import java.util.Scanner;

public class PossibleWaysOfCoinChange {
    public static int getPossibleWays(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        int totalCoins = coins.length;
        // Rows corresponds to total coins and columns for amount
        int possibleWays[][] = new int[totalCoins + 1][amount + 1];
        // If amount is 0 then it doesn't matter how many coins we have. There is always solution only
        for (int i = 0; i <= totalCoins; i++) {
            possibleWays[i][0] = 1;
        }
        for (int i = 1; i <= totalCoins; i++) {
            for (int j = 1; j <= amount; j++) {
                possibleWays[i][j] = possibleWays[i - 1][j];
                if (j - coins[i - 1] >= 0) {
                    possibleWays[i][j] += possibleWays[i][j - coins[i - 1]];
                }
            }
        }
        return possibleWays[totalCoins][amount];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter total amount");
        int amount = scanner.nextInt();
        System.out.println("Enter number of coins");
        int totalCoins = scanner.nextInt();
        int coins[] = new int[totalCoins];
        System.out.println("Enter the denomination of coins");
        for (int i = 0; i < totalCoins; i++) {
            coins[i] = scanner.nextInt();
        }
        int possibleWays = getPossibleWays(amount, coins);
        System.out.println("Total possible ways to make coin change is: " + possibleWays);
    }
}
