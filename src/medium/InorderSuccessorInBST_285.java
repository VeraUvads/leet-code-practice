package medium;

import utils.TreeNode;

public class InorderSuccessorInBST_285 {
    // https://leetcode.com/problems/inorder-successor-in-bst/description/
    //     9
    //   4   10
    // 2   6
    //    5  7
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p == null || root == null) return null;
        TreeNode successor = null;
        while (root != null) {
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return successor;
    }
}
