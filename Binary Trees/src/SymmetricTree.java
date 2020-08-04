import java.util.Scanner;

public class SymmetricTree {
    private static boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        } else if (leftNode == null || rightNode == null) {
            return false;
        }
        if (leftNode.data != rightNode.data) {
            return false;
        }
        return isSymmetric(leftNode.left, rightNode.right) && isSymmetric(leftNode.right, rightNode.left);
    }

    private static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree binaryTree = new BinaryTree();
        System.out.println("Enter the tree");
        binaryTree.inputTree(scanner);
        boolean symmetric = isSymmetric(binaryTree.root);

        System.out.println(String.format("The entered tree %s symmetric", symmetric ? "IS" : "IS NOT"));
    }
}
