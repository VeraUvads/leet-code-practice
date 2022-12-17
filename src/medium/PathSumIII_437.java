package medium;

import easy.SymmetricTree_101;

import java.util.HashMap;

public class PathSumIII_437 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    // https://leetcode.com/problems/path-sum-iii/description/?envType=study-plan&id=level-2

    private int result = 0;
    private HashMap<Long, Integer> map;
    private int targetSum;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return result;
        this.map = new HashMap<>();
        this.targetSum = targetSum;
        preorder(root, 0L);
        return result;
    }


    public int preorder(TreeNode root, long currentSum) {
        if (root == null) return result;

        currentSum += root.val;

        if (currentSum == targetSum) result++;

        result += map.getOrDefault(currentSum - targetSum, 0);

        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        preorder(root.left, currentSum);
        preorder(root.right, currentSum);
        map.put(currentSum, map.getOrDefault(currentSum, 0) - 1);
        return result;
    }
}
