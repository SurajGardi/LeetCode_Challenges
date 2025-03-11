// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Day67 {
    
    // Function to get the size of a linked list
    public int sizeLL(ListNode head) {
        int count = 0;
        ListNode ptr = head;
        
        while (ptr != null) {
            count++;
            ptr = ptr.next;
        }
        return count;
    }

    // Function to find the intersection node of two linked lists
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        // Get sizes of both linked lists
        int size1 = sizeLL(headA);
        int size2 = sizeLL(headB);
        int diff = size1 - size2;

        ListNode ptr1 = headA;
        ListNode ptr2 = headB;

        // Move the pointer of the longer list forward by the difference in size
        if (diff > 0) { // List A is longer
            while (diff > 0) {
                ptr1 = ptr1.next;
                diff--;
            }
        } else { // List B is longer
            while (diff < 0) {
                ptr2 = ptr2.next;
                diff++;
            }
        }

        // Traverse both lists simultaneously until intersection is found
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1; // Returns intersection node or null if no intersection
    }

    // Helper function to print a linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Day67 solution = new Day67();

        // Creating two linked lists with intersection
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        // Printing the lists
        System.out.println("List A:");
        printList(headA);
        System.out.println("List B:");
        printList(headB);

        // Finding and printing the intersection node
        ListNode intersection = solution.getIntersectionNode(headA, headB);
        if (intersection != null) {
            System.out.println("Intersection found at node with value: " + intersection.val);
        } else {
            System.out.println("No intersection found.");
        }
    }
}
