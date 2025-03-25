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

public class Day81 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>(); // Stores final level order traversal result
        List<Integer> currAns = new ArrayList<>(); // Stores values of the current level

        if (root == null) {
            return ans; // If tree is empty, return an empty list
        }

        Queue<TreeNode> main = new ArrayDeque<>(); // Main queue for processing nodes
        Queue<TreeNode> helper = new ArrayDeque<>(); // Helper queue for next level nodes

        main.add(root); // Start with the root node

        while (!main.isEmpty()) {
            TreeNode currNode = main.poll(); // Remove and process the current node
            currAns.add(currNode.val);

            // Add left child to the queue if it exists
            if (currNode.left != null) {
                helper.add(currNode.left);
            }
            // Add right child to the queue if it exists
            if (currNode.right != null) {
                helper.add(currNode.right);
            }

            // If the current level is completed, move to the next level
            if (main.isEmpty()) {
                ans.add(currAns); // Store the current level result
                currAns = new ArrayList<>(); // Reset for the next level
                main = helper; // Move to the next level
                helper = new ArrayDeque<>(); // Reset helper queue
            }
        }
        return ans; // Return the final level order traversal result
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Creating an instance of Day81 class
        Day81 solution = new Day81();
        List<List<Integer>> result = solution.levelOrder(root);

        // Printing the level order traversal result
        System.out.println("Level Order Traversal: " + result);
    }
}
