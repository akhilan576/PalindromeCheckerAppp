import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

// Step 1: Define PalindromeStrategy Interface
interface PalindromeStrategy {
    boolean checkPalindrome(String str);
    String getStrategyName();
}

// Step 2a: Implement StackStrategy (LIFO)
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean checkPalindrome(String str) {
        Stack<Character> stack = new Stack<>();

        // Push all characters
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        // Pop and compare with original
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getStrategyName() {
        return "Stack Strategy (LIFO)";
    }
}

// Step 2b: Implement DequeStrategy (Double Ended Queue)
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean checkPalindrome(String str) {
        Deque<Character> deque = new ArrayDeque<>();

        // Insert all characters into deque
        for (int i = 0; i < str.length(); i++) {
            deque.addLast(str.charAt(i));
        }

        // Compare front and rear until deque has 1 or 0 elements
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getStrategyName() {
        return "Deque Strategy (Double Ended Queue)";
    }
}

// Step 2c: Implement CharArrayStrategy (Two-Pointer)
class CharArrayStrategy implements PalindromeStrategy {

    @Override
    public boolean checkPalindrome(String str) {
        char[] charArray = str.toCharArray();
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

    @Override
    public String getStrategyName() {
        return "Char Array Strategy (Two-Pointer)";
    }
}

// Step 3: PalindromeContext - Inject strategy at runtime
class PalindromeContext {

    private PalindromeStrategy strategy;

    // Constructor injection
    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    // Allow strategy to be changed at runtime
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    // Execute the injected strategy
    public boolean execute(String str) {
        return strategy.checkPalindrome(str);
    }

    public String getStrategyName() {
        return strategy.getStrategyName();
    }
}

// Main Application Class
public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC12: Strategy Pattern for Palindrome Algorithms ===");
        System.out.println("Choose a Strategy:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.println("3. Char Array Strategy");
        System.out.print("Enter choice (1/2/3): ");
        int choice = Integer.parseInt(scanner.nextLine().trim());

        // Step 3: Inject strategy at runtime based on user choice
        PalindromeStrategy strategy;
        switch (choice) {
            case 1:
                strategy = new StackStrategy();
                break;
            case 2:
                strategy = new DequeStrategy();
                break;
            case 3:
                strategy = new CharArrayStrategy();
                break;
            default:
                System.out.println("Invalid choice! Using Stack Strategy by default.");
                strategy = new StackStrategy();
        }

        PalindromeContext context = new PalindromeContext(strategy);

        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        System.out.println("Strategy Used: " + context.getStrategyName());

        boolean result = context.execute(input);
        if (result) {
            System.out.println("\"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }

        scanner.close();
    }
}
