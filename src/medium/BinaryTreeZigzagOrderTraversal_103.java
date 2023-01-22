package medium;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagOrderTraversal_103 {
    // https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        dfs(root, 0, true);
        return answer;
    }

    private void dfs(TreeNode root, int height, boolean isToRight) {
        if (root == null) return;
        if (answer.size() == height) {
            answer.add(new LinkedList<>());
        }
        List<Integer> list = answer.get(height);
        if (isToRight) {
            list.add(root.val);
        } else {
            list.add(0, root.val);
        }
        dfs(root.left, height + 1, !isToRight);
        dfs(root.right, height + 1, !isToRight);
    }

    public List<List<Integer>> zigzagLevelOrderBfs(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) return answer;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean isToRight = true;
        LinkedList<Integer> level = new LinkedList<>();
        while (!queue.isEmpty())  {
            TreeNode node = queue.poll();
            if (node == null) {
                if (queue.size() != 0) {
                    queue.add(null);
                }
                isToRight = !isToRight;
                if (!level.isEmpty()) answer.add(level);
                level = new LinkedList<>();
                continue;
            }
            if (isToRight) {
                level.add(node.val);
            } else {
                level.addFirst(node.val);
            }
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return answer;
    }

}
