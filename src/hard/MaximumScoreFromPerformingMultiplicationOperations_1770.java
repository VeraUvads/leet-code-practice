package hard;

public class MaximumScoreFromPerformingMultiplicationOperations_1770 {
    // https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/description/
    int[][] memo;
    int[] nums;
    int[] multipliers;

    public int maximumScore(int[] nums, int[] multipliers) {
        this.multipliers = multipliers;
        this.nums = nums;
        int n = nums.length;
        int m  = multipliers.length;
        this.memo = new int[m][n];
        return dfs(0, nums.length - 1, 0);
    }

    private int dfs(int left, int right, int multiplier) {
        if (left > right || multiplier == multipliers.length) return 0;
        if (memo[multiplier][left] != 0) {
            return memo[multiplier][left];
        }
        int leftPart = nums[left] *  multipliers[multiplier] +
                dfs(left + 1, right, multiplier + 1);
        int rightPart = nums[right] *  multipliers[multiplier] +
                dfs(left, right - 1, multiplier + 1);
        return memo[multiplier][left] = Math.max(leftPart, rightPart);
    }
}
