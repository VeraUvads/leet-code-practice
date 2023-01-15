package medium.not_finshed;

import java.util.Random;

public class RandomPickWithWeight_528 {
    // https://leetcode.com/problems/random-pick-with-weight/description/
    class Solution {
        private final int[] weights;
        private final Random random = new Random();
        private double sum = 0.0;

        public Solution(int[] weights) {
            this.weights = weights;
            for (int weight : weights) {
                sum += weight;
            }
        }

        public int pickIndex() {
            int index = random.nextInt(weights.length);
            double probability = (weights[index] / sum);
            return (int) (index *  probability);
        }
    }
}
