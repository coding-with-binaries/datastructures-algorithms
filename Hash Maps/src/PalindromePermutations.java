import java.util.HashMap;
import java.util.Scanner;

public class PalindromePermutations {
    /**
     *
     * @param s The string to check for palindrome permutations
     * @return true if string has palindrome permutations
     */
    private static boolean hasPalindromePermutations(String s) {
        s = String.join("",s.split(" "));
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        int oddOccurrences = 0;
        for (Integer value : map.values()) {
            if (len % 2 == 0 && value % 2 != 0) {
                return false;
            }
            if (len % 2 != 0 && value % 2 != 0) {
                oddOccurrences++;
                if (oddOccurrences > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string to check for palindrome permutations");
        String s = scanner.nextLine();
        boolean hasPalindromePermutations = hasPalindromePermutations(s);
        System.out.println(String.format("The string '%s' %s palindrome permutations", s, hasPalindromePermutations ? "HAS" : "DOES NOT HAVE"));
    }
}
