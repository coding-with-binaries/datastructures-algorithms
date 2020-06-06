import java.util.*;

public class GroupAnagrams {
    private static List<List<String>> getAnagramGroups(String[] words) {
        HashMap<String, List<String>> anagramsMap = new HashMap<>();
        for (String word : words) {
            String lowerCasedWord = word.toLowerCase();
            int[] hashArray = new int[26];
            int len = word.length();
            for (int i = 0; i < len; i++) {
                char ch = lowerCasedWord.charAt(i);
                int chIndex = (ch - 'a');
                hashArray[chIndex]++;
            }
            String hashKey = Arrays.toString(hashArray);
            if (anagramsMap.containsKey(hashKey)) {
                anagramsMap.get(hashKey).add(word);
            } else {
                ArrayList<String> anagramList = new ArrayList<>();
                anagramList.add(word);
                anagramsMap.put(hashKey, anagramList);
            }
        }

        List<List<String>> anagramGroups = new ArrayList<>(anagramsMap.values());
        return anagramGroups;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of words");
        int n = scanner.nextInt();
        String[] words = new String[n];

        System.out.println("Enter words");
        for (int i = 0; i < n; i++) {
            words[i] = scanner.next();
        }

        List<List<String>> anagramGroups = getAnagramGroups(words);
        System.out.println("Grouped Anagrams are:");
        for (List<String> anagrams : anagramGroups) {
            System.out.println(anagrams.toString());
        }
    }
}
