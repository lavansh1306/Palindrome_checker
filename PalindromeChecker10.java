// Goal: Check palindrome using recursion.
// Flow: Recursive call compares start & end characters, base condition exits recursion.
// Key Concepts: Recursion, Base Condition, Call Stack,
//               Data Structure: Call Stack

public class PalindromeChecker10 {

    static boolean isPalindrome(String word, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (word.charAt(start) != word.charAt(end)) {
            return false;
        }
        return isPalindrome(word, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String word = "noon";

        boolean result = isPalindrome(word, 0, word.length() - 1);

        if (result) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
}
