/*
 * Author - Varun Sharma
 * Time Complexity - O(n)
 */


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
        BinaryTree tree = new BinaryTree();
        System.out.println("Input Tree");
        tree.inputTree();

        System.out.println("Leaf nodes in the Tree:");
        printLeafNodes(tree.root);
    }
}
