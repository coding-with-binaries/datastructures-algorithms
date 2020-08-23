import java.util.Scanner;

public class ValidPerfectSquare {
    private static boolean isPerfectSquare(int N) {
        long start = 1;
        long end = N;
        while (start <= end) {
            long mid = (start + end) / 2;
            long midSqr = mid * mid;
            if (midSqr == N) {
                return true;
            } else if (midSqr < N) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number");
        int N = scanner.nextInt();
        boolean perfectSquare = isPerfectSquare(N);
        System.out.printf("%s %s a perfect square", N, perfectSquare ? "IS" : "IS NOT");
    }
}
