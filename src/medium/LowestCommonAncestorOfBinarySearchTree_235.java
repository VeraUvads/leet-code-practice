package medium;

public class LowestCommonAncestorOfBinarySearchTree_235 {

    //  https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/?envType=study-plan&id=level-1
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null ||  p == null || q == null) return null;

        while (root != null) {
            boolean isEquals = root.val == p.val || root.val == q.val;
            boolean isPInLeft = root.val > p.val;
            boolean isQInLeft = root.val > q.val;
            if (isPInLeft != isQInLeft || isEquals) return root;
            if (isPInLeft) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}
