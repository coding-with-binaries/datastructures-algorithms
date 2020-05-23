/*
 * Author - Varun Sharma
 * Complexity - O(n)
 */

import java.util.Scanner;

public class FlipsForAlternateBinaryString {
    private static int getMinimumNumberOfFlips(String s, char start) {
        char expected = start;

        int flipCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != expected) {
                flipCount++;
            }
            expected = expected == '0' ? '1' : '0';
        }
        return flipCount;
    }

    private static int getMinimumNumberOfFlips(String s) {
        return Math.min(getMinimumNumberOfFlips(s, '0'), getMinimumNumberOfFlips(s, '1'));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter binary string");
        String s = scanner.nextLine();
        int minimumFlips = getMinimumNumberOfFlips(s);
        System.out.println("Minimum flips to make the string alternating: " + minimumFlips);
    }
}
