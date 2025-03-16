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

public class Day72 {
    
    // Function to remove all nodes with a specific value from the linked list
    public ListNode removeElements(ListNode head, int val) {
        // Create a dummy node to handle edge cases (like removing the head node)
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;

        // Traverse the list and remove nodes with the given value
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next; // Skip the node with the given value
            } else {
                curr = curr.next; // Move to the next node
            }
        }

        // Return the new head of the list
        return dummy.next;
    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method to test the removeElements function
    public static void main(String[] args) {
        Day72 obj = new Day72();

        // Creating the linked list: 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        System.out.println("Original Linked List:");
        printList(head);

        // Remove nodes with value 6
        head = obj.removeElements(head, 6);

        System.out.println("Linked List after removing value 6:");
        printList(head);
    }
}
