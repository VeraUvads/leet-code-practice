package medium;

public class MaximumDifferenceBetweenNodeAndAncestor_1026 {
    // https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        return Math.max(
                helper(root.left, root.val, root.val),
                helper(root.right, root.val, root.val)
        );
    }

    private int helper(TreeNode node, int currentMax, int currentMin) {
        if (node == null) return Math.abs(currentMax - currentMin);
        currentMax = Math.max(currentMax, node.val);
        currentMin = Math.min(currentMin, node.val);
        return Math.max(
                helper(node.left, currentMax, currentMin),
                helper(node.right, currentMax, currentMin)
        );
    }
}
