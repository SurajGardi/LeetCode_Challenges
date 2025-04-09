// Definition for singly-linked list node
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

// Definition for binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class Day96 {

    // Function to convert sorted linked list to height-balanced BST
    public TreeNode sortedListToBST(ListNode head) {
        // Base case: empty list
        if (head == null) return null;

        // Base case: only one node
        if (head.next == null) return new TreeNode(head.val);

        // Find middle node of the linked list
        ListNode mid = findMiddle(head);

        // Make middle node the root
        TreeNode root = new TreeNode(mid.val);

        // Recursively build left and right subtrees
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);

        return root;
    }

    // Helper method to find the middle node and disconnect left half
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Move fast by 2 steps and slow by 1 step
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Disconnect left half from the middle
        if (prev != null) {
            prev.next = null;
        }

        return slow;
    }

    // Inorder traversal to print BST
    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    // Main method to test the code
    public static void main(String[] args) {
        Day96 obj = new Day96();

        // Create sorted linked list: [-10, -3, 0, 5, 9]
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        // Convert to BST
        TreeNode bstRoot = obj.sortedListToBST(head);

        // Print the BST using inorder traversal (should print sorted order)
        System.out.println("Inorder traversal of resulting BST:");
        obj.inorderTraversal(bstRoot);
    }
}
