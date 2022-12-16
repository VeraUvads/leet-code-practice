package easy;

public class BalancedBinaryTree_110 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(height(root.left, 0) - height(root.right, 0)) < 2
                && isBalanced(root.left)
                && isBalanced(root.right);
    }


    public int height(TreeNode root, int size) {
        if (root == null) return size;

        int leftSize = height(root.left, size + 1);
        int rightSize = height(root.right, size + 1);

        return Math.max(leftSize, rightSize);
    }
}
