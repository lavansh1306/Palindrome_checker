// UC7: Deque-Based Optimized Palindrome Checker
// Goal: Use Deque to compare front and rear elements.
// Flow: Insert characters into deque, remove first & last, compare until empty.
// Key Concepts: Deque (Double Ended Queue), Front and Rear Access,
//               Optimized Data Handling,
//               Data Structure: Deque

import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeChecker8 {
    public static void main(String[] args) {
        String word = "racecar";

        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }

        boolean isPalindrome = true;
        while (deque.size() > 1) {
            if (deque.pollFirst() != deque.pollLast()) {
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
