package medium;

import java.util.Random;

public class RandomPickWithWeight_528 {
    // https://leetcode.com/problems/random-pick-with-weight/description/
    private int sum = 0;
    private final int[] weights;
    private final Random random = new Random();

    public RandomPickWithWeight_528(int[] weights) {
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            weights[i] = sum;
        }
        this.weights = weights;
    }

    public int pickIndex() {
        int target = random.nextInt(sum) + 1;  //  не понимаю почему диапазон от 1
        int left = 0;
        int right = weights.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (weights[mid] == target) {
                return mid;
            } else if (weights[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
