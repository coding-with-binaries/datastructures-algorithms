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

    private static boolean isBinarySearchTree(TreeNode root) {
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

        return isBinarySearchTree(root.left) && isBinarySearchTree(root.right);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        System.out.println("Enter the Binary Tree");
        binaryTree.inputTree();

        boolean isBST = isBinarySearchTree(binaryTree.root);
        System.out.println(String.format("The tree %s a Binary Search Tree", isBST ? "IS" : "IS NOT"));
    }
}
