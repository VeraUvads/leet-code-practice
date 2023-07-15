package medium;

import utils.TreeNode;

public class SumRootToLeafNumbers_129 {
    // https://leetcode.com/problems/sum-root-to-leaf-numbers/description/?envType=study-plan-v2&envId=top-interview-150
    int answer = 0;
    public int sumNumbers(TreeNode root) {
        sumNumbers(root, 0);
        return answer;
    }


    public void sumNumbers(TreeNode root, int builder) {
        if (root == null) return;
        builder = builder * 10 + root.val;
        if (root.left == null && root.right == null) {
            answer += builder;
            return;
        }
        sumNumbers(root.left, builder);
        sumNumbers(root.right, builder);
    }
}
