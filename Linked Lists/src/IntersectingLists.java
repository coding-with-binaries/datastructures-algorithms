import java.util.Scanner;

public class IntersectingLists {
    private static Node getIntersectionNode(LinkedList A, LinkedList B) {
        int sizeOfA = A.getSize();
        int sizeOfB = B.getSize();

        LinkedList bigger;
        LinkedList smaller;
        int diff = Math.abs(sizeOfA - sizeOfB);
        if (sizeOfA > sizeOfB) {
            bigger = A;
            smaller = B;
        } else {
            smaller = A;
            bigger = B;
        }

        Node pointerSmall = smaller.head;
        Node pointerBig = bigger.head;

        for (int i = 0; i < diff; i++) {
            pointerBig = pointerBig.next;
        }

        while (pointerBig != null || pointerSmall != null) {
            if (pointerBig == pointerSmall) {
                return pointerBig;
            }
            pointerBig = pointerBig.next;
            pointerSmall = pointerSmall.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first list");
        LinkedList A = new LinkedList();
        A.inputLinkedList(scanner);
        System.out.println("List A:");
        A.printLinkedList();
        int sizeOfA = A.getSize();

        System.out.println("Enter second list");
        LinkedList B = new LinkedList();
        B.inputLinkedList(scanner);
        System.out.println("List B:");
        B.printLinkedList();

        System.out.println("Enter index of intersection node in List A");
        int intersectionIndex = scanner.nextInt();

        if (intersectionIndex < sizeOfA) {
            Node tailOfB = B.getTail();
            Node pointer = A.head;
            for (int i = 0; i < intersectionIndex; i++) {
                pointer = pointer.next;
            }
            tailOfB.next = pointer;

            Node intersectionNode = getIntersectionNode(A, B);
            System.out.println("Intersection Node Value: " + intersectionNode.data);
        }
    }
}
