package medium;

import kotlin.Pair;
import utils.TreeNode;

import java.util.LinkedList;

public class MaximumWidthOfBinaryTree_662 {
    //https://leetcode.com/problems/maximum-width-of-binary-tree/description/?envType=study-plan&id=level-3

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        int maxWidth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> curr = queue.poll();
                TreeNode node = curr.getFirst();
                int index = curr.getSecond();
                if (node.left != null) {
                    queue.add(new Pair<>(node.left, index * 2));
                }
                if (node.right != null) {
                    queue.add(new Pair<>(node.right, index * 2 + 1));
                }
            }
            if (queue.isEmpty()) break;
            int width = queue.getLast().getSecond() - queue.getFirst().getSecond() + 1;
            maxWidth = Math.max(width, maxWidth);
        }

        return maxWidth;
    }
}
