package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {
    // https://leetcode.com/problems/4sum/description/
    List<List<Integer>> answer;
    int k;
    public List<List<Integer>> fourSum(int[] nums, long target) {
        Arrays.sort(nums);
        this.answer = new ArrayList<>();
        this.k = 4;
        kSum(nums, target, 0, new ArrayList<>());
        return answer;
    }

    private void kSum(int[] nums, long target, int index, ArrayList<Integer> current) {
        int position = current.size();
        int n = nums.length;
        if (position == 2) {
            twoSum(nums, index, nums.length - 1, target, current);
            return;
        }
        for (int i = index; i < n - (k - position - 1); i++) {
            if (i != index && nums[i] == nums[i - 1]) continue;
            current.add(nums[i]);
            kSum(nums, target - nums[i], i + 1, current);
            current.remove(current.size() - 1);
        }
    }

    private void twoSum(int[] nums, int start, int end, Long target, ArrayList<Integer> current) {
        int left = start, right = end;
        while (left < right) {
            while (left != start && left < right) {
                if (nums[left] == nums[left - 1]) left++;
                else break;
            }

            while (right != end && left < right) {
                if (nums[right] == nums[right + 1]) right--;
                else break;
            }
            if (left >= right) break;

            long sum = nums[left] + nums[right];

            if (sum == target){
                ArrayList<Integer> subAnswer = new ArrayList<>(current);
                subAnswer.add(nums[left]);
                subAnswer.add(nums[right]);
                answer.add(subAnswer);
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
