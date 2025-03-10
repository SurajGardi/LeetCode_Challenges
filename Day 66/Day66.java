// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Day66 {
    
    // Function to rearrange the linked list into odd and even indexed nodes
    public ListNode oddEvenList(ListNode head) {
        // Edge case: If the list is empty or has only 1 or 2 nodes, return as is
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        
        // Initialize pointers for odd and even indexed nodes
        ListNode oddHead = head;        // Pointer for odd indices
        ListNode evenHead = head.next;  // Pointer for even indices
        ListNode evenStart = evenHead;  // Store the starting node of the even list

        // Traverse the list and rearrange nodes
        while (evenHead != null && evenHead.next != null) {
            oddHead.next = oddHead.next.next;  // Connect odd nodes
            evenHead.next = evenHead.next.next; // Connect even nodes
            
            oddHead = oddHead.next;  // Move odd pointer
            evenHead = evenHead.next; // Move even pointer
        }

        // Append the even indexed nodes after odd indexed nodes
        oddHead.next = evenStart;

        return head;
    }

    // Function to print the linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        // Creating an object of the class to call non-static method
        Day66 obj = new Day66();
        head = obj.oddEvenList(head);

        System.out.println("Reordered List (Odd-Even):");
        printList(head);
    }
}
