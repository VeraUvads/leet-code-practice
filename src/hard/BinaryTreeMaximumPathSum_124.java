package hard;

import utils.TreeNode;

public class BinaryTreeMaximumPathSum_124 {
    // https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        traverse(root);
        return max;
    }

    public int traverse(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(traverse(root.left), 0);
        int right = Math.max(traverse(root.right), 0);
        max = Math.max(max, left + right + root.val);

        return Math.max(left + root.val, right + root.val);
    }
}
