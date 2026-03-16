// Goal: Check palindrome using singly linked list.
// Flow: Convert string to linked list, reverse second half, compare halves.
// Key Concepts: Singly Linked List, Node Traversal, Fast and Slow Pointer Technique,
//               In-Place Reversal,
//               Data Structure: Singly Linked List

public class PalindromeChecker9 {

    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        String word = "level";

        Node head = null;
        Node tail = null;
        for (int i = 0; i < word.length(); i++) {
            Node newNode = new Node(word.charAt(i));
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Fast and slow pointer: when fast reaches the end, slow points to the middle
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half in-place by iteratively updating next pointers
        Node prev = null;
        Node curr = slow;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node secondHalf = prev;

        Node first = head;
        Node second = secondHalf;
        boolean isPalindrome = true;
        while (second != null) {
            if (first.data != second.data) {
                isPalindrome = false;
                break;
            }
            first = first.next;
            second = second.next;
        }

        if (isPalindrome) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
}
