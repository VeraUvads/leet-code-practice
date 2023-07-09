package hard;

import java.util.HashMap;

public class MaxPointsOnALine_149 {
    // https://leetcode.com/problems/max-points-on-a-line/description/?envType=featured-list&envId=top-interview-questions

    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;
        int max = 0;
        for (int i = 0; i  < points.length; i++) {
            HashMap<Double, Integer> adj = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j)  continue;
                int[] from = points[i];
                int[] to = points[j];
                Double atan = Math.atan2(to[1] - from[1],  to[0] - from[0]);
                int count = adj.getOrDefault(atan, 1) + 1;
                adj.put(atan, count);
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
