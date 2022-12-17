package easy;

public class DiameterOfBinaryTree_543 {
    // https://leetcode.com/problems/diameter-of-binary-tree/description/
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static int maxDiameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiameter;
    }

    public static int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        if (left + right > maxDiameter) {
            maxDiameter = left + right;
        }
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2);
        TreeNode root = new TreeNode(1, left, null);
        diameterOfBinaryTree(root);
    }
}
