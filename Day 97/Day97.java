// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Day97 {

    // Step 1: Perform inorder traversal to get elements in sorted order
    public void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    // Step 2: Build balanced BST from sorted list using divide and conquer
    public TreeNode BSTMaker(ArrayList<Integer> list, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(list.get(mid));

        root.left = BSTMaker(list, start, mid - 1);
        root.right = BSTMaker(list, mid + 1, end);

        return root;
    }

    // Main function to balance the BST
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);
        return BSTMaker(inorderList, 0, inorderList.size() - 1);
    }

    // Helper method to print the tree in level-order (for verification)
    public void printLevelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }
        System.out.println();
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        // Creating an unbalanced BST: [1,null,2,null,3,null,4]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        Day97 solution = new Day97();
        TreeNode balancedRoot = solution.balanceBST(root);

        // Print the balanced BST
        System.out.print("Balanced BST (Level Order): ");
        solution.printLevelOrder(balancedRoot);
    }
}
