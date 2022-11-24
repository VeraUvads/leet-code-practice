package easy;

public class MaximumDepthOfBinaryTree_104 {

    // https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
