package medium;

import javafx.util.Pair;
import utils.TreeNode;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal_314 {
    // https://leetcode.com/problems/binary-tree-vertical-order-traversal/description/

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int lowest = 0;
        queue.add(new Pair<>(root, 0));
        while (!queue.isEmpty())  {
            Pair<TreeNode, Integer> curr = queue.poll();
            TreeNode node = curr.getKey();
            int level = curr.getValue();
            lowest = Math.min(level, lowest);
            List<Integer> list = map.getOrDefault(level, new ArrayList<>());
            list.add(node.val);
            map.put(level, list);
            if (node.left != null) {
                queue.add(new Pair<>(node.left, level - 1));
            }
            if (node.right != null) {
                queue.add(new Pair<>(node.right, level + 1));
            }
        }
        List<List<Integer>>list = new ArrayList<>();
        while (map.containsKey(lowest))  {
            list.add(map.get(lowest++));
        }
        return list;
    }
}
