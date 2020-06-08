import java.util.Scanner;

public class ReverseLinkedList {
    private static Node reverseLinkedListRecursively(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node reverseHead = reverseLinkedListRecursively(head.next);

        // When we reach here, head.next.next will always be null. So we connect head.next to its parent(i.e head)
        head.next.next = head;

        // Remove the loop which was formed here because of above action
        head.next = null;

        // New head will always be the last node
        return reverseHead;
    }

    private static Node reverseLinkedListIteratively(Node head) {
        Node reverseHead = null;
        Node pointer = head;

        while (pointer != null) {
            Node temp = pointer;
            pointer = pointer.next;
            temp.next = reverseHead;
            reverseHead = temp;
        }

        return reverseHead;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();
        list.inputLinkedList(scanner);
        System.out.println("Entered linked list is:");
        list.printLinkedList();
        list.head = reverseLinkedListRecursively(list.head);
        System.out.println("Reversing the linked list... Using Recursion");
        list.printLinkedList();

        // This will get the original list since reversing twice
        list.head = reverseLinkedListRecursively(list.head);
        System.out.println("Reversing again.. Should get back original.. Using Iterative method");
        list.printLinkedList();
    }
}
