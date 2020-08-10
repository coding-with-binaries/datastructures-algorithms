import java.util.HashSet;
import java.util.Scanner;

public class FirstMissingPositive {
    private static int getFirstMissingPositive(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        int len = A.length;
        for (int i = 0; i < len; i++) {
            set.add(A[i]);
        }
        int i = 1;
        while (true) {
            if (!set.contains(i)) {
                return i;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter total numbers in the array");
        int N = scanner.nextInt();
        int[] A = new int[N];

        System.out.println("Enter the numbers");
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        int firstMissingPositive = getFirstMissingPositive(A);
        System.out.println("First missing positive number is: " + firstMissingPositive);
    }
}
