package medium;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree_366 {
    // https://leetcode.com/problems/find-leaves-of-binary-tree/description/

    List<List<Integer>> leafs = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        dfs(root);
        return leafs;
    }

    private int dfs(TreeNode root) {
        if (root == null) return -1;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int index = Math.max(left, right) + 1;
        if (leafs.size() < index + 1) {
            leafs.add(new ArrayList<>());
        }
        leafs.get(index).add(root.val);

        root.left = null;
        root.right = null;
        return index;
    }
}
