// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    // Constructor to create a new node
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Day70 {
    
    // Method to detect if there is a cycle in the linked list
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false; // If the list is empty or has only one node, no cycle is possible
        }
        
        ListNode slow = head;  // Slow pointer moves one step at a time
        ListNode fast = head;  // Fast pointer moves two steps at a time

        // Traverse the list using two pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow pointer one step
            fast = fast.next.next;    // Move fast pointer two steps
            
            if (slow == fast) {       // If they meet, a cycle exists
                return true;
            }
        }
        return false; // If we reach the end, no cycle exists
    }

    // Main method to test the hasCycle method
    public static void main(String[] args) {
        Day70 obj = new Day70();

        // Creating a linked list with a cycle
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        // Connecting nodes
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // Creating a cycle (tail connects to second node)

        // Checking for cycle
        if (obj.hasCycle(head)) {
            System.out.println("Cycle detected in the linked list.");
        } else {
            System.out.println("No cycle in the linked list.");
        }

        // Creating a linked list without a cycle
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        // Checking for cycle in the second list
        if (obj.hasCycle(head2)) {
            System.out.println("Cycle detected in the linked list.");
        } else {
            System.out.println("No cycle in the linked list.");
        }
    }
}
