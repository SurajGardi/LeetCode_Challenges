import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

class Day82 {
    // Method to find all root-to-leaf paths in the binary tree
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        
        // If the tree is empty, return an empty list
        if (root == null) {
            return ans;
        }
        
        // If it's a leaf node, just add its value as a path
        if (root.left == null && root.right == null) {
            ans.add(String.valueOf(root.val));
            return ans;
        }

        // Recursively get paths for the left and right subtrees
        List<String> leftAns = binaryTreePaths(root.left);
        List<String> rightAns = binaryTreePaths(root.right);

        // Append the current node's value to the left subtree paths
        for (String str : leftAns) {
            ans.add(root.val + "->" + str);
        }

        // Append the current node's value to the right subtree paths
        for (String str : rightAns) {
            ans.add(root.val + "->" + str);
        }

        return ans;
    }

    public static void main(String[] args) {
        // Example tree: [1,2,3,null,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        // Create an instance of the Day82 class
        Day82 day82 = new Day82();

        // Get all root-to-leaf paths
        List<String> paths = day82.binaryTreePaths(root);

        // Print the paths
        System.out.println(paths);  // Output: ["1->2->5", "1->3"]
    }
}
