package easy;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree_101 {
    // https://leetcode.com/problems/symmetric-tree/description/
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right  = queue.poll();

            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }


    public boolean isSymmetricRecursive(TreeNode root) {
        if (root == null) return true;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if  (left.val != right.val) return false;

        return isMirror(left.right, right.left) && isMirror(left.left, right.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if  (left.val != right.val) return false;
        return isMirror(left.right, right.left) && isMirror(left.left, right.right);
    }

}
