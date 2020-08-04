import java.util.Scanner;

public class IsBinarySearchTree {

    private static int getMaximumFromTree(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int leftMax = getMaximumFromTree(root.left);
        int rightMax = getMaximumFromTree(root.right);

        return Math.max(root.data, Math.max(leftMax, rightMax));
    }

    private static int getMinimumFromTree(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int leftMin = getMinimumFromTree(root.left);
        int rightMin = getMinimumFromTree(root.right);

        return Math.min(root.data, Math.min(leftMin, rightMin));
    }

    private static boolean isBinarySearchTree_InEfficient(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            int leftMax = getMaximumFromTree(root.left);
            if (root.data < leftMax) {
                return false;
            }
        }

        if (root.right != null) {
            int rightMin = getMinimumFromTree(root.right);
            if (root.data > rightMin) {
                return false;
            }
        }

        return isBinarySearchTree_InEfficient(root.left) && isBinarySearchTree_InEfficient(root.right);
    }

    private static boolean isBinarySearchTree(TreeNode root, int min, int max) {

        if (root == null) {
            return true;
        }

        if (root.data < min || root.data > max) {
            return false;
        }

        return isBinarySearchTree(root.left, min, root.data - 1) && isBinarySearchTree(root.right, root.data + 1, max);
    }

    private static boolean isBinarySearchTree(TreeNode root) {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree binaryTree = new BinaryTree();
        System.out.println("Enter the Binary Tree");
        binaryTree.inputTree(scanner);

        boolean isBST = isBinarySearchTree(binaryTree.root);
        System.out.println(String.format("The tree %s a Binary Search Tree", isBST ? "IS" : "IS NOT"));
    }
}
