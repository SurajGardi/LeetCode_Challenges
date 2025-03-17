import java.util.Stack;

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Day73 {

    // Function to calculate the size of the linked list
    public static int sizeLL(ListNode head) {
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    // Function to reverse the linked list
    public static ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev; // New head of the reversed list
    }

    // Function to find the next greater node for each node in the linked list
    public static int[] nextLargerNodes(ListNode head) {
        int size = sizeLL(head);
        int[] result = new int[size];

        // Reverse the linked list
        ListNode newHead = reverseLL(head);

        // Stack to store the next greater elements
        Stack<Integer> stack = new Stack<>();
        stack.push(newHead.val);

        ListNode curr = newHead.next;
        int index = size - 2; // Start from second last element

        while (index >= 0) {
            int val = curr.val;
            curr = curr.next;

            // Remove elements from the stack that are smaller or equal to current node value
            while (!stack.isEmpty() && stack.peek() <= val) {
                stack.pop();
            }

            // Set the next greater element in result array
            result[index] = stack.isEmpty() ? 0 : stack.peek();

            // Push the current node's value onto the stack
            stack.push(val);
            index--;
        }

        return result;
    }

    // Helper function to print an array
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // Helper function to create a linked list from an array
    public static ListNode createLinkedList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Example 1
        int[] values1 = {2, 1, 5};
        ListNode head1 = createLinkedList(values1);
        int[] result1 = nextLargerNodes(head1);
        System.out.print("Output for [2, 1, 5]: ");
        printArray(result1);

        // Example 2
        int[] values2 = {2, 7, 4, 3, 5};
        ListNode head2 = createLinkedList(values2);
        int[] result2 = nextLargerNodes(head2);
        System.out.print("Output for [2, 7, 4, 3, 5]: ");
        printArray(result2);
    }
}
