// Definition for a Binary Tree node
class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

// Class to implement the solution
class Day90 {
    
    // Method to convert a sorted array to a height-balanced BST
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    // Helper method to recursively construct BST
    public TreeNode helper(int[] nums, int start, int end) {
        // Base case: If start index exceeds end, return null
        if (start > end) {
            return null;
        }

        // Find the middle element to make it the root
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        // Recursively construct the left and right subtrees
        root.left = helper(nums, start, mid - 1);
        root.right = helper(nums, mid + 1, end);

        return root;
    }

    // Method to print the tree in pre-order traversal
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        Day90 obj = new Day90();
        
        // Example sorted array
        int[] nums = {-10, -3, 0, 5, 9};

        // Convert sorted array to BST
        TreeNode root = obj.sortedArrayToBST(nums);
        
        // Print the BST in Preorder Traversal
        System.out.print("Preorder Traversal of BST: ");
        obj.preOrder(root);
    }
}
