import java.util.Scanner;

public class DetectLoop {
    private static boolean hasLoop(Node head) {
        if (head == null || head.next == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;
        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Circular List:");
        LinkedList listWithLoop = new LinkedList();
        listWithLoop.inputCircularLinkedList(scanner);

        boolean hasLoop = hasLoop(listWithLoop.head);
        System.out.println("Loop Detected: " + hasLoop);

        System.out.println("Enter Regular List:");
        LinkedList listWithoutLoop = new LinkedList();
        listWithoutLoop.inputLinkedList(scanner);

        hasLoop = hasLoop(listWithoutLoop.head);
        System.out.println("Loop Detected: " + hasLoop);
    }
}
