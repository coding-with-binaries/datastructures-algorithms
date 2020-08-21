import java.util.HashMap;
import java.util.Scanner;

public class IsomorphicStrings {
    private static boolean isIsomorphic(String a, String b) {
        HashMap<Character, Character> map = new HashMap<>();
        int lenA = a.length();
        int lenB = b.length();
        if (lenA != lenB) {
            return false;
        }

        for (int i = 0; i < lenA; i++) {
            char chA = a.charAt(i);
            char chB = b.charAt(i);
            if (map.containsKey(chA) && map.get(chA) != chB) {
                return false;
            }
            if (!map.containsKey(chA)) {
                if (map.containsValue(chB)) {
                    return false;
                }
                map.put(chA, chB);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the two strings");
        String a = scanner.next();
        String b = scanner.next();
        boolean isomorphic = isIsomorphic(a, b);
        System.out.printf("The strings %s isomorphic", isomorphic ? "ARE" : "ARE NOT");
    }
}
