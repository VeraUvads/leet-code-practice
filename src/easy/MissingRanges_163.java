package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRanges_163 {
    // https://leetcode.com/problems/missing-ranges/description/?envType=featured-list&envId=top-interview-questions

    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;
        List<List<Integer>> answer = new ArrayList<>();
        if (n == 0) {
            answer.add(Arrays.asList(lower, upper));
            return answer;
        }
        if (lower < nums[0]) {
            answer.add(Arrays.asList(lower, nums[0] - 1));
        }

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < lower || nums[i] > upper || nums[i] == nums[i + 1] - 1) continue;
            answer.add(Arrays.asList(nums[i] + 1, nums[i + 1] - 1));
        }

        if (upper > nums[n - 1]) {
            answer.add(Arrays.asList(nums[n - 1] + 1, upper));
        }
        return answer;
    }

}
