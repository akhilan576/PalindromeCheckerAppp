public class UseCase2PalindromeCheckerApp {

    public static void main(String[] args) {
        // Hardcoded string stored as a String literal
        String word = "madam";

        System.out.println("=== UC2: Hardcoded Palindrome Check ===");
        System.out.println("Checking word: \"" + word + "\"");

        // Reverse the string and compare using equals()
        String reversed = new StringBuilder(word).reverse().toString();

        // Conditional statement to check palindrome
        if (word.equals(reversed)) {
            System.out.println("\"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + word + "\" is NOT a Palindrome.");
        }
    }
}
