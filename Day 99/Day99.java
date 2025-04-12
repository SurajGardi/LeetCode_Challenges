// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Day99 {

    // Global variable to store the running sum
    int sum = 0;

    // Function to convert BST to Greater Sum Tree
    public TreeNode bstToGst(TreeNode root) {
        helper(root); // Start the reverse in-order traversal
        return root;
    }

    // Helper method for reverse in-order traversal
    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        // Traverse the right subtree first (greater values)
        helper(root.right);

        // Update the current node's value by adding cumulative sum
        sum += root.val;
        root.val = sum;

        // Traverse the left subtree (smaller values)
        helper(root.left);
    }

    // In-order traversal to display the tree (for verification)
    public void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // Main method for testing
    public static void main(String[] args) {
        Day99 obj = new Day99();

        // Constructing the example BST:
        // Input: [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        System.out.println("Original BST (In-order):");
        obj.inorder(root);  // Before transformation
        System.out.println();

        // Convert to Greater Sum Tree
        TreeNode updatedRoot = obj.bstToGst(root);

        System.out.println("Greater Sum Tree (In-order):");
        obj.inorder(updatedRoot);  // After transformation
    }
}
