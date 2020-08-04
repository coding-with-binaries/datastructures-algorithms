/*
 * Author - Varun Sharma
 * Time Complexity - O(n)
 */


import java.util.Scanner;

public class PrintLeaves {
    public static void printLeafNodes(TreeNode root) {
        if (root == null) {
            return;
        }

        printLeafNodes(root.left);
        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
            return;
        }
        printLeafNodes(root.right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        System.out.println("Input Tree");
        tree.inputTree(scanner);

        System.out.println("Leaf nodes in the Tree:");
        printLeafNodes(tree.root);
    }
}
