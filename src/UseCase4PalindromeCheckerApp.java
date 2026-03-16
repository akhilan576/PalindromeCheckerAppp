import java.util.Scanner;

public class UseCase4PalindromeCheckerApp {

    // Method to check palindrome using char[] and two-pointer technique
    public static boolean isPalindromeUsingCharArray(String str) {
        // Step 1: Convert string to char[]
        char[] charArray = str.toCharArray();

        // Step 2: Two-pointer approach
        int start = 0;
        int end = charArray.length - 1;

        // Step 3: Compare start & end characters
        while (start < end) {
            if (charArray[start] != charArray[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC4: Character Array Based Palindrome Checker ===");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        boolean result = isPalindromeUsingCharArray(input);

        if (result) {
            System.out.println("\"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }

        scanner.close();
    }
}