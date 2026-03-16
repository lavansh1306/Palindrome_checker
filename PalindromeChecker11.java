// UC11: Object-Oriented Palindrome Service
// Goal: Encapsulate palindrome logic in a class.
// Key Concepts: Encapsulation, Single Responsibility Principle,
//               Data Structure: Stack

import java.util.Stack;

class PalindromeChecker {
    private String word;

    public PalindromeChecker(String word) {
        this.word = word;
    }

    public boolean checkPalindrome() {
        Stack<Character> stack = new Stack<>();
        int length = word.length();
        for (int i = 0; i < length; i++) {
            stack.push(word.charAt(i));
        }
        for (int i = 0; i < length; i++) {
            if (word.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

public class PalindromeChecker11 {
    public static void main(String[] args) {
        String[] testWords = {"madam", "hello", "racecar", "world"};

        for (String word : testWords) {
            PalindromeChecker checker = new PalindromeChecker(word);
            if (checker.checkPalindrome()) {
                System.out.println(word + " is a palindrome.");
            } else {
                System.out.println(word + " is not a palindrome.");
            }
        }
    }
}
