import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class UseCase7PalindromeCheckerApp {

    // Method to check palindrome using Deque (Double Ended Queue)
    public static boolean isPalindromeUsingDeque(String str) {
        Deque<Character> deque = new ArrayDeque<>();

        // Step 1: Insert all characters into the deque
        for (int i = 0; i < str.length(); i++) {
            deque.addLast(str.charAt(i));   // add to rear
        }

        // Step 2 & 3: Remove first & last, compare until deque is empty or has 1 element
        while (deque.size() > 1) {
            char front = deque.removeFirst();  // remove from front
            char rear  = deque.removeLast();   // remove from rear

            if (front != rear) {
                return false;
            }
        }

        // If all comparisons passed, it's a palindrome
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC7: Deque-Based Optimized Palindrome Checker ===");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        boolean result = isPalindromeUsingDeque(input);

        if (result) {
            System.out.println("\"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }

        scanner.close();
    }
}
