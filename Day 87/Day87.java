import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Day87 {
    
    // Helper function to perform modified Preorder Traversal (Node → Right → Left)
    public void helper(TreeNode root, List<Integer> ans, int level) {
        if (root == null) {
            return;
        }

        // If this is the first node of the current level, add it to the result list
        if (ans.size() == level) {
            ans.add(root.val);
        }

        // First, traverse the right subtree to ensure rightmost nodes are captured first
        helper(root.right, ans, level + 1);
        // Then, traverse the left subtree
        helper(root.left, ans, level + 1);
    }

    // Function to return the right side view of the binary tree
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans, 0);
        return ans;
    }

    // Main method to test the function
    public static void main(String[] args) {
        Day87 obj = new Day87();

        // Creating the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        // Expected Output: [1, 3, 4]
        System.out.println("Right Side View: " + obj.rightSideView(root));
    }
}
