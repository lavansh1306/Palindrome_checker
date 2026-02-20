// Goal: Convert string to character array and compare characters.
// Key Concepts: Character Array (char[]), Array Indexing, Two-Pointer Technique,
//               Time Complexity Awareness, Data Structure: char[]

public class PalindromeChecker3 {
    public static void main(String[] args) {
        String word = "level";
        char[] chars = word.toCharArray();

        int left = 0;
        int right = chars.length - 1;
        boolean isPalindrome = true;

        while (left < right) {
            if (chars[left] != chars[right]) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        if (isPalindrome) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
}
