import java.util.Scanner;

public class UseCase10PalindromeCheckerApp {

    // Step 1: Normalize the string - remove spaces and convert to lowercase
    public static String normalizeString(String str) {
        // Remove all non-alphanumeric characters using regex and convert to lowercase
        return str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    // Step 2: Check palindrome using two-pointer on normalized string
    public static boolean isPalindromeCaseInsensitive(String str) {
        // Normalize first
        String normalized = normalizeString(str);

        // Two-pointer approach on normalized string
        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC10: Case-Insensitive & Space-Ignored Palindrome Checker ===");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        // Show normalized version to user
        String normalized = normalizeString(input);
        System.out.println("Normalized String: \"" + normalized + "\"");

        boolean result = isPalindromeCaseInsensitive(input);

        if (result) {
            System.out.println("\"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }

        scanner.close();
    }
}
