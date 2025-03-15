// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Day71 {

    // Function to detect the start of the cycle in a linked list
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head; // Fast pointer moves two steps at a time
        ListNode slow = head; // Slow pointer moves one step at a time
        ListNode ptr = head;  // Pointer to determine the start of the cycle

        // Detect cycle using Floyd's cycle detection algorithm
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            // If slow and fast meet, a cycle is detected
            if (slow == fast) {
                // Move ptr and slow one step at a time to find the cycle start
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr; // Returning the starting node of the cycle
            }
        }

        return null; // No cycle found
    }

    // Helper function to create a linked list with a cycle for testing
    public static ListNode createLinkedListWithCycle(int[] values, int pos) {
        if (values.length == 0) return null;

        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        ListNode cycleNode = null;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
            if (i == pos) { // Save the node where the cycle should start
                cycleNode = current;
            }
        }

        if (pos != -1) {
            current.next = cycleNode; // Create a cycle
        }

        return head;
    }

    // Main method to test the function
    public static void main(String[] args) {
        Day71 solution = new Day71();

        // Example 1: Linked list with cycle at index 1
        int[] values1 = {3, 2, 0, -4};
        ListNode head1 = createLinkedListWithCycle(values1, 1);
        ListNode cycleStart1 = solution.detectCycle(head1);
        System.out.println(cycleStart1 != null ? "Cycle starts at node with value: " + cycleStart1.val : "No cycle detected");

        // Example 2: Linked list with cycle at index 0
        int[] values2 = {1, 2};
        ListNode head2 = createLinkedListWithCycle(values2, 0);
        ListNode cycleStart2 = solution.detectCycle(head2);
        System.out.println(cycleStart2 != null ? "Cycle starts at node with value: " + cycleStart2.val : "No cycle detected");

        // Example 3: Linked list without a cycle
        int[] values3 = {1};
        ListNode head3 = createLinkedListWithCycle(values3, -1);
        ListNode cycleStart3 = solution.detectCycle(head3);
        System.out.println(cycleStart3 != null ? "Cycle starts at node with value: " + cycleStart3.val : "No cycle detected");
    }
}
