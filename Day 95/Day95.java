// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Day95 {

    // Function to validate if a binary tree is a valid BST
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Recursive helper function with boundary values
    public boolean helper(TreeNode node, long min, long max) {
        // An empty node is considered a valid BST
        if (node == null) return true;

        // The current node's value must be within the range
        if (node.val <= min || node.val >= max) return false;

        // Check recursively for left and right subtrees with updated ranges
        boolean leftIsValid = helper(node.left, min, node.val);
        boolean rightIsValid = helper(node.right, node.val, max);

        return leftIsValid && rightIsValid;
    }

    // Main method to test the function
    public static void main(String[] args) {
        Day95 treeValidator = new Day95();

        // Example 1: Valid BST
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println("Is Valid BST (Example 1)? " + treeValidator.isValidBST(root1)); // true

        // Example 2: Invalid BST
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println("Is Valid BST (Example 2)? " + treeValidator.isValidBST(root2)); // false
    }
}
