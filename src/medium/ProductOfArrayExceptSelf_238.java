package medium;

public class ProductOfArrayExceptSelf_238 {
    // https://leetcode.com/problems/product-of-array-except-self/description/

    public int[] productExceptSelf(int[] nums) {
        int  product = 1;
        int[] answer = new int[nums.length];
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                product *= num;
            }
        }
        if (zeroCount > 1) return answer;
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount == 0) {
                answer[i] = product / nums[i];
            } else if (nums[i] == 0)  {
                answer[i] = product;
                return answer;
            }
        }
        return answer;
    }
}
