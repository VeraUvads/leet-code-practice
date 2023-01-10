package medium;

import java.util.*;

public class ThreeSum_15 {
    // https://leetcode.com/problems/3sum/description/

    //  Sorting
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoPointers(-nums[i], nums, i + 1);
            }
        }
        return answer;
    }

    private void twoPointers(int target, int[] nums, int left) {
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                answer.add(Arrays.asList(-target, nums[left++], nums[right--]));
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }


    public List<List<Integer>> threeSumWithoutSorting(int[] nums) {
        Set<List<Integer>> answer = new HashSet<>();
        Set<Integer> dups = new HashSet<>(); // O(n)
        HashMap<Integer, Integer> seen = new HashMap<>();  // O(n)
        for (int i = 0; i < nums.length; i++)  {
            if (dups.add(nums[i])) {
                for (int j = i + 1; j < nums.length; j++)  {
                    int diff = -nums[i] - nums[j];
                    if (seen.containsKey(diff) && seen.get(diff) == i) {
                        List<Integer> list = Arrays.asList(diff, nums[i], nums[j]);
                        Collections.sort(list);
                        answer.add(list);
                    }
                    seen.put(nums[j], i);
                }
            }
        }
        return new ArrayList<>(answer);
    }

}
