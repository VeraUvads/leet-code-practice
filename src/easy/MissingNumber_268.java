package easy;

public class MissingNumber_268 {
    // https://leetcode.com/problems/missing-number/description/

    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i;
            missing ^= nums[i];
        }
        return missing;
    }
}
