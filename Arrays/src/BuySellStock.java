/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 */

import java.util.Scanner;

public class BuySellStock {
    private static int getMaxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int minimumBuy = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minimumBuy) {
                minimumBuy = prices[i];
            } else {
                int profit = prices[i] - minimumBuy;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
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
