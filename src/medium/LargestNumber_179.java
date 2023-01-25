package medium;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber_179 {
    // https://leetcode.com/problems/largest-number/description/

    public String largestNumber(int[] nums) {
        String[] result = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(
                result,
                new Comparator<String>() {
                    @Override
                    public int compare(String a, String b) {
                        String first = a + b;
                        String second = b + a;
                        return second.compareTo(first);
                    }
                }
        );
        if (result[0].equals("0")) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        for (String num : result) {
            builder.append(num);
        }
        return builder.toString();
    }
}
