// Goal: Use stack to reverse characters and validate palindrome.
// Key Concepts: Stack, Push Operation, Pop Operation, Reversal Logic,
//               Data Structure: Stack

import java.util.Stack;

public class PalindromeChecker4 {
    public static void main(String[] args) {
        String word = "noon";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        boolean isPalindrome = true;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != stack.pop()) {
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
