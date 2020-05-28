/*
 * Author - Varun Sharma
 * Time Complexity - O(n)
 */


public class BoundaryTraversal {
    private static void printLeftBoundary(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            // Printing first as we have to print top-down
            System.out.print(root.data + " ");
            printLeftBoundary(root.left);
        } else if (root.right != null) {
            System.out.print(root.data + " ");
            printLeftBoundary(root.right);
        }
        // We won't check if both left and right is null as that is leaf node
    }

    private static void printRightReverseBoundary(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.right != null) {
            printRightReverseBoundary(root.right);
            // Printing at the end as we have to print bottom-up
            System.out.print(root.data + " ");
        } else if (root.left != null) {
            printRightReverseBoundary(root.left);
            System.out.print(root.data + " ");
        }
        // We won't check if both left and right is null as that is leaf node
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        System.out.println("Input Tree");
        tree.inputTree();

        System.out.println("----Boundary Traversal----");
        if (tree.root != null) {
            System.out.print(tree.root.data + " ");
            printLeftBoundary(tree.root.left);
            PrintLeaves.printLeafNodes(tree.root);
            printRightReverseBoundary(tree.root.right);
        } else {
            System.out.println("Tree has no nodes");
        }
    }
}
