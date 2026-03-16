import java.util.Scanner;

public class UseCase8PalindromeCheckerApp {

    // Node class for Singly Linked List
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // Step 1: Convert string to linked list, returns head node
    public static Node buildLinkedList(String str) {
        Node head = null;
        Node tail = null;

        for (int i = 0; i < str.length(); i++) {
            Node newNode = new Node(str.charAt(i));
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    // Step 2: Find middle using Fast & Slow pointer technique
    public static Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // moves 1 step
            fast = fast.next.next;   // moves 2 steps
        }
        return slow; // slow is now at the middle
    }

    // Step 3: Reverse the second half of the linked list (in-place)
    public static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev; // new head of reversed list
    }

    // Main palindrome check method
    public static boolean isPalindromeUsingLinkedList(String str) {
        // Step 1: Build linked list from string
        Node head = buildLinkedList(str);

        // Step 2: Find the middle of the linked list
        Node middle = findMiddle(head);

        // Step 3: Reverse the second half
        Node secondHalfHead = reverseList(middle);

        // Step 4: Compare first half and reversed second half
        Node firstHalf  = head;
        Node secondHalf = secondHalfHead;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf  = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC8: Linked List Based Palindrome Checker ===");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        boolean result = isPalindromeUsingLinkedList(input);

        if (result) {
            System.out.println("\"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }

        scanner.close();
    }
}
