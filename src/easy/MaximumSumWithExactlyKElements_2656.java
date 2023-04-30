package easy;

import java.util.Arrays;

public class MaximumSumWithExactlyKElements_2656 {

    public int maximizeSum(int[] nums, int k) {
        if (nums.length == 0) return 0;
        int max =  Arrays.stream(nums).max().getAsInt();
        int answer = 0;
        while (k != 0) {
            answer += max;
            max++;
            k--;
        }
        return answer;
    }
}
