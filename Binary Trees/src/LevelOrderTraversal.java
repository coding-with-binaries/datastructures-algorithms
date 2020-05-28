/*
 * Author - Varun Sharma
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */


import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    private static void printLevelOrder(TreeNode root) {
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
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        System.out.println("Input Tree");
        tree.inputTree();

        System.out.println("-----Level Order Traversal----");
        printLevelOrder(tree.root);
    }
}
