package medium;

import utils.TreeNode;

import java.util.Stack;

class BSTIterator_173 { // можно еще рекурсивно предзаполнить список с inorder Tree, но тогда память O(n), а тут выходит O(h)
    private final Stack<TreeNode> stack;

    public BSTIterator_173(TreeNode root) {
        stack = new Stack<>();
        addLeftToStack(root);
    }

    private void addLeftToStack(TreeNode root) {
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        addLeftToStack(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}