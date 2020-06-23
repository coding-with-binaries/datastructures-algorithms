/*
 * Author - Varun Sharma
 * Complexity - O(n^2)
 */

import java.util.Scanner;

public class LongestCommonSubsequence {
    private static int getLongestCommonSubsequence_Recursive(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();

        if (lenA == 0 || lenB == 0) {
            return 0;
        }

        if (a.charAt(0) == b.charAt(0)) {
            return 1 + getLongestCommonSubsequence_Recursive(a.substring(1), b.substring(1));
        }

        // Check for next character in string a with current character in string b
        int case1 = getLongestCommonSubsequence_Recursive(a.substring(1), b);
        // Check for next character in string b with current character in string a
        int case2 = getLongestCommonSubsequence_Recursive(a, b.substring(1));
        // NOTE: The possible case3 of next character in string a and next character in string b will be covered any way in above cases
        return Math.max(case1, case2);
    }

    private static int getLongestCommonSubsequence_Memoize(String a, String b, int[][] cache) {
        int lenA = a.length();
        int lenB = b.length();

        if (cache[lenA][lenB] != -1) {
            return cache[lenA][lenB];
        }

        if (lenA == 0 || lenB == 0) {
            cache[lenA][lenB] = 0;
            return 0;
        }

        if (a.charAt(0) == b.charAt(0)) {
            cache[lenA][lenB] = 1 + getLongestCommonSubsequence_Memoize(a.substring(1), b.substring(1), cache);
            return cache[lenA][lenB];
        }

        int case1 = getLongestCommonSubsequence_Memoize(a.substring(1), b, cache);
        int case2 = getLongestCommonSubsequence_Memoize(a, b.substring(1), cache);
        cache[lenA][lenB] = Math.max(case1, case2);
        return cache[lenA][lenB];
    }

    private static int getLongestCommonSubsequence_Memoize(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int[][] cache = new int[lenA + 1][lenB + 1];

        for (int i = 0; i <= lenA; i++) {
            for (int j = 0; j <= lenB; j++) {
                cache[i][j] = -1;
            }
        }

        return getLongestCommonSubsequence_Memoize(a, b, cache);
    }

    private static int getLongestCommonSubsequence_DP(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int[][] cache = new int[lenA + 1][lenB + 1];

        for (int i = 0; i <= lenA; i++) {
            for (int j = 0; j <= lenB; j++) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 0;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    cache[i][j] = 1 + cache[i - 1][j - 1];
                } else {
                    int case1 = cache[i - 1][j];
                    int case2 = cache[i][j - 1];
                    cache[i][j] = Math.max(case1, case2);
                }
            }
        }

        return cache[lenA][lenB];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first string");
        String a = scanner.next();
        System.out.println("Enter second string");
        String b = scanner.next();

        int longestCommonSubsequence_DP = getLongestCommonSubsequence_DP(a, b);
        System.out.println(String.format("Longest Common Subsequence of '%s' and '%s' DP: %s", a, b, longestCommonSubsequence_DP));

        int longestCommonSubsequence_Memoize = getLongestCommonSubsequence_Memoize(a, b);
        System.out.println(String.format("Longest Common Subsequence of '%s' and '%s' Memoization: %s", a, b, longestCommonSubsequence_Memoize));

        // This will be very slow so for bigger strings better to comment this out
        int longestCommonSubsequence_Recursive = getLongestCommonSubsequence_Recursive(a, b);
        System.out.println(String.format("Longest Common Subsequence of '%s' and '%s' Recursively: %s", a, b, longestCommonSubsequence_Recursive));
    }
}
