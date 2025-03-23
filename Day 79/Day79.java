// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Constructor
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Day79 {

    // Helper function to check if two subtrees are mirror images
    public boolean helper(TreeNode root1, TreeNode root2) {
        // If both subtrees are null, they are symmetric
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }

        // Check if current nodes are equal and their subtrees are symmetric
        if (root1.val == root2.val) {
            boolean leftSymmetry = helper(root1.left, root2.right);
            boolean rightSymmetry = helper(root1.right, root2.left);
            return leftSymmetry && rightSymmetry;
        } else {
            return false;
        }
    }

    // Main function to check if the tree is symmetric
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true; // Empty tree is symmetric
        }
        return helper(root.left, root.right);
    }

    // Main method to test the code
    public static void main(String[] args) {
        SymmetricTree tree = new SymmetricTree();

        // Creating a symmetric binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        // Check if the tree is symmetric
        boolean result = tree.isSymmetric(root);
        System.out.println("Is the tree symmetric? " + result);
    }
}
