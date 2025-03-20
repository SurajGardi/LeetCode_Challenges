import java.util.PriorityQueue;

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Day76 {
    
    // Method to merge k sorted linked lists
    public static ListNode mergeKLists(ListNode[] lists) {
        // If the list array is empty, return null
        if (lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0]; // If there's only one list, return it as is
        }

        // Min-heap (PriorityQueue) to store nodes based on their values
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add all nodes from k linked lists into the priority queue
        for (ListNode list : lists) {
            while (list != null) {
                pq.add(list);
                list = list.next;
            }
        }

        // Dummy node to help in constructing the result list
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        // Extract elements from min-heap and construct the merged list
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;
        }

        // Set the last node's next to null to avoid cycle
        curr.next = null;

        return dummy.next; // Return the merged sorted linked list
    }

    // Helper function to print a linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Creating sample input: [[1,4,5], [1,3,4], [2,6]]
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode[] lists = { list1, list2, list3 };

        // Merging k sorted linked lists
        ListNode mergedHead = mergeKLists(lists);

        // Printing the merged linked list
        System.out.print("Merged List: ");
        printList(mergedHead);
    }
}
