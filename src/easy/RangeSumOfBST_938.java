package easy;

import java.util.LinkedList;
import java.util.Queue;

public class RangeSumOfBST_938 {
    // https://leetcode.com/problems/range-sum-of-bst/description/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.right != null && node.val <= high) {
                queue.add(node.right);
            }
            if (node.left != null && node.val >= low) {
                queue.add(node.left);
            }
            if (node.val >= low && node.val <= high) {
                result += node.val;
            }
        }
        return result;
    }
}
