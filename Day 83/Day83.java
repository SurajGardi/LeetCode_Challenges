import java.util.*;

class Day83 {

    // TreeNode class to define the structure of each node in the binary tree
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Function to perform Zigzag Level Order Traversal
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>(); // To store the final result
        if (root == null) {
            return ans; // If the tree is empty, return an empty list
        }

        List<Integer> currAns = new ArrayList<>(); // List to store current level's values
        Stack<TreeNode> main = new Stack<>(); // Stack to store nodes for the current level
        Stack<TreeNode> helper = new Stack<>(); // Stack to store nodes for the next level
        int level = 0; // Flag to indicate the current level (0 for left-to-right, 1 for right-to-left)
        main.push(root); // Push the root node to start the traversal

        // Start level order traversal
        while (!main.isEmpty()) {
            TreeNode currNode = main.pop(); // Pop the node from the current stack
            currAns.add(currNode.val); // Add the node's value to the current level's list

            // Based on the current level, add the children in the appropriate order
            if (level == 0) { // Even level (left-to-right)
                if (currNode.left != null) {
                    helper.push(currNode.left); // Add left child to the helper stack
                }
                if (currNode.right != null) {
                    helper.push(currNode.right); // Add right child to the helper stack
                }
            } else { // Odd level (right-to-left)
                if (currNode.right != null) {
                    helper.push(currNode.right); // Add right child to the helper stack
                }
                if (currNode.left != null) {
                    helper.push(currNode.left); // Add left child to the helper stack
                }
            }

            // If the current stack is empty, move to the next level
            if (main.isEmpty()) {
                ans.add(currAns); // Add the current level's result to the final answer
                currAns = new ArrayList<>(); // Reset the current level's list
                level = 1 - level; // Toggle the level flag (0 to 1 or 1 to 0)

                main = helper; // Move to the next level
                helper = new Stack<>(); // Reset the helper stack for the next level
            }
        }
        return ans; // Return the final result
    }

    public static void main(String[] args) {
        // Create a sample binary tree: [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Create an instance of the Day83 class
        Day83 solution = new Day83();

        // Get the zigzag level order traversal result
        List<List<Integer>> result = solution.zigzagLevelOrder(root);

        // Print the result
        System.out.println(result); // Output: [[3],[20,9],[15,7]]
    }
}
