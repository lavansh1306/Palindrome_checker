// Goal: Demonstrate FIFO vs LIFO using Queue and Stack.
// Flow: Enqueue characters, push characters to stack, compare dequeue vs pop.
// Key Concepts: Queue (FIFO), Stack (LIFO), Enqueue & Dequeue Operations,
//               Stack vs Queue behavioural difference, Logical Comparison,
//               Data Structures: Queue, Stack

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeChecker7 {
    public static void main(String[] args) {
        String word = "madam";

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < word.length(); i++) {
            queue.offer(word.charAt(i));
            stack.push(word.charAt(i));
        }

        boolean isPalindrome = true;
        while (!queue.isEmpty()) {
            if (queue.poll() != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
}
