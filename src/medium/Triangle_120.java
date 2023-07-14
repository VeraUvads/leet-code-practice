package medium;

import java.util.Collections;
import java.util.List;

public class Triangle_120 {
    // https://leetcode.com/problems/triangle/description/?envType=study-plan-v2&envId=top-interview-150
    /**
     * from top to bottom, updating each number to be the sum of itself
     * + the MINIMUM out of the two numbers above it.
     */

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;
        for (int row = 1; row < triangle.size(); row++) {
            int size = triangle.get(row).size();
            for (int col = 0; col < size; col++) {
                int cur;
                if (col == 0) {
                    int prev = triangle.get(row - 1).get(col);
                    cur = triangle.get(row).get(col) + prev;
                } else if (col == size - 1) {
                    int prev = triangle.get(row - 1).get(col - 1);
                    cur = triangle.get(row).get(col) + prev;
                } else {
                    int prev1 = triangle.get(row - 1).get(col - 1);
                    int prev2 = triangle.get(row - 1).get(col);
                    cur = Math.min(prev1, prev2) + triangle.get(row).get(col);
                }
                triangle.get(row).set(col, cur);
            }
        }
        return Collections.min(triangle.get(triangle.size() - 1));
    }
}
