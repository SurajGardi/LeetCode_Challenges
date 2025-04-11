// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Day98 {

    int sum = 0; // Stores the sum of deepest leaves

    // Function to calculate the height of the binary tree
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Helper function to sum values at the deepest level
    public void helper(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            sum += root.val;
        }
        helper(root.left, level - 1);
        helper(root.right, level - 1);
    }

    // Main function to find the deepest leaves sum
    public int deepestLeavesSum(TreeNode root) {
        int h = height(root); // Get the height of the tree
        helper(root, h);      // Sum the values at the deepest level
        return sum;
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        Day98 obj = new Day98();

        /*
            Creating the tree:
                  1
                /   \
               2     3
              / \     \
             4   5     6
            /
           7
         */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        int result = obj.deepestLeavesSum(root);
        System.out.println("Deepest Leaves Sum: " + result); // Output should be 7
    }
}
