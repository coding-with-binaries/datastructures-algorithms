import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DistinctCharacterSubstrings {

    private static ArrayList<String> getDistinctCharacterSubstrings(String str) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();

        int len = str.length();
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            ArrayList<Integer> firstAndLastIndex = map.get(ch);
            if (firstAndLastIndex == null) {
                firstAndLastIndex = new ArrayList<>();
                firstAndLastIndex.add(0, i);
                map.put(ch, firstAndLastIndex);
            }
            firstAndLastIndex.add(1, i);
            map.put(ch, firstAndLastIndex);
        }

        ArrayList<String> substrings = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            ArrayList<Integer> firstAndLastIndex = map.get(ch);
            int firstIndex = firstAndLastIndex.get(0);
            int lastIndex = firstAndLastIndex.get(1);

            if (firstIndex == lastIndex) {
                substrings.add(String.valueOf(ch));
            } else {
                int substringEndIndex = lastIndex;
                for (int j = i + 1; j < substringEndIndex; j++) {
                    char innerChar = str.charAt(j);
                    int innerCharLastIndex = map.get(innerChar).get(1);
                    substringEndIndex = Math.max(substringEndIndex, innerCharLastIndex);
                }
                substrings.add(str.substring(firstIndex, substringEndIndex + 1));
                i = substringEndIndex;
            }
        }

        return substrings;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        ArrayList<String> distinctSubstrings = getDistinctCharacterSubstrings(str);
        System.out.println("All substrings with distinct characters are: " + distinctSubstrings);
    }
}
