import java.util.Scanner;
import java.util.Stack;

public class UseCase5PalindromeCheckerApp {

    // Method to check palindrome using Stack (LIFO)
    public static boolean isPalindromeUsingStack(String str) {
        Stack<Character> stack = new Stack<>();

        // Step 1: Push all characters into the stack
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        // Step 2: Pop characters and compare with original string
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != stack.pop()) {
                return false;
            }
        }

        // Step 3: If all characters matched, it's a palindrome
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC5: Stack-Based Palindrome Checker ===");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        boolean result = isPalindromeUsingStack(input);

        if (result) {
            System.out.println("\"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }

        scanner.close();
    }
}