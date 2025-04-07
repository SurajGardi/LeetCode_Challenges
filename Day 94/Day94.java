// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Day94 {

    // Function to find the Lowest Common Ancestor in a BST
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode temp = root;

        // Traverse the tree starting from the root
        while (temp != null) {
            // If both p and q are smaller than current node, LCA lies in left subtree
            if (temp.val > p.val && temp.val > q.val) {
                temp = temp.left;
            }
            // If both p and q are greater than current node, LCA lies in right subtree
            else if (temp.val < p.val && temp.val < q.val) {
                temp = temp.right;
            }
            // This is the split point, so current node is the LCA
            else {
                break;
            }
        }
        return temp;
    }

    // Utility method to insert a node into the BST
    public TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        Day94 tree = new Day94();

        /*
               6
              / \
             2   8
            / \ / \
           0  4 7  9
             / \
            3   5
        */

        int[] nodes = {6, 2, 8, 0, 4, 7, 9, 3, 5};
        TreeNode root = null;

        // Build the BST
        for (int val : nodes) {
            root = tree.insert(root, val);
        }

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);

        // Find and print LCA
        TreeNode lca = tree.lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + (lca != null ? lca.val : "null"));
    }
}
