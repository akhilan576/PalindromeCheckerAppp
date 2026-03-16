import java.util.Scanner;

public class UseCase3PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC3: Palindrome Check Using String Reverse ===");
        System.out.print("Enter a string to check: ");
        String original = scanner.nextLine();

        // Step 1: Reverse string using for loop
        // String is immutable - each + creates a new String object
        String reversed = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }

        System.out.println("Original String : " + original);
        System.out.println("Reversed String : " + reversed);

        // Step 2: Compare original and reversed using equals()
        if (original.equals(reversed)) {
            System.out.println("\"" + original + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + original + "\" is NOT a Palindrome.");
        }

        scanner.close();
    }
}
