import java.util.HashMap;
import java.util.Scanner;

public class ValidAnagrams {
    private static boolean isAnagram(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        if (lenA != lenB) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < lenA; i++) {
            char chA = a.charAt(i);
            map.put(chA, map.getOrDefault(chA, 0) + 1);
        }

        for (int i = 0; i < lenA; i++) {
            char chB = b.charAt(i);
            map.put(chB, map.getOrDefault(chB, 1) - 1);
            if (map.get(chB) == 0) {
                map.remove(chB);
            }
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the two strings");
        String a = scanner.next();
        String b = scanner.next();
        boolean anagram = isAnagram(a, b);
        System.out.printf("The strings %s anagrams", anagram ? "ARE" : "ARE NOT");
    }
}
