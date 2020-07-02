/*
 * Given an group of people P (numbers in array), in which exactly two person are singles (frequency of number is 1)
 * and all the other people are couples (number appear exactly twice). Find the two person that are singles.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SinglesInCouples {
    public static int[] getSingles(int[] P) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int p : P) {
            if (map.containsKey(p)) {
                map.put(p, 2);
            } else {
                map.put(p, 1);
            }
        }

        int[] singles = new int[2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                singles[i++] = entry.getKey();
                if (i > 1) {
                    break;
                }
            }
        }
        return singles;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of people in the group");
        int N = scanner.nextInt();
        int[] P = new int[N];

        System.out.println("Enter the value of each person");
        for (int i = 0; i < N; i++) {
            P[i] = scanner.nextInt();
        }

        int[] singles = getSingles(P);
        System.out.println(String.format("Singles in the group are %s", Arrays.toString(singles)));
    }
}
