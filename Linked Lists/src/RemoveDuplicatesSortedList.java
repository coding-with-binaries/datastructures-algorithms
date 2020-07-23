import java.util.Scanner;

public class RemoveDuplicatesSortedList {
    private static Node removeDuplicates(Node head) {
        if (head == null) {
            return null;
        }
        Node pointer = head;

        while (pointer.next != null) {
            if (pointer.data == pointer.next.data) {
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();
        linkedList.inputLinkedList(scanner);
        System.out.println("The entered linked list is:");
        linkedList.printLinkedList();
        Node alteredHead = removeDuplicates(linkedList.head);
        LinkedList alteredList = new LinkedList();
        alteredList.head = alteredHead;
        System.out.println("The linked list after removing duplicates is:");
        alteredList.printLinkedList();
    }
}
