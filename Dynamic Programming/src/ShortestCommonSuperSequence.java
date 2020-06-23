import java.util.Scanner;

public class ShortestCommonSuperSequence {
    private static int getShortestCommonSuperSequence_Recursive(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        if (lenA == 0) {
            return lenB;
        } else if (lenB == 0) {
            return lenA;
        }

        char firstCharA = a.charAt(0);
        char firstCharB = b.charAt(0);

        if (firstCharA == firstCharB) {
            return 1 + getShortestCommonSuperSequence_Recursive(a.substring(1), b.substring(1));
        }

        int case1 = getShortestCommonSuperSequence_Recursive(a.substring(1), b);
        int case2 = getShortestCommonSuperSequence_Recursive(a, b.substring(1));

        return 1 + Math.min(case1, case2);
    }

    private static int getShortestCommonSuperSequence_Memoization(String a, String b, int[][] cache) {
        int lenA = a.length();
        int lenB = b.length();
        if (lenA == 0) {
            return lenB;
        } else if (lenB == 0) {
            return lenA;
        }

        if (cache[lenA][lenB] != -1) {
            return cache[lenA][lenB];
        }

        char firstCharA = a.charAt(0);
        char firstCharB = b.charAt(0);

        if (firstCharA == firstCharB) {
            cache[lenA][lenB] = 1 + getShortestCommonSuperSequence_Memoization(a.substring(1), b.substring(1), cache);
            return cache[lenA][lenB];
        }

        int case1 = getShortestCommonSuperSequence_Memoization(a.substring(1), b, cache);
        int case2 = getShortestCommonSuperSequence_Memoization(a, b.substring(1), cache);

        cache[lenA][lenB] = 1 + Math.min(case1, case2);
        return cache[lenA][lenB];
    }

    private static int getShortestCommonSuperSequence_Memoization(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int[][] cache = new int[lenA + 1][lenB + 1];

        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                cache[i][j] = -1;
            }
        }

        return getShortestCommonSuperSequence_Memoization(a, b, cache);
    }

    private static int getShortestCommonSuperSequence_DP(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int[][] cache = new int[lenA + 1][lenB + 1];

        for (int i = 0; i <= lenA; i++) {
            for (int j = 0; j <= lenB; j++) {
                if (i == 0) {
                    cache[i][j] = j;
                } else if (j == 0) {
                    cache[i][j] = i;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    cache[i][j] = 1 + cache[i - 1][j - 1];
                } else {
                    int case1 = cache[i - 1][j];
                    int case2 = cache[i][j - 1];

                    cache[i][j] = 1 + Math.min(case1, case2);
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

        int shortestCommonSuperSequence_DP = getShortestCommonSuperSequence_DP(a, b);
        System.out.println(String.format("DP: Shortest Common Super Sequence of '%s' and '%s'is: %s", a, b, shortestCommonSuperSequence_DP));

        int shortestCommonSuperSequence_Memoization = getShortestCommonSuperSequence_Memoization(a, b);
        System.out.println(String.format("Memoization: Shortest Common Super Sequence of '%s' and '%s'is: %s", a, b, shortestCommonSuperSequence_Memoization));

        int shortestCommonSuperSequence_Recursion = getShortestCommonSuperSequence_Recursive(a, b);
        System.out.println(String.format("Recursion: Shortest Common Super Sequence of '%s' and '%s'is: %s", a, b, shortestCommonSuperSequence_Recursion));
    }
}
