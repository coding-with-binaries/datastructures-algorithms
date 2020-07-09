import java.util.Scanner;

public class FactorialTrailingZeroes {
    private static int getFactorialTrailingZeroes(int N) {
        int trailingZeroes = 0;
        /*
         * Trailing zeroes can only be result of getting a 10 while creating factorial
         * 10 has only 2 prime factors - 2 & 5
         * Now since 5 will be lesser that 2 when a number is broken down to power of prime factors,
         * We only need to find the power of 5.
         */
        while (N >= 5) {
            trailingZeroes += N / 5;
            N = N / 5;
        }
        return trailingZeroes;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number");
        int N = scanner.nextInt();
        int trailingZeroes = getFactorialTrailingZeroes(N);
        System.out.println(String.format("Trailing zeroes in %s! %s: %s", N, trailingZeroes > 1 ? "are" : "is", trailingZeroes));
    }
}
