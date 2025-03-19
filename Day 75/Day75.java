import java.util.*;

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Day75 {

    // Function to merge nodes between zeros
    public static ListNode mergeNodes(ListNode head) {
        // Dummy node to track the result list
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        
        ListNode curr = head.next; // Start from the first non-zero node
        int sum = 0;

        while (curr != null) {
            if (curr.val != 0) {
                // Accumulate the sum of values between zeros
                sum += curr.val;
            } else {
                // Create a new node with the accumulated sum and attach it to result list
                ListNode temp = new ListNode(sum);
                dummy.next = temp;
                dummy = dummy.next;
                sum = 0; // Reset sum for the next segment
            }
            curr = curr.next; // Move to the next node
        }
        return ans.next; // Return the modified linked list (excluding the dummy node)
    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Creating the linked list: [0,3,1,0,4,5,2,0]
        ListNode head = new ListNode(0);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(0);

        System.out.println("Original Linked List:");
        printList(head);

        // Merging nodes between zeros
        ListNode result = mergeNodes(head);

        System.out.println("Modified Linked List:");
        printList(result);
    }
}
