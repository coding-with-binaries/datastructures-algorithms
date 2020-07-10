/*
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 *
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * URL: https://leetcode.com/problems/add-two-numbers/
 */

import java.util.Scanner;

public class AddTwoNumbers {
    private static Node getSumOfNumbers(Node headA, Node headB) {
        if (headA == null) {
            return headB;
        }
        if (headB == null) {
            return headA;
        }
        Node pointerA = headA;
        Node pointerB = headB;
        int sum = pointerA.data + pointerB.data;
        int carry = sum / 10;
        Node headC = new Node(sum % 10);
        Node pointerC = headC;
        while (pointerA.next != null && pointerB.next != null) {
            sum = pointerA.next.data + pointerB.next.data + carry;
            pointerC.next = new Node(sum % 10);
            carry = sum / 10;
            pointerA = pointerA.next;
            pointerB = pointerB.next;
            pointerC = pointerC.next;
        }
        while (pointerA.next != null) {
            sum = pointerA.next.data + carry;
            pointerC.next = new Node(sum % 10);
            carry = sum / 10;
            pointerA = pointerA.next;
            pointerC = pointerC.next;
        }
        while (pointerB.next != null) {
            sum = pointerB.next.data + carry;
            pointerC.next = new Node(sum % 10);
            carry = sum / 10;
            pointerB = pointerB.next;
            pointerC = pointerC.next;
        }
        if (carry != 0) {
            pointerC.next = new Node(carry);
        }
        return headC;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Linked List A");
        LinkedList A = new LinkedList();
        A.inputLinkedList(scanner);

        System.out.println("Enter Linked List B");
        LinkedList B = new LinkedList();
        B.inputLinkedList(scanner);

        Node headSum = getSumOfNumbers(A.head, B.head);
        LinkedList C = new LinkedList();
        C.head = headSum;
        C.printLinkedList();
    }
}
