// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Day93 {

    // Function to insert a new value into the BST
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // If tree is empty, return a new node as root
        if (root == null) {
            return new TreeNode(val);
        }

        // If value is less than current node, insert in left subtree
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }
        // If value is greater than current node, insert in right subtree
        else {
            root.right = insertIntoBST(root.right, val);
        }

        // Return the unchanged root node
        return root;
    }

    // Helper method to print the inorder traversal of BST
    public void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    // Main method to test the insertion
    public static void main(String[] args) {
        Day93 obj = new Day93();

        // Creating a sample BST: [4,2,7,1,3]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int valToInsert = 5;

        // Inserting the value
        TreeNode updatedRoot = obj.insertIntoBST(root, valToInsert);

        // Display the inorder traversal of the updated BST
        System.out.print("Inorder Traversal after Insertion: ");
        obj.inorderTraversal(updatedRoot);
    }
}
