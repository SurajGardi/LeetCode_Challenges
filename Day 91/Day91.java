// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

// Class containing the method to merge two binary trees
class Day91 {
    
    // Method to merge two binary trees
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // If both trees are null, return null
        if (root1 == null && root2 == null) {
            return null;
        }
        // If root1 is null, return root2
        if (root1 == null) {
            return root2;
        }
        // If root2 is null, return root1
        if (root2 == null) {
            return root1;
        }

        // Create a new node with the sum of root1 and root2 values
        TreeNode root = new TreeNode(root1.val + root2.val);

        // Recursively merge left and right subtrees
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);

        return root;
    }

    // Method to print the tree in Preorder traversal (Root → Left → Right)
    public void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Main method
    public static void main(String[] args) {
        Day91 obj = new Day91();

        // Creating first binary tree: root1 = [1,3,2,5]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        // Creating second binary tree: root2 = [2,1,3,null,4,null,7]
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        // Merging the two trees
        TreeNode mergedRoot = obj.mergeTrees(root1, root2);

        // Printing the merged tree using Preorder Traversal
        System.out.print("Merged Tree (Preorder): ");
        obj.preorder(mergedRoot);
    }
}
