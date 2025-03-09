// Definition for singly-linked list node
class ListNode {
    int val;
    ListNode next;

    // Constructor to initialize a node
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Day65 {
    
    // Method to reverse a linked list
    public static ListNode reverseLL(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode temp = curr.next; // Store next node
            curr.next = prev; // Reverse the link
            prev = curr; // Move prev forward
            curr = temp; // Move curr forward
        }
        return prev; // New head after reversal
    }

    // Method to double the number represented by the linked list
    public static ListNode doubleIt(ListNode head) {
        // Step 1: Reverse the linked list to process from least significant digit
        ListNode reversedHead = reverseLL(head);
        ListNode dummy = new ListNode(-1); // Dummy node for result list
        ListNode ans = dummy;
        int carry = 0; // Variable to store carry

        // Step 2: Traverse and double each digit
        while (reversedHead != null) {
            int sum = reversedHead.val * 2 + carry; // Double the digit and add carry
            int digit = sum % 10; // Extract the last digit
            carry = sum / 10; // Compute new carry
            
            // Create new node with the computed digit
            ListNode temp = new ListNode(digit);
            dummy.next = temp;
            dummy = dummy.next;

            // Move to the next node in the reversed list
            reversedHead = reversedHead.next;
        }

        // Step 3: If there is a carry left, add it as a new node
        if (carry > 0) {
            dummy.next = new ListNode(carry);
        }

        // Step 4: Reverse the result linked list back to original order
        return reverseLL(ans.next);
    }

    // Helper method to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example 1: Input [1,8,9] -> Output [3,7,8]
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(8);
        head1.next.next = new ListNode(9);

        System.out.print("Original List: ");
        printList(head1);

        ListNode result1 = doubleIt(head1);
        System.out.print("Doubled List: ");
        printList(result1);

        // Example 2: Input [9,9,9] -> Output [1,9,9,8]
        ListNode head2 = new ListNode(9);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(9);

        System.out.print("Original List: ");
        printList(head2);

        ListNode result2 = doubleIt(head2);
        System.out.print("Doubled List: ");
        printList(result2);
    }
}
