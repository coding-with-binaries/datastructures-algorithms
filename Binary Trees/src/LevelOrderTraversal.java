/*
 * Author - Varun Sharma
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelOrderTraversal {

    public static void printLevelOrder(TreeNode root) {
        Queue<TreeNode> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        pendingNodes.add(null);

        while (!pendingNodes.isEmpty()) {
            TreeNode treeNode = pendingNodes.poll();
            if (treeNode == null) {
                // Null Node means level is changing
                if (!pendingNodes.isEmpty()) {
                    pendingNodes.add(null);
                    System.out.println();
                }
            } else {
                if (treeNode.left != null) {
                    pendingNodes.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    pendingNodes.add(treeNode.right);
                }
                System.out.print(treeNode.data + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        System.out.println("Input Tree");
        tree.inputTree(scanner);

        System.out.println("-----Level Order Traversal----");
        printLevelOrder(tree.root);
    }
}
