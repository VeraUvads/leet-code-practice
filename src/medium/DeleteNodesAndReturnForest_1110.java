package medium;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DeleteNodesAndReturnForest_1110 {
    // https://leetcode.com/problems/delete-nodes-and-return-forest/

    List<TreeNode> result;
    HashSet<Integer> toDelete;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        this.toDelete = new HashSet<>();
        this.result = new ArrayList<>();
        for (int num : to_delete) toDelete.add(num);
        dfs(root, false);
        return result;
    }

    private void dfs(TreeNode root, boolean hasParent) {
        if (root == null) return;
        if (toDelete.contains(root.val)) {
            dfs(root.left, false);
            dfs(root.right, false);
        } else {
            if (!hasParent) result.add(root);
            dfs(root.left, true);
            dfs(root.right, true);
        }
        if (root.left != null && toDelete.contains(root.left.val)) {
            root.left = null;
        }
        if (root.right != null && toDelete.contains(root.right.val)) {
            root.right = null;
        }
    }
}
