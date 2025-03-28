class Day84 {
    // Flag to track if the tree is balanced
    boolean balanceFactor = true;
    
    // TreeNode class to represent nodes of the binary tree
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x) {
            val = x;
        }
    }
    
    // Method to calculate the height of the tree
    public int height(TreeNode root) {
        // Base case: if the current node is null, return height 0
        if (root == null) {
            return 0;
        }
        
        // Recursively find the height of the left subtree
        int lh = height(root.left);
        
        // Recursively find the height of the right subtree
        int rh = height(root.right);
        
        // If the difference in height between left and right subtrees is greater than 1,
        // then the tree is unbalanced, set the balance factor to false
        if (Math.abs(lh - rh) > 1) {
            balanceFactor = false;
        }
        
        // Return the height of the current node (max of left or right subtree height + 1)
        return Math.max(lh, rh) + 1;
    }
    
    // Method to check if the tree is balanced
    public boolean isBalanced(TreeNode root) {
        // Call the height function to calculate the height of the tree and determine if it's balanced
        height(root);
        
        // Return the result based on the balanceFactor
        return balanceFactor;
    }
    
    // Main method to test the solution
    public static void main(String[] args) {
        // Create a simple binary tree for testing: [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Create an instance of Day84 class and check if the tree is balanced
        Day84 solution = new Day84();
        
        // Test the tree balance and print the result
        boolean result = solution.isBalanced(root);
        System.out.println("Is the binary tree balanced? " + result);  // Expected output: true
    }
}
