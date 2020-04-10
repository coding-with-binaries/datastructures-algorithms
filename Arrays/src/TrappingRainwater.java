import java.util.Scanner;

public class TrappingRainwater {

    private static int calculateTrappedWater(int H[]) {
        int N = H.length;
        int leftMax = H[0];
        int rightMax = H[N - 1];
        int totalWater = 0;

        int left = 0;
        int right = N - 1;

        while (left <= right) {
            if (leftMax < rightMax) {
                if (H[left] < leftMax) {
                    totalWater += leftMax - H[left];
                } else {
                    leftMax = H[left];
                }
                left++;
            } else {
                if (H[right] < rightMax) {
                    totalWater += rightMax - H[right];
                } else {
                    rightMax = H[right];
                }
                right--;
            }
        }
        return totalWater;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of buildings");
        int N = scanner.nextInt();
        System.out.println("Enter heights of buildings");
        int H[] = new int[N];
        for (int i = 0; i < N; i++) {
            H[i] = scanner.nextInt();
        }
        int trappedWater = calculateTrappedWater(H);
        System.out.println("Total trapped water: " + trappedWater);
    }
}
