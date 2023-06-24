package hard;

public class FirstMissingPositive_41 {
    // https://leetcode.com/problems/first-missing-positive/description/?envType=featured-list&envId=top-interview-questions

    public int firstMissingPositive(int[] nums) {
        boolean isContainsOne = false;
        for (int num : nums) {
            if (num == 1) {
                isContainsOne = true;
                break;
            }
        }
        if (!isContainsOne) return 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int number = Math.abs(nums[i]);
            if (number > nums.length) {
                continue;
            }
            if (nums[number - 1] > 0) {
                nums[number - 1] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return i + 1;
        }
        return nums.length + 1;
    }
}
