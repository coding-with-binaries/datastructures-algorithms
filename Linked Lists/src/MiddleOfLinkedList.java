import java.util.Scanner;

public class MiddleOfLinkedList {
    private static void printMiddleElementOfLinkedList(Node head) {
        if (head != null) {
            Node slow = head, fast = head;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            String middle;
            if (fast.next == null) {
                // This is the case with odd number of nodes
                System.out.println("Middle Element is: " + slow.data);
            } else {
                System.out.println("Middle Elements are: " + slow.data + ", " + slow.next.data);
            }
        } else {
            System.out.println("Linked List is empty.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Linked List");
        LinkedList linkedList = new LinkedList();
        linkedList.inputLinkedList(scanner);
        printMiddleElementOfLinkedList(linkedList.head);
    }
}
