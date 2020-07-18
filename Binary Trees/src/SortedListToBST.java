import java.awt.*;
import java.util.Scanner;

public class SortedListToBST {
    private static ListNode headPointer;

    private static int countListNodes(ListNode head) {
        int count = 0;
        ListNode pointer = head;
        while (pointer != null) {
            pointer = pointer.next;
            count++;
        }
        return count;
    }

    private static TreeNode getBSTFromSortedList(int n) {
        if (n <= 0) {
            return null;
        }

        TreeNode left = getBSTFromSortedList(n / 2);

        TreeNode root = new TreeNode(headPointer.data);

        root.left = left;
        headPointer = headPointer.next;

        TreeNode right = getBSTFromSortedList(n - n / 2 - 1);
        root.right = right;

        return root;
    }

    private static TreeNode getBSTFromSortedList(ListNode head) {
        int n = countListNodes(head);
        headPointer = head;
        return getBSTFromSortedList(n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements to add");
        int n = scanner.nextInt();
        ListNode head = null;
        if (n > 0) {
            System.out.println("Enter the data of the nodes");
            head = new ListNode(scanner.nextInt());
            ListNode pointer = head;
            for (int i = 1; i < n; i++) {
                pointer.next = new ListNode(scanner.nextInt());
                pointer = pointer.next;
            }
        }

        TreeNode root = getBSTFromSortedList(head);
        LevelOrderTraversal.printLevelOrder(root);
    }
}
