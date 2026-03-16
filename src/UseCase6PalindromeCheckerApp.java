import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class UseCase6PalindromeCheckerApp {

    // Method to check palindrome using Queue (FIFO) and Stack (LIFO)
    public static boolean isPalindromeUsingQueueAndStack(String str) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Step 1: Enqueue and Push all characters
        for (int i = 0; i < str.length(); i++) {
            queue.add(str.charAt(i));      // FIFO - enqueue
            stack.push(str.charAt(i));     // LIFO - push
        }

        // Step 2: Compare dequeue (FIFO - original order)
        //         vs pop (LIFO - reversed order)
        while (!queue.isEmpty()) {
            char fromQueue = queue.remove();  // removes from front
            char fromStack = stack.pop();     // removes from top (reversed)

            if (fromQueue != fromStack) {
                return false;
            }
        }

        // Step 3: All characters matched
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC6: Queue + Stack Based Palindrome Checker ===");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        boolean result = isPalindromeUsingQueueAndStack(input);

        if (result) {
            System.out.println("\"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }

        scanner.close();
    }
}
