import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

public class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void inputLinkedList() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements to add");
        int n = scanner.nextInt();
        if (n > 0) {
            System.out.println("Enter the data of the nodes");
            head = new Node(scanner.nextInt());
            Node pointer = head;
            for (int i = 1; i < n; i++) {
                pointer.next = new Node(scanner.nextInt());
                pointer = pointer.next;
            }
        }
    }

    public void inputCircularLinkedList() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements to add");
        int n = scanner.nextInt();
        if (n > 0) {
            System.out.println("Enter the data of the nodes");
            head = new Node(scanner.nextInt());
            Node pointer = head;
            for (int i = 1; i < n; i++) {
                pointer.next = new Node(scanner.nextInt());
                pointer = pointer.next;
            }
            pointer.next = head;
        }
    }

    public void printLinkedList() {
        Node pointer = head;
        while (pointer != null) {
            System.out.print(pointer.data + " -> ");
            pointer = pointer.next;
        }
        System.out.println("NULL");
    }
}
