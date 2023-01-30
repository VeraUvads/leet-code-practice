package easy;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber_136 {
    // https://leetcode.com/problems/single-number/description/?envType=study-plan&id=level-3

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public int singleNumberSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int num : nums) {
            if (set.add(num)) {
                res += num;
            } else {
                res -= num;
            }
        }
        return res;
    }
}
