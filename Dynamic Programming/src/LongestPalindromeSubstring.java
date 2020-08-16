import java.util.Scanner;

public class LongestPalindromeSubstring {
    private static String getLongestPalindromeSubstring_Recursive(String S, int start, int end, String prefix, String suffix) {
        if (start > end) {
            return prefix + suffix;
        }

        if (start == end) {
            return prefix + S.charAt(start) + suffix;
        }

        String case1 = getLongestPalindromeSubstring_Recursive(S, start + 1, end, "", "");
        String case2 = getLongestPalindromeSubstring_Recursive(S, start, end - 1, "", "");
        String case3 = "";
        char chFirst = S.charAt(start);
        char chLast = S.charAt(end);
        if (chFirst == chLast) {
            case3 = getLongestPalindromeSubstring_Recursive(S, start + 1, end - 1, prefix + chFirst, chFirst + suffix);
        }
        if (case1.length() > case2.length() && case1.length() > case3.length()) {
            return case1;
        }
        if (case2.length() > case3.length() && case2.length() > case1.length()) {
            return case2;
        }
        return case3;
    }

    private static String getLongestPalindromeSubstring_Recursive(String S) {
        return getLongestPalindromeSubstring_Recursive(S, 0, S.length() - 1, "", "");
    }

    private static String getLongestPalindromeSubstring_Memoize(String S, int start, int end, String prefix, String suffix, String[][] cache) {
        if (cache[start][end] != null) {
            return prefix + cache[start][end] + suffix;
        }
        if (start > end) {
            cache[start][end] = prefix + suffix;
            return cache[start][end];
        }

        if (start == end) {
            cache[start][end] = prefix + S.charAt(start) + suffix;
            return cache[start][end];
        }

        String case1 = getLongestPalindromeSubstring_Memoize(S, start + 1, end, "", "", cache);
        String case2 = getLongestPalindromeSubstring_Memoize(S, start, end - 1, "", "", cache);
        String case3 = "";
        char chFirst = S.charAt(start);
        char chLast = S.charAt(end);
        if (chFirst == chLast) {
            case3 = getLongestPalindromeSubstring_Memoize(S, start + 1, end - 1, prefix + chFirst, chFirst + suffix, cache);
        }
        if (case1.length() > case2.length() && case1.length() > case3.length()) {
            cache[start][end] = case1;
            return case1;
        }
        if (case2.length() > case3.length() && case2.length() > case1.length()) {
            cache[start][end] = case2;
            return case2;
        }
        cache[start][end] = case3;
        return case3;
    }

    private static String getLongestPalindromeSubstring_Memoize(String S) {
        int len = S.length();
        String[][] cache = new String[len][len];
        return getLongestPalindromeSubstring_Memoize(S, 0, S.length() - 1, "", "", cache);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string");
        String S = scanner.nextLine();

        String longestPalindrome_Memoized = getLongestPalindromeSubstring_Memoize(S);
        System.out.printf("Longest Palindrome Substring of '%s' Memoized: %s%n", S, longestPalindrome_Memoized);

        String longestPalindrome_Recursive = getLongestPalindromeSubstring_Recursive(S);
        System.out.printf("Longest Palindrome Substring of '%s' Recursively: %s%n", S, longestPalindrome_Recursive);
    }
}
