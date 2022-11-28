package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_94 {
    // https://leetcode.com/problems/binary-tree-inorder-traversal/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode current;
        while (!stack.isEmpty()) {
            current = stack.pop();

            if (current.right != null) {
                stack.add(current.right);
            }
            if (current.left == null) {
                result.add(current.val);
            } else {
                stack.add(new TreeNode(current.val));
                stack.add(current.left);
            }
        }

        return result;
    }
}
