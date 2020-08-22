import java.util.HashMap;
import java.util.Scanner;

public class WordPattern {
    private static boolean hasWordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        String[] words = str.split(" ");
        int totalWords = words.length;
        int totalChars = pattern.length();

        if (totalChars != totalWords) {
            return false;
        }

        for (int i = 0; i < totalChars; i++) {
            char ch = pattern.charAt(i);
            if (map.containsKey(ch) && !map.get(ch).equals(words[i])) {
                return false;
            }
            if (!map.containsKey(ch)) {
                if (map.containsValue(words[i])) {
                    return false;
                }
                map.put(ch, words[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the pattern");
        String pattern = scanner.nextLine();
        System.out.println("Enter the string");
        String str = scanner.nextLine();
        boolean wordPattern = hasWordPattern(pattern, str);
        System.out.printf("The string %s pattern of the word", wordPattern ? "HAS" : "DOES NOT HAVE");
    }
}
