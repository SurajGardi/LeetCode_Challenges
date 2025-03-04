import java.util.Stack;

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Day61 {
    
    // Function to check if the linked list is a palindrome
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode ptr = head;

        // Push all elements into the stack
        while (ptr != null) {
            stack.push(ptr.val);
            ptr = ptr.next;
        }

        // Compare elements from the stack with the linked list
        ListNode ptr2 = head;
        while (ptr2 != null) {
            int val1 = ptr2.val;
            int val2 = stack.pop();

            if (val1 != val2) {
                return false;
            }
            ptr2 = ptr2.next;
        }

        return true;
    }

    // Helper function to create a linked list from an array
    public static ListNode createLinkedList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Day61 obj = new Day61();

        // Example 1: Palindrome linked list [1,2,2,1]
        int[] arr1 = {1, 2, 2, 1};
        ListNode head1 = createLinkedList(arr1);
        System.out.println("Is Palindrome? " + obj.isPalindrome(head1)); // Output: true

        // Example 2: Non-palindrome linked list [1,2]
        int[] arr2 = {1, 2};
        ListNode head2 = createLinkedList(arr2);
        System.out.println("Is Palindrome? " + obj.isPalindrome(head2)); // Output: false
    }
}
