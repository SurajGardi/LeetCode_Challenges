// Importing necessary packages
import java.util.*;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;

    // Constructor to initialize a node
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Day89 {
    int dia = 0; // Variable to store the diameter of the tree

    // Helper function to calculate the height of the tree
    public int height(TreeNode root) {
        if (root == null) {
            return 0; // Base case: Height of an empty tree is 0
        }
        int lh = height(root.left);  // Height of left subtree
        int rh = height(root.right); // Height of right subtree

        // Update the maximum diameter found so far
        dia = Math.max(dia, lh + rh);

        // Return height of current node
        return Math.max(lh, rh) + 1;
    }

    // Function to calculate the diameter of the binary tree
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0; // If the tree is empty, diameter is 0
        }
        height(root); // Call height function to update `dia`
        return dia; // Return the maximum diameter found
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        // Creating the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Creating an instance of Day89 class
        Day89 obj = new Day89();

        // Calculating and printing the diameter of the binary tree
        System.out.println("Diameter of the Binary Tree: " + obj.diameterOfBinaryTree(root));
    }
}
