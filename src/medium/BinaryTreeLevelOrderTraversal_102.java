package medium;

import java.util.*;

public class BinaryTreeLevelOrderTraversal_102 {
    // https://leetcode.com/problems/binary-tree-level-order-traversal/description/?envType=study-plan&id=level-1

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            result.add(new ArrayList<>());
            int levelLength = queue.size();
            for (int i = 0; i < levelLength; i++) {
                TreeNode current = queue.poll();
                result.get(level).add(current.val);
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            level++;
        }
        return result;
    }
}
