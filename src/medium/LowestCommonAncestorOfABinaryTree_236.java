package medium;

import utils.TreeNode;


public class LowestCommonAncestorOfABinaryTree_236 {
    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

    TreeNode lowest = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return lowest;
    }


    private int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return 0;
        int left =  dfs(root.left, p, q);
        int right =  dfs(root.right, p, q);
        int counter = 0;
        if (root == p) counter++;
        if (root == q) counter++;
        counter += left;
        counter += right;

        if ((counter == 2)&& lowest == null) {
            lowest = root;
        }
        return counter;
    }
}
