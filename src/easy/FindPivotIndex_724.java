package easy;

public class FindPivotIndex_724 {
//    https://leetcode.com/problems/find-pivot-index/description/

    public int pivotIndex(int[] nums) {
        int sum = 0, newSum = 0;
        for (int num : nums) sum += num;
        for (int i = 0; i < nums.length; i++)  {
            if (sum - nums[i] - newSum == newSum) return i;
            newSum += nums[i];
        }
        return -1;
    }
}
