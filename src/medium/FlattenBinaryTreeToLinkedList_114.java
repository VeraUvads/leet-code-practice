package medium;

import utils.TreeNode;

public class FlattenBinaryTreeToLinkedList_114 {
    // https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode node = root;
        while (node != null)  {
            if (node.left == null) {
                node = node.right;
                continue;
            }
            TreeNode rightMost = node.left;
            while (rightMost.right != null)  {
                rightMost = rightMost.right;
            }
            rightMost.right = node.right;
            node.right =  node.left;
            node.left = null;
            node = node.right;
        }
    }

    public void flattenStack(TreeNode root) {
        if (root == null) return;
        TreeNode node = root;
        while (node != null)  {
            if (node.left == null) {
                node = node.right;
                continue;
            }
            TreeNode rightMost = node.left;
            while (rightMost.right != null)  {
                rightMost = rightMost.right;
            }
            rightMost.right = node.right;
            node.right =  node.left;
            node.left = null;
            node = node.right;
        }
    }
}
