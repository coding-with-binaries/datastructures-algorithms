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
    private int size = -1;
    private Node tail;

    public LinkedList() {
        this.head = null;
    }

    public void inputLinkedList(Scanner scanner) {
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

    public void inputCircularLinkedList(Scanner scanner) {
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

    public Node getTail() {
        if (tail != null) {
            return this.tail;
        }

        if (head == null) {
            return null;
        }

        Node pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        tail = pointer;
        return tail;
    }

    public int getSize() {
        if (this.size != -1) {
            return this.size;
        }
        Node pointer = head;
        int size = 0;
        while (pointer != null) {
            size++;
            pointer = pointer.next;
        }
        this.size = size;
        return this.size;
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
