/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 */

import java.util.Scanner;

public class BuySellStock3 {
    private static int getMaxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int len = prices.length;

        int[] leftMaxProfit = new int[len], rightMaxProfit = new int[len];
        leftMaxProfit[0] = 0;
        rightMaxProfit[len - 1] = 0;

        int minimumBuy = prices[0];
        for (int i = 1; i < len; i++) {
            if (prices[i] < minimumBuy) {
                minimumBuy = prices[i];
            }
            leftMaxProfit[i] = Math.max(leftMaxProfit[i - 1], prices[i] - minimumBuy);
        }

        int maximumBuy = prices[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            if (prices[i] > maximumBuy) {
                maximumBuy = prices[i];
            }
            rightMaxProfit[i] = Math.max(rightMaxProfit[i + 1], maximumBuy - prices[i]);
        }

        int maxProfit = 0;
        for (int i = 0; i < len; i++) {
            maxProfit = Math.max(maxProfit, leftMaxProfit[i] + rightMaxProfit[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of days in dataset");
        int days = scanner.nextInt();
        System.out.println("Enter the price of stock on each day");
        int[] prices = new int[days];
        for (int i = 0; i < days; i++) {
            prices[i] = scanner.nextInt();
        }
        int maxProfit = getMaxProfit(prices);
        System.out.println("Maximum profit is: " + maxProfit);
    }
}
