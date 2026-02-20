// Goal: Check whether a string is a palindrome by reversing it.
// Key Concepts: Loop (for loop), String Immutability, String Concatenation (+),
//               equals() Method, Data Structure: String

public class PalindromeChecker2 {
    public static void main(String[] args) {
        String word = "racecar";
        String reversed = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }

        if (word.equals(reversed)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
}
