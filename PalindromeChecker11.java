// Goal: Ignore spaces and case while checking a palindrome.
// Flow: Normalize string (remove non-alphanumeric, convert to lowercase), apply palindrome logic.
// Key Concepts: String pre-processing, Regular expressions,
//               Data Structure: String / Array

public class PalindromeChecker11 {
    public static void main(String[] args) {
        String word = "A man a plan a canal Panama";

        String normalized = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = normalized.length() - 1;
        boolean isPalindrome = true;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        if (isPalindrome) {
            System.out.println("\"" + word + "\" is a palindrome.");
        } else {
            System.out.println("\"" + word + "\" is not a palindrome.");
        }
    }
}
