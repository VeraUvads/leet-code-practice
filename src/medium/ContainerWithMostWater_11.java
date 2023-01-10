package medium;

public class ContainerWithMostWater_11 {
    // https://leetcode.com/problems/container-with-most-water/description/

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int answer = 0;
        while (left < right) {
            int high = Math.min(height[right], height[left]);
            int weight = right - left;
            answer = Math.max(high * weight, answer);
            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return answer;
    }
}
