// Definition for singly-linked list node
class ListNode {
    int val;
    ListNode next;

    // Constructor to initialize node
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Day69 {
    
    // Function to delete a given node (except the last node)
    public void deleteNode(ListNode node) {
        // Copy the value of the next node to the current node
        node.val = node.next.val;
        // Point current node's next to the next node's next, skipping the next node
        node.next = node.next.next;
    }

    // Utility function to print the linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method to test the deleteNode function
    public static void main(String[] args) {
        // Creating a sample linked list: 4 -> 5 -> 1 -> 9
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        System.out.println("Original List:");
        printList(head);

        // Deleting node with value 5 (second node in the list)
        Day69 obj = new Day69();
        obj.deleteNode(head.next);

        System.out.println("List after deleting node 5:");
        printList(head);
    }
}
