package medium;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestElementInABST_230 {

    private List<Integer> sorted = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root);
        return sorted.get(k - 1);
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) return;
        inorderTraversal(node.left);
        sorted.add(node.val);
        inorderTraversal(node.right);
    }

    public int kthSmallestIterative(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (k == 1) return root.val;
            root = root.right;
        }
    }
}
