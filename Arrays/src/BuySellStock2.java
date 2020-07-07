/*
 * Say you have an array prices for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 */

import java.util.Scanner;

public class BuySellStock2 {
    private static int getMaxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
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
