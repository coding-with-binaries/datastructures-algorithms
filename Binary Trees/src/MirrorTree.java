import java.util.Scanner;

public class MirrorTree {
    private static void getMirrorTree(TreeNode root) {
        if (root == null) {
            return;
        }

        getMirrorTree(root.left);
        getMirrorTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.inputTree(scanner);
        System.out.println("Input Tree is:");
        LevelOrderTraversal.printLevelOrder(tree.root);
        getMirrorTree(tree.root);
        System.out.println("Mirror Tree is:");
        LevelOrderTraversal.printLevelOrder(tree.root);
    }
}
