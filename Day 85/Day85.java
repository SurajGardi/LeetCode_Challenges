class Day85 {
    // Initialize a counter to keep track of the number of nodes visited during in-order traversal
    int count = 0;
    // Variable to store the result (the kth smallest element)
    int ans = 0;

    // Main method to call the kthSmallest function and test with an example
    public static void main(String[] args) {
        // Example 1: BST: [3,1,4,null,2], k = 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.right = new TreeNode(2);
        
        Day85 solution = new Day85();
        int result1 = solution.kthSmallest(root1, 1);
        System.out.println("Kth Smallest Element in BST (k=1): " + result1); // Expected output: 1
        
        // Example 2: BST: [5,3,6,2,4,null,null,1], k = 3
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.left.left.left = new TreeNode(1);

        int result2 = solution.kthSmallest(root2, 3);
        System.out.println("Kth Smallest Element in BST (k=3): " + result2); // Expected output: 3
    }

    // Function to find the kth smallest element in the BST
    public int kthSmallest(TreeNode root, int k) {
        // Start the recursive helper function to perform in-order traversal
        helper(root, k);
        return ans;  // Return the kth smallest element once found
    }

    // Helper function for in-order traversal
    public void helper(TreeNode root, int k) {
        // Base case: If the node is null, return
        if (root == null) {
            return;
        }

        // Recur on the left subtree (this will visit the smallest nodes first)
        helper(root.left, k);
        
        // Increment the count after visiting the node
        count++;
        
        // If we've reached the kth node, store the result
        if (count == k) {
            ans = root.val;
            return; // Stop the recursion once the kth smallest is found
        }
        
        // Recur on the right subtree (this will visit the larger nodes)
        helper(root.right, k);
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    // Constructor to create a new tree node
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
