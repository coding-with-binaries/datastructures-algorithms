/*
 * Author - Varun Sharma
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */


import java.util.Stack;

public class ZigZagTraversal {
    private static void printZigZagOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> evenPendingNodes = new Stack<>();
        Stack<TreeNode> oddPendingNodes = new Stack<>();

        evenPendingNodes.push(root);
        boolean evenLevel = true; // Level starts from 0
        while (!evenPendingNodes.isEmpty() || !oddPendingNodes.isEmpty()) {
            Stack<TreeNode> currentStack = evenLevel ? evenPendingNodes : oddPendingNodes;
            TreeNode treeNode = currentStack.pop();

            if (evenLevel) {
                if (treeNode.left != null) {
                    oddPendingNodes.push(treeNode.left);
                }
                if (treeNode.right != null) {
                    oddPendingNodes.push(treeNode.right);
                }
            } else {
                if (treeNode.right != null) {
                    evenPendingNodes.push(treeNode.right);
                }
                if (treeNode.left != null) {
                    evenPendingNodes.push(treeNode.left);
                }
            }
            System.out.print(treeNode.data + " ");
            if (currentStack.isEmpty()) {
                evenLevel = !evenLevel;
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        System.out.println("Input Tree");
        tree.inputTree();

        System.out.println("-----Level Order Traversal----");
        printZigZagOrder(tree.root);
    }
}
