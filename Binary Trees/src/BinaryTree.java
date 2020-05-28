import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
        this.left = null;
        this.right = null;
    }

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    TreeNode root;

    public void inputTree() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter root node");
        int rootData = scanner.nextInt();
        root = new TreeNode(rootData);
        Queue<TreeNode> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        while (!pendingNodes.isEmpty()) {
            TreeNode treeNode = pendingNodes.poll();
            System.out.println("Enter left child of node: " + treeNode.data);
            int leftData = scanner.nextInt();
            if (leftData != -1) {
                treeNode.left = new TreeNode(leftData);
                pendingNodes.add(treeNode.left);
            }
            System.out.println("Enter right child of node: " + treeNode.data);
            int rightData = scanner.nextInt();
            if (rightData != -1) {
                treeNode.right = new TreeNode(rightData);
                pendingNodes.add(treeNode.right);
            }
        }
    }
}