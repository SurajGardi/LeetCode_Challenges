// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;

    // Constructor to initialize node value
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Day63_RemoveDuplicatesSortedList {

    // Method to remove duplicates from a sorted linked list
    public ListNode deleteDuplicates(ListNode head) {
        // If the list is empty or contains only one element, return head
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(head.val); // Create a new list with the first node
        ListNode ans = dummy; // Pointer to the start of the new list

        ListNode ptr = head.next; // Start iterating from the second node

        while (ptr != null) {
            // If current node's value is different from the last added node, append it
            if (ptr.val != dummy.val) {
                dummy.next = ptr;
                dummy = dummy.next;
            }
            ptr = ptr.next;
        }
        dummy.next = null; // Ensure the last node does not point to any duplicate
        return ans;
    }

    // Utility method to print the linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Creating a sorted linked list: 1 -> 1 -> 2 -> 3 -> 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        System.out.println("Original List:");
        printList(head);

        // Creating an instance of the class to call deleteDuplicates
        RemoveDuplicatesSortedList solution = new RemoveDuplicatesSortedList();
        ListNode result = solution.deleteDuplicates(head);

        System.out.println("List after removing duplicates:");
        printList(result);
    }
}
