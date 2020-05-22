import java.util.Scanner;

public class MinEditDistance {
    private static int getMinEditDistance_Recursive(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        if (lenA == 0) {
            return lenB;
        }

        if (lenB == 0) {
            return lenA;
        }

        if (a.charAt(0) == b.charAt(0)) {
            return getMinEditDistance_Recursive(a.substring(1), b.substring(1));
        }

        // Replace 0th character in string a
        int case1 = getMinEditDistance_Recursive(a.substring(1), b.substring(1));
        // Inserted 1 character in string a. Thus a remains same because a new character was appended to match 0th character in b
        int case2 = getMinEditDistance_Recursive(a, b.substring(1));
        // Deleted 0th character from string a. Thus need to substring a from 1st index to match the string b
        int case3 = getMinEditDistance_Recursive(a.substring(1), b);
        return 1 + Math.min(Math.min(case1, case2), case3);
    }

    private static int getMinEditDistance_Memoize(String a, String b, int[][] cache) {
        int lenA = a.length();
        int lenB = b.length();
        if (cache[lenA][lenB] != 0) {
            return cache[lenA][lenB];
        }

        if (lenA == 0) {
            cache[0][lenB] = lenB;
            return lenB;
        }

        if (lenB == 0) {
            cache[lenA][0] = lenA;
            return lenA;
        }

        if (a.charAt(0) == b.charAt(0)) {
            cache[lenA][lenB] = getMinEditDistance_Memoize(a.substring(1), b.substring(1), cache);
            return cache[lenA][lenB];
        }

        int case1 = getMinEditDistance_Memoize(a.substring(1), b.substring(1), cache);
        int case2 = getMinEditDistance_Memoize(a, b.substring(1), cache);
        int case3 = getMinEditDistance_Memoize(a.substring(1), b, cache);
        cache[lenA][lenB] = 1 + Math.min(Math.min(case1, case2), case3);
        return cache[lenA][lenB];
    }


    private static int getMinEditDistance_Memoize(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int[][] cache = new int[lenA + 1][lenB + 1];

        return getMinEditDistance_Memoize(a, b, cache);
    }

    private static int getMinEditDistance_DP(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int[][] cache = new int[lenA + 1][lenB + 1];

        for (int i = 0; i <= lenA; i++) {
            for (int j = 0; j <= lenB; j++) {
                if (i == 0) {
                    cache[0][j] = j;
                } else if (j == 0) {
                    cache[i][0] = i;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    cache[i][j] = cache[i - 1][j - 1];
                } else {
                    // Replace
                    int case1 = cache[i - 1][j - 1];
                    // Insert
                    int case2 = cache[i][j - 1];
                    // Delete
                    int case3 = cache[i - 1][j];
                    cache[i][j] = 1 + Math.min(Math.min(case1, case2), case3);
                }
            }
        }

        return cache[lenA][lenB];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first string");
        String a = scanner.nextLine();
        System.out.println("Enter second string");
        String b = scanner.nextLine();

        int minEditDistance_DP = getMinEditDistance_DP(a, b);
        System.out.println(String.format("Minimum edit distance of '%s' and '%s' DP: %s", a, b, minEditDistance_DP));

        int minEditDistance_Memoize = getMinEditDistance_Memoize(a, b);
        System.out.println(String.format("Minimum edit distance of '%s' and '%s' Memoization: %s", a, b, minEditDistance_Memoize));

        // This will be very slow so for bigger strings better to comment this out
        int minEditDistance_Recursive = getMinEditDistance_Recursive(a, b);
        System.out.println(String.format("Minimum edit distance of '%s' and '%s' Recursively: %s", a, b, minEditDistance_Recursive));
    }
}
