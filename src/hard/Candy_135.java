package hard;

public class Candy_135 {
    // https://leetcode.com/problems/candy/description/?envType=study-plan-v2&envId=top-interview-150
    class SolutionTwoArrays {
        public int candy(int[] ratings) {
            int n = ratings.length;
            int[] left2Right = new int[n];
            left2Right[0] = 1;
            for (int i = 1; i < n; i++) {
                if (ratings[i - 1] >= ratings[i]) {
                    left2Right[i] = 1;
                } else {
                    left2Right[i] = left2Right[i - 1] + 1;
                }
            }
            int[] right2Left = new int[n];
            right2Left[n - 1] = 1;
            for (int i = n - 2; i >= 0; i--) {
                if (ratings[i + 1] >= ratings[i]) {
                    right2Left[i] = 1;
                } else {
                    right2Left[i] = right2Left[i + 1] + 1;
                }
            }
            int candies = 0;
            for (int i = 0; i < n; i++) {
                candies+= Math.max(right2Left[i], left2Right[i]);
            }
            return candies;
        }
    }

    class SolutionOneArrayThreePass {
        public int candy(int[] ratings) {
            int n = ratings.length;
            int[] candies = new int[n];
            candies[0] = 1;
            for (int i = 1; i < n; i++) {
                if (ratings[i - 1] >= ratings[i]) {
                    candies[i] = 1;
                } else {
                    candies[i] = candies[i - 1] + 1;
                }
            }
            for (int i = n - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    candies[i] = Math.max(candies[i], candies[i + 1] + 1);
                }
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += candies[i];
            }
            return count;
        }
    }
}
