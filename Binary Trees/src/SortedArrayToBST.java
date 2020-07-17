import java.util.Scanner;

public class SortedArrayToBST {
    private static TreeNode getBSTFromSortedArray(int[] A, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = (lo + hi) / 2;
        int rootData = A[mid];
        TreeNode root = new TreeNode(rootData);
        root.left = getBSTFromSortedArray(A, lo, mid - 1);
        root.right = getBSTFromSortedArray(A, mid + 1, hi);
        return root;
    }

    private static BinaryTree getBSTFromSortedArray(int[] A) {
        BinaryTree binarySearchTree = new BinaryTree();
        binarySearchTree.root = getBSTFromSortedArray(A, 0, A.length - 1);
        return binarySearchTree;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of array");
        int N = scanner.nextInt();
        int[] A = new int[N];
        System.out.println("Enter the elements of array");
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        BinaryTree binarySearchTree = getBSTFromSortedArray(A);
        System.out.println("Level Order Traversal of BST:");
        LevelOrderTraversal.printLevelOrder(binarySearchTree.root);
    }
}
