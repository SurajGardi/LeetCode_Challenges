// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;

    // Constructor
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Day77 {
    // Helper function to check if all nodes in the tree have the same value
    public static boolean helper(TreeNode root, int val) {
        // If we reach a null node, return true (base case)
        if (root == null) {
            return true;
        }

        // If any node has a different value, return false
        if (root.val != val) {
            return false;
        }

        // Recursively check the left and right subtrees
        boolean leftAns = helper(root.left, val);
        boolean rightAns = helper(root.right, val);

        // Return true only if both left and right subtrees are univalued
        return leftAns && rightAns;
    }

    // Function to check if a given tree is univalued
    public static boolean isUnivalTree(TreeNode root) {
        return helper(root, root.val);
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Creating a sample tree: [1,1,1,1,1,null,1]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);

        // Checking if the tree is univalued
        boolean result = isUnivalTree(root);
        System.out.println("Is the tree univalued? " + result); // Output: true

        // Creating another tree: [2,2,2,5,2]
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(5);
        root2.left.right = new TreeNode(2);

        // Checking if this tree is univalued
        boolean result2 = isUnivalTree(root2);
        System.out.println("Is the tree univalued? " + result2); // Output: false
    }
}
