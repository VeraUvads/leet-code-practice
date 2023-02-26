package easy;

import utils.TreeNode;

public class SubtreeOfAnotherTree_572 {
    // https://leetcode.com/problems/subtree-of-another-tree/description/

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSame(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val != subRoot.val) {
            return false;
        }
        return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
    }



    public boolean isSubtreeLPS(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return false;
        String word = serialize(root);
        String pattern = serialize(subRoot);
        return compare(word, pattern);
    }

    private boolean compare(String word, String pattern) {
        int[] LPS = new int[pattern.length()];
        fillLPS(LPS, pattern);
        int w1 = 0;
        int p1 = 0;
        while (w1 < word.length()) {
            if (word.charAt(w1) == pattern.charAt(p1)) {
                w1++;
                p1++;
            } else if (p1 == 0) {
                w1++;
            } else {
                p1 = LPS[p1 - 1];
            }
            if (p1 == pattern.length()) return true;
        }
        return false;
    }

    private void fillLPS(int[] LPS, String pattern) {
        int start = 0;
        int end = 1;
        while (end < pattern.length()) {
            if (pattern.charAt(start) == pattern.charAt(end)) {
                LPS[end] = start + 1;
                start++;
                end++;
            } else if (start == 0) {
                LPS[end] = 0;
                end++;
            } else {
                start = LPS[start - 1];
            }
        }
    }

    private String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serialize(root, builder);
        return builder.toString();
    }

    private void serialize(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("#");
            return;
        }
        builder.append(",");
        builder.append(root.val);
        serialize(root.left, builder);
        serialize(root.right, builder);
    }


}
