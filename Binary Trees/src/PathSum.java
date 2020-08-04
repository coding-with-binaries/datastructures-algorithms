import java.util.Scanner;

public class PathSum {
    private static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && sum - root.data == 0) {
            return true;
        }

        if (root.left != null) {
            boolean hasPath = hasPathSum(root.left, sum - root.data);
            if (hasPath) {
                return true;
            }
        }
        if (root.right != null) {
            return hasPathSum(root.right, sum - root.data);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the tree");
        BinaryTree tree = new BinaryTree();
        tree.inputTree(scanner);
        System.out.println("Enter sum to find in path");
        int sum = scanner.nextInt();
        boolean hasPath = hasPathSum(tree.root, sum);
        System.out.println(String.format("The tree %s a path with sum %s", hasPath ? "HAS" : "DOES NOT HAVE", sum));
    }
}
