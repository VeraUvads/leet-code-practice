package medium;

public class ValidateBinarySearchTree_98 {

    // https://leetcode.com/problems/validate-binary-search-tree/description/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer low, Integer high)  {
        if (root == null) return true;

        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }
        return helper(root.left, low, root.val) && helper(root.right, root.val, high);
    }
}
