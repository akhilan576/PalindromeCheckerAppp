import java.util.Scanner;

public class UseCase9PalindromeCheckerApp {

    // Recursive method to check palindrome
    // Compares characters at 'start' and 'end' index positions
    public static boolean isPalindromeRecursive(String str, int start, int end) {

        // Base Condition 1: If start >= end, all characters matched
        if (start >= end) {
            return true;
        }

        // Compare characters at start and end positions
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive Call: move inward and check next pair
        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC9: Recursive Palindrome Checker ===");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        boolean result = isPalindromeRecursive(input, 0, input.length() - 1);

        if (result) {
            System.out.println("\"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }

        scanner.close();
    }
}
