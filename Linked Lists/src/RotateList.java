import java.util.Scanner;

public class RotateList {
    private static Node getRotatedList(Node head, int k) {
        if (head == null) {
            return null;
        }
        int len = 1;
        Node pointer = head;
        while (pointer.next != null) {
            len++;
            pointer = pointer.next;
        }
        Node tail = pointer;
        int effectiveK = k % len;
        if (effectiveK == 0) {
            return head;
        }
        pointer = head;
        for (int i = 1; i < len - effectiveK; i++) {
            pointer = pointer.next;
        }
        Node newHead = pointer.next;
        pointer.next = null;
        tail.next = head;

        return newHead;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the linked list:");
        LinkedList linkedList = new LinkedList();
        linkedList.inputLinkedList(scanner);
        System.out.println("Entered List is:");
        linkedList.printLinkedList();

        System.out.println("Enter the value of K");
        int k = scanner.nextInt();

        Node rotatedHead = getRotatedList(linkedList.head, k);
        LinkedList rotatedList = new LinkedList();
        rotatedList.head = rotatedHead;

        System.out.println("Rotated List is:");
        rotatedList.printLinkedList();
    }
}
