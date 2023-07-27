package medium;

public class SingleElementInASortedArray_540 {
    // https://leetcode.com/problems/single-element-in-a-sorted-array/description/
    public int singleNonDuplicateBruteForce(int[] nums) {
        int sum = 0;
        int sign = 1;
        for (int i = 0; i <nums.length;i++)  {
            sum += sign * nums[i];
            if (sign == -1 && sum != 0) return nums[i-1];
            sign *= -1;
        }
        return sum;
    }

    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
