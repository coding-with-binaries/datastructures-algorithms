import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class WordBreak {
    private static boolean isWordBreakPossible_Recursive(String s, HashSet<String> words) {
        int len = s.length();
        if (len == 0) {
            return true;
        }

        for (int i = 1; i <= len; i++) {
            String prefix = s.substring(0, i);
            if (words.contains(prefix) && isWordBreakPossible_Recursive(s.substring(i), words)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isWordBreakPossible_Recursive(String s, String[] words) {
        HashSet<String> wordsSet = new HashSet<>();
        Collections.addAll(wordsSet, words);
        return isWordBreakPossible_Recursive(s, wordsSet);
    }

    private static boolean isWordBreakPossible_Memoize(String s, HashSet<String> words, int[] cache) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        if (cache[len] != 0) {
            return cache[len] == 1;
        }

        cache[len] = -1;
        for (int i = 1; i <= len; i++) {
            String prefix = s.substring(0, i);
            if (words.contains(prefix)) {
                cache[len] = isWordBreakPossible_Memoize(s.substring(i), words, cache) ? 1 : -1;
                if (cache[len] == 1) {
                    break;
                }
            }
        }
        return cache[len] == 1;
    }

    private static boolean isWordBreakPossible_Memoize(String s, String[] words) {
        int len = s.length();
        int[] cache = new int[len + 1];
        cache[0] = 1;
        HashSet<String> wordsSet = new HashSet<>();
        Collections.addAll(wordsSet, words);
        return isWordBreakPossible_Memoize(s, wordsSet, cache);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of words in dictionary");
        int totalWords = scanner.nextInt();
        String[] words = new String[totalWords];

        System.out.println("Enter each word in the dictionary");
        for (int i = 0; i < totalWords; i++) {
            words[i] = scanner.next();
        }

        System.out.println("Enter the string to be broken");
        String s = scanner.next();

        boolean isBreakPossible_Memoization = isWordBreakPossible_Memoize(s, words);
        System.out.println("Memoization: Word Break is " + (isBreakPossible_Memoization ? "POSSIBLE" : "NOT POSSIBLE"));

        boolean isBreakPossible_Recursion = isWordBreakPossible_Recursive(s, words);
        System.out.println("Recursion: Word Break is " + (isBreakPossible_Recursion ? "POSSIBLE" : "NOT POSSIBLE"));
    }
}
