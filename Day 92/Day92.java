// Day92 - LeetCode 700: Search in a Binary Search Tree
import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

public class Day92 {

    // Function to search for a value in BST and return the subtree rooted at that value
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode temp = root;

        // Traverse the BST
        while (temp != null) {
            if (temp.val == val) {
                break; // Node found
            } else if (temp.val > val) {
                temp = temp.left; // Go left if val is smaller
            } else {
                temp = temp.right; // Go right if val is greater
            }
        }
        return temp; // Return found node or null
    }

    // Helper method to insert nodes into BST for testing
    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    // Helper method to print the tree in-order (for checking output)
    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    // Main method for testing the solution
    public static void main(String[] args) {
        Day92 obj = new Day92();

        // Constructing the BST: [4,2,7,1,3]
        TreeNode root = null;
        int[] values = {4, 2, 7, 1, 3};
        for (int val : values) {
            root = obj.insert(root, val);
        }

        // Value to search in BST
        int target = 2;

        // Searching the BST
        TreeNode result = obj.searchBST(root, target);

        // Printing the result subtree
        System.out.print("In-order traversal of the result subtree: ");
        obj.inorder(result); // Output should be: 1 2 3
    }
}
