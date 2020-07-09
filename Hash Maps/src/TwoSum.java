/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {
    private static int[] getIndices(int[] A, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            int n = A[i];
            int pairOfN = target - n;
            if (map.containsKey(pairOfN)) {
                int pairOfI = map.get(pairOfN);
                return new int[]{pairOfI, i};
            } else {
                map.put(n, i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter total elements in the array");
        int N = scanner.nextInt();
        System.out.println("Enter elements in the array");
        int[] A = new int[N], indices;
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println("Enter required target");
        int target = scanner.nextInt();
        indices = getIndices(A, target);
        System.out.println(String.format("Target can be formed using indices %s in the array %s", Arrays.toString(indices), Arrays.toString(A)));
    }
}
