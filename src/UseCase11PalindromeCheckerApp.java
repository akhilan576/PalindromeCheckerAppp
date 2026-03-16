import java.util.Scanner;

// PalindromeChecker class - Encapsulates all palindrome logic
// Single Responsibility Principle: This class only handles palindrome checking
class PalindromeChecker {

    private String original;
    private String normalized;

    // Constructor
    public PalindromeChecker(String input) {
        this.original   = input;
        this.normalized = normalize(input);
    }

    // Normalize: remove spaces and convert to lowercase
    private String normalize(String str) {
        return str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    // Core palindrome check using two-pointer (char array internally)
    public boolean checkPalindrome() {
        char[] charArray = normalized.toCharArray();
        int start = 0;
        int end   = charArray.length - 1;

        while (start < end) {
            if (charArray[start] != charArray[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Getter for original string
    public String getOriginal() {
        return original;
    }

    // Getter for normalized string
    public String getNormalized() {
        return normalized;
    }

    // Display result
    public void printResult() {
        System.out.println("Original String  : \"" + original + "\"");
        System.out.println("Normalized String: \"" + normalized + "\"");
        if (checkPalindrome()) {
            System.out.println("Result: \"" + original + "\" is a Palindrome.");
        } else {
            System.out.println("Result: \"" + original + "\" is NOT a Palindrome.");
        }
    }
}

// Main application class
public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC11: Object-Oriented Palindrome Service ===");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        // Create PalindromeChecker object and call checkPalindrome()
        PalindromeChecker checker = new PalindromeChecker(input);
        checker.printResult();

        scanner.close();
    }
}
