import java.util.HashMap;
import java.util.Scanner;

public class RansomNoteConstruction {
    private static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        int noteLength = ransomNote.length();
        int magazineLength = magazine.length();
        if (noteLength > magazineLength) {
            return false;
        }

        for (int i = 0; i < magazineLength; i++) {
            char ch = magazine.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < noteLength; i++) {
            char ch = ransomNote.charAt(i);
            if (!map.containsKey(ch)) {
                return false;
            } else {
                if (map.get(ch) <= 0) {
                    return false;
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the magazine");
        String magazine = scanner.nextLine();
        System.out.println("Enter the ransom note");
        String ransomNote = scanner.nextLine();
        boolean possible = canConstruct(ransomNote, magazine);
        System.out.printf("The ransom note %s be constructed by the magazine", possible ? "CAN" : "CANNOT");
    }
}
