// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    // Constructor to initialize the node
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Day74 {
    
    // Function to delete the middle node of the linked list
    public static ListNode deleteMiddle(ListNode head) {
        // If there's only one node, return null
        if (head == null || head.next == null) {
            return null;
        }

        // Two-pointer approach
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Move fast pointer by two steps and slow by one step
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Remove the middle node by updating prev's next pointer
        prev.next = slow.next;
        return head;
    }

    // Utility function to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Creating a sample linked list: 1 -> 3 -> 4 -> 7 -> 1 -> 2 -> 6 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(6);

        System.out.println("Original Linked List:");
        printList(head);

        // Delete the middle node
        head = deleteMiddle(head);

        System.out.println("Linked List after deleting middle node:");
        printList(head);
    }
}
