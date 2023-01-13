package hard;

public class TrappingRainWater_42 {
    // https://leetcode.com/problems/trapping-rain-water/description/

    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int left = 0, right = height.length - 1;
        int trap = 0;
        int maxLeft = 0, maxRight = 0;

        while (left <= right) {
            maxRight = Math.max(maxRight, height[right]);
            maxLeft = Math.max(maxLeft, height[left]);
            if (height[left] > height[right])  {
                if (maxRight >= height[right])  {
                    trap += Math.abs(maxRight  - height[right]);
                }
                right--;
            } else {
                if (maxLeft >= height[left]) {
                    trap += Math.abs(maxLeft - height[left]);
                }
                left++;
            }
        }

        return trap;
    }
}
