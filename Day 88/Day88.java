import java.util.LinkedList;
import java.util.Queue;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Day88 {

    // Function to invert a binary tree
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null; // Base case: if tree is empty, return null
        }

        // Recursively invert left and right subtrees
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // Swap left and right children
        root.left = right;
        root.right = left;

        return root; // Return the modified root node
    }

    // Helper function to perform level-order traversal and print the tree
    public void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        System.out.println();
    }

    // Main method to test the function
    public static void main(String[] args) {
        Day88 tree = new Day88();

        // Constructing the example tree:
        //       4
        //      / \
        //     2   7
        //    / \  / \
        //   1   3 6  9
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        // Print original tree
        System.out.println("Original Tree:");
        tree.printLevelOrder(root);

        // Invert the tree
        TreeNode invertedRoot = tree.invertTree(root);

        // Print inverted tree
        System.out.println("Inverted Tree:");
        tree.printLevelOrder(invertedRoot);
    }
}
