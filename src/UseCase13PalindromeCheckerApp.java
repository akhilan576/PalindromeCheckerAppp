import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class UseCase13PalindromeCheckerApp {

    // ── UC4: char[] Two-Pointer ──────────────────────────────────────────────
    public static boolean checkCharArray(String str) {
        char[] charArray = str.toCharArray();
        int start = 0;
        int end   = charArray.length - 1;
        while (start < end) {
            if (charArray[start] != charArray[end]) return false;
            start++;
            end--;
        }
        return true;
    }

    // ── UC5: Stack ───────────────────────────────────────────────────────────
    public static boolean checkStack(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) stack.push(str.charAt(i));
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != stack.pop()) return false;
        }
        return true;
    }

    // ── UC6: Queue + Stack ───────────────────────────────────────────────────
    public static boolean checkQueueAndStack(String str) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            queue.add(str.charAt(i));
            stack.push(str.charAt(i));
        }
        while (!queue.isEmpty()) {
            if (queue.remove() != stack.pop()) return false;
        }
        return true;
    }

    // ── UC7: Deque ───────────────────────────────────────────────────────────
    public static boolean checkDeque(String str) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) deque.addLast(str.charAt(i));
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }

    // ── UC9: Recursive ───────────────────────────────────────────────────────
    public static boolean checkRecursive(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return checkRecursive(str, start + 1, end - 1);
    }

    // ── UC10: Case-Insensitive ───────────────────────────────────────────────
    public static boolean checkCaseInsensitive(String str) {
        String normalized = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] charArray  = normalized.toCharArray();
        int start = 0;
        int end   = charArray.length - 1;
        while (start < end) {
            if (charArray[start] != charArray[end]) return false;
            start++;
            end--;
        }
        return true;
    }

    // ── Helper: measure execution time in nanoseconds ────────────────────────
    public static long measureTime(Runnable method) {
        long startTime = System.nanoTime();
        method.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // ── Print formatted result row ────────────────────────────────────────────
    public static void printResult(String approach, boolean result, long timeNs) {
        System.out.printf("%-30s | %-12s | %d ns%n",
                approach,
                result ? "Palindrome" : "Not Palindrome",
                timeNs);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC13: Performance Comparison of Palindrome Algorithms ===");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        System.out.println();
        System.out.println("Results:");
        System.out.println("--------------------------------------------------------------");
        System.out.printf("%-30s | %-12s | %s%n", "Approach", "Result", "Time (ns)");
        System.out.println("--------------------------------------------------------------");

        // Measure each algorithm
        long t1 = measureTime(() -> checkCharArray(input));
        printResult("UC4 - Char Array", checkCharArray(input), t1);

        long t2 = measureTime(() -> checkStack(input));
        printResult("UC5 - Stack", checkStack(input), t2);

        long t3 = measureTime(() -> checkQueueAndStack(input));
        printResult("UC6 - Queue + Stack", checkQueueAndStack(input), t3);

        long t4 = measureTime(() -> checkDeque(input));
        printResult("UC7 - Deque", checkDeque(input), t4);

        long t5 = measureTime(() -> checkRecursive(input, 0, input.length() - 1));
        printResult("UC9 - Recursive", checkRecursive(input, 0, input.length() - 1), t5);

        long t6 = measureTime(() -> checkCaseInsensitive(input));
        printResult("UC10 - Case Insensitive", checkCaseInsensitive(input), t6);

        System.out.println("--------------------------------------------------------------");

        // Find fastest algorithm
        long   fastest     = Math.min(t1, Math.min(t2, Math.min(t3, Math.min(t4, Math.min(t5, t6)))));
        String fastestName =
                fastest == t1 ? "UC4 - Char Array"      :
                fastest == t2 ? "UC5 - Stack"            :
                fastest == t3 ? "UC6 - Queue + Stack"    :
                fastest == t4 ? "UC7 - Deque"            :
                fastest == t5 ? "UC9 - Recursive"        :
                                "UC10 - Case Insensitive";

        System.out.println("Fastest Algorithm : " + fastestName + " (" + fastest + " ns)");

        scanner.close();
    }
}
