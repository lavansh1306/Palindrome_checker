// UC12: Strategy Pattern for Palindrome Algorithms (Advanced)
// Goal: Choose a palindrome algorithm dynamically.
// Key Concepts: Interface, Polymorphism, Strategy Pattern,
//               Data Structure: Varies per strategy

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

interface PalindromeStrategy {
    boolean isPalindrome(String word);
}

class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String word) {
        Stack<Character> stack = new Stack<>();
        for (char c : word.toCharArray()) {
            stack.push(c);
        }
        for (char c : word.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String word) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : word.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (deque.pollFirst() != deque.pollLast()) {
                return false;
            }
        }
        return true;
    }
}

class PalindromeContext {
    private PalindromeStrategy strategy;

    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String word) {
        return strategy.isPalindrome(word);
    }
}

public class PalindromeChecker12 {
    public static void main(String[] args) {
        String[] testWords = {"racecar", "hello", "level", "world"};

        PalindromeContext context = new PalindromeContext(new StackStrategy());
        System.out.println("--- StackStrategy ---");
        for (String word : testWords) {
            System.out.println(word + " is palindrome: " + context.check(word));
        }

        context.setStrategy(new DequeStrategy());
        System.out.println("--- DequeStrategy ---");
        for (String word : testWords) {
            System.out.println(word + " is palindrome: " + context.check(word));
        }
    }
}
