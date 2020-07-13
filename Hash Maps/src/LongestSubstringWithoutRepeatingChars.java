import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubstringWithoutRepeatingChars {
    private static int getLongestSubstringWithoutRepeatingChars(String S) {
        Map<Character, Integer> map = new HashMap<>();
        int head = 0, maxLength = 0;
        for (int tail = 0; tail < S.length(); tail++) {
            char ch = S.charAt(tail);
            if (map.containsKey(ch)) {
                head = Math.max(head, map.get(ch) + 1);
            }
            map.put(ch, tail);
            int length = tail - head + 1;
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string");
        String S = scanner.nextLine();
        System.out.println(getLongestSubstringWithoutRepeatingChars(S));
    }
}
