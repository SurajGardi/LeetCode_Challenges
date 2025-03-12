// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Day68 {
    
    // Function to remove the Nth node from the end of the list
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        // Two pointer approach: Fast and Slow pointers
        ListNode fast = head;
        ListNode slow = head;

        // Move fast pointer 'n' steps ahead
        while (n > 0) {
            fast = fast.next;
            n--;
        }

        // If fast pointer becomes null, it means we need to remove the first node
        if (fast == null) {
            return head.next;
        }

        // Move both fast and slow pointers until fast reaches the last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node from the end by skipping it
        slow.next = slow.next.next;

        return head;
    }

    // Utility function to print a linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Main method to test the function
    public static void main(String[] args) {
        Day68 solution = new Day68();

        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        // Removing the 2nd node from the end (Expected output: 1 -> 2 -> 3 -> 5 -> NULL)
        head = solution.removeNthFromEnd(head, 2);

        System.out.println("Modified List after removing 2nd node from end:");
        printList(head);
    }
}
