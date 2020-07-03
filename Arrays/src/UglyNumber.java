import java.util.Arrays;
import java.util.Scanner;

/*
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 */
public class UglyNumber {
    private static int[] getFirstNUglyNumbers(int N) {
        int[] ugly = new int[N];
        ugly[0] = 1;
        int A = 0, B = 0, C = 0;
        for (int i = 1; i < N; i++) {
            ugly[i] = Math.min(Math.min(ugly[A] * 2, ugly[B] * 3), ugly[C] * 5);
            if (ugly[i] == ugly[A] * 2) {
                A++;
            }
            if (ugly[i] == ugly[B] * 3) {
                B++;
            }
            if (ugly[i] == ugly[C] * 5) {
                C++;
            }
        }
        return ugly;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value of N");
        int N = scanner.nextInt();

        int[] ugly = getFirstNUglyNumbers(N);
        System.out.println(String.format("First %s Ugly Numbers are: %s", N, Arrays.toString(ugly)));
    }
}
