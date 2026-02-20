// Goal: Display whether a hardcoded string is a palindrome.
// Key Concepts: Class, Main Method, Static Keyword, String, String Literal,
//               Conditional Statement (if-else), Console Output

public class PalindromeChecker2 {
    public static void main(String[] args) {
        String word = "madam";
        String reversed = new StringBuilder(word).reverse().toString();

        if (word.equals(reversed)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
}
