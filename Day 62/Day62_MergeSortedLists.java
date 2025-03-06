// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    
    // Constructor
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Day62_MergeSortedLists {
    
    // Method to merge two sorted linked lists
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy; // Pointer to build the new list
        
        // Pointers for both input lists
        ListNode ptr1 = list1;
        ListNode ptr2 = list2;

        // Traverse both lists and merge them in sorted order
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val < ptr2.val) {
                current.next = ptr1;
                ptr1 = ptr1.next; // Move to the next node in list1
            } else {
                current.next = ptr2;
                ptr2 = ptr2.next; // Move to the next node in list2
            }
            current = current.next; // Move the current pointer forward
        }

        // If any elements are left in list1 or list2, attach them to the merged list
        if (ptr1 != null) {
            current.next = ptr1;
        } else {
            current.next = ptr2;
        }

        return dummy.next; // Return the merged list starting from the next node of dummy
    }

    // Method to print a linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method to test the mergeTwoLists function
    public static void main(String[] args) {
        // Creating first sorted linked list: 1 -> 2 -> 4
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        // Creating second sorted linked list: 1 -> 3 -> 4
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        System.out.println("List 1:");
        printList(list1);
        
        System.out.println("List 2:");
        printList(list2);

        // Merging both lists
        ListNode mergedList = mergeTwoLists(list1, list2);

        // Printing the merged list
        System.out.println("Merged List:");
        printList(mergedList);
    }
}
