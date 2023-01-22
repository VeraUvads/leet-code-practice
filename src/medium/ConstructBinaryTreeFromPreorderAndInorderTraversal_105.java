package medium;

import utils.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
    // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

    private int[] preorder;
    private int preorderIndex = 0;
    private final HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if (len == 0) return null;
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return toNode(0, len - 1);
    }

    private TreeNode toNode(int start, int end) {
        if (start > end) return null;
        int value = preorder[preorderIndex++];
        TreeNode root = new TreeNode(value);
        int index = inorderMap.get(value);
        root.left = toNode(start, index - 1);
        root.right = toNode(index + 1, end);
        return root;
    }
}
