// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class Day78 {
    
    // Method to count the number of nodes in a complete binary tree
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0; // Base case: If tree is empty, return 0
        }
        
        // Count nodes in the left and right subtrees
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        
        // Total nodes = left subtree nodes + right subtree nodes + current node
        return leftCount + rightCount + 1;
    }

    // Helper function to create a sample complete binary tree
    public static TreeNode createTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        return root; // Returns the root of the created tree
    }

    // Main method to test the function
    public static void main(String[] args) {
        CountCompleteTreeNodes tree = new CountCompleteTreeNodes();
        
        // Create a sample tree
        TreeNode root = createTree();
        
        // Count nodes and print the result
        int nodeCount = tree.countNodes(root);
        System.out.println("Total number of nodes in the complete binary tree: " + nodeCount);
    }
}
