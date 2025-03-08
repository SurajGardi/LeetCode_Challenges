// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    
    // Constructor to initialize a node
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Day64 {
    
    // Method to add two numbers represented as linked lists
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // If any of the lists is null, return the other one
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // Dummy node to simplify list construction
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        int carry = 0;

        // Traverse both lists
        while (ptr1 != null || ptr2 != null) {
            int val1 = (ptr1 != null) ? ptr1.val : 0;
            int val2 = (ptr2 != null) ? ptr2.val : 0;
            int sum = val1 + val2 + carry;
            int digit = sum % 10;  // Extract the last digit
            carry = sum / 10;  // Carry for the next iteration

            // Create a new node for the digit
            dummy.next = new ListNode(digit);
            dummy = dummy.next;

            // Move pointers forward if they are not null
            if (ptr1 != null) ptr1 = ptr1.next;
            if (ptr2 != null) ptr2 = ptr2.next;
        }

        // If there's a remaining carry, add a new node
        if (carry > 0) {
            dummy.next = new ListNode(carry);
        }

        return ans.next;  // Skip the dummy node and return the actual result
    }

    // Utility method to print a linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example 1: l1 = [2,4,3], l2 = [5,6,4]  (342 + 465 = 807)
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println("Input List 1:");
        printList(l1);
        System.out.println("Input List 2:");
        printList(l2);

        // Compute the sum
        ListNode result = addTwoNumbers(l1, l2);
        
        // Print the result
        System.out.println("Sum as Linked List:");
        printList(result);
    }
}
