import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) 
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Day80 
{
    public List<Integer> postorderTraversal(TreeNode root) 
    {
        List<Integer> ans = new ArrayList<>();
        postOrder(root, ans);
        return ans;
    }

    public void postOrder(TreeNode root, List<Integer> ans) 
    {
        if (root == null)
            return;

        postOrder(root.left, ans);
        postOrder(root.right, ans);
        ans.add(root.val);
    }

    public static void main(String[] args) 
    {
        PostorderTraversalSolution solution = new PostorderTraversalSolution();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = solution.postorderTraversal(root);

        System.out.println("Postorder Traversal: " + result);
    }
}