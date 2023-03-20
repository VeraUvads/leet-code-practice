package medium;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOABinaryTree_1161 {
    // https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        int max = Integer.MIN_VALUE;
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currLevel = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            currLevel++;
            while (size != 0) {
                TreeNode curr = queue.poll();
                sum += curr.val;
                size--;
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            if (sum > max) {
                level = currLevel;
                max = sum;
            }
        }
        return level;
    }
}
