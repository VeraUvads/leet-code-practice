package easy;

import javafx.util.Pair;
import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree_111 {
    // https://leetcode.com/problems/minimum-depth-of-binary-tree/description/

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 1));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            root = pair.getKey();
            int currentDepth = pair.getValue();
            if (root.left == null && root.right == null) return currentDepth;
            if (root.right != null) {
                queue.add(new Pair<>(root.right, currentDepth + 1));
            }
            if (root.left != null) {
                queue.add(new Pair<>(root.left, currentDepth + 1));
            }
        }
        return 0;
    }

    public int minDepthRecursive(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }

        int minDepth = Integer.MAX_VALUE;
        if (root.right != null) {
            minDepth = Math.min(minDepth, minDepth(root.right));
        }
        if (root.left != null) {
            minDepth = Math.min(minDepth, minDepth(root.left));
        }

        return minDepth + 1;
    }
}
