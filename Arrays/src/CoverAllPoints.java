import java.util.Scanner;

public class CoverAllPoints {
    private static int getMinimumSteps(int[] X, int[] Y) {
        int totalPoints = X.length;

        int minSteps = 0;
        for (int i = 0; i < totalPoints - 1; i++) {
            minSteps += Math.max(Math.abs(X[i + 1] - X[i]), Math.abs(Y[i + 1] - Y[i]));
        }

        return minSteps;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter total number of points");
        int totalPoints = scanner.nextInt();
        int[] X = new int[totalPoints], Y = new int[totalPoints];

        System.out.println("Enter the points");
        for (int i = 0; i < totalPoints; i++) {
            X[i] = scanner.nextInt();
            Y[i] = scanner.nextInt();
        }

        int minSteps = getMinimumSteps(X, Y);
        System.out.println("Minimum steps to cover all points are: " + minSteps);
    }
}
