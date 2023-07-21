package medium;

public class ProductOfArrayExceptSelf_238 {
    // https://leetcode.com/problems/product-of-array-except-self/description/

    public int[] productExceptSelfWithoutDividerConstantSpace(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        if (n == 0) return answer;
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) zeroCount++;
        }
        if (zeroCount > 1) return new int[n];
        answer[0] = 1;
        for (int i = 1;  i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        int product = 1;
        for (int i = n - 2;  i >= 0; i--) {
            product *= nums[i + 1];
            answer[i] *= product;
        }
        return answer;
    }

    public int[] productExceptSelfWithoutDivider(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        if (n == 0) return answer;
        int[] leftToRight = new int[n];
        int[] rightToLeft = new int[n];
        int zeroCount = 0;
        for (int i = 0;  i < n; i++) {
            if (nums[i] == 0) zeroCount++;
            leftToRight[i] = 1;
            rightToLeft[i] = 1;
        }
        if (zeroCount > 1) return answer;
        for (int i = 1;  i < n; i++) {
            leftToRight[i] = leftToRight[i - 1] * nums[i - 1];
        }
        for (int i = n - 2;  i >= 0; i--) {
            rightToLeft[i] = rightToLeft[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            answer[i] = rightToLeft[i] * leftToRight[i];
        }
        return answer;
    }


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
