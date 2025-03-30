// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class Day86 {

    // Recursive function to check if there's a root-to-leaf path with the given sum
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Base case: if the current node is null, there's no path
        if (root == null) {
            return false;
        }

        // If it's a leaf node and its value equals the target sum, return true
        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }

        // Recursively check the left and right subtrees with the updated target sum
        return hasPathSum(root.left, targetSum - root.val) || 
               hasPathSum(root.right, targetSum - root.val);
    }

    // Main method to test the code
    public static void main(String[] args) {
        Day86 solution = new Day86();

        // Constructing the binary tree:
        //        5
        //       / \
        //      4   8
        //     /   / \
        //    11 13  4
        //   /  \       \
        //  7    2       1
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;

        // Test case
        boolean result = solution.hasPathSum(root, targetSum);
        System.out.println("Does the tree have a path sum of " + targetSum + "? " + result);
    }
}
