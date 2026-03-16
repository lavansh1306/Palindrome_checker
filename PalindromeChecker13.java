// UC13: Performance Comparison
// Goal: Compare the performance of different palindrome approaches.
// Key Concepts: System.nanoTime(), Algorithm comparison

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class PalindromeChecker13 {

    static boolean stackApproach(String word) {
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

    static boolean dequeApproach(String word) {
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

    static boolean stringBuilderApproach(String word) {
        String reversed = new StringBuilder(word).reverse().toString();
        return word.equals(reversed);
    }

    static boolean charArrayApproach(String word) {
        char[] chars = word.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String word = "racecar";
        int iterations = 100000;
        long startTime, endTime;

        // Warm-up phase to allow JIT compilation
        for (int i = 0; i < 10000; i++) {
            stackApproach(word);
            dequeApproach(word);
            stringBuilderApproach(word);
            charArrayApproach(word);
        }

        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) stackApproach(word);
        endTime = System.nanoTime();
        System.out.println("Stack Approach:         " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) dequeApproach(word);
        endTime = System.nanoTime();
        System.out.println("Deque Approach:         " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) stringBuilderApproach(word);
        endTime = System.nanoTime();
        System.out.println("StringBuilder Approach: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) charArrayApproach(word);
        endTime = System.nanoTime();
        System.out.println("Char Array Approach:    " + (endTime - startTime) + " ns");
    }
}
