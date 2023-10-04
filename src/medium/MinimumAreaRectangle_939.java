package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumAreaRectangle_939 {
    // https://leetcode.com/problems/minimum-area-rectangle/description/

    public int minAreaRect(int[][] points) {
        if (points.length < 4) return 0;
        HashMap<Integer, List<Integer>> pointsByX = new HashMap<>();
        for (int[] point : points) {
            int x = point[0], y = point[1];
            pointsByX.putIfAbsent(x, new ArrayList<>());
            pointsByX.get(x).add(y);
        }
        int minArea = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                if (x1 == x2 || y1 == y2) continue;

                if (pointsByX.get(x1).contains(y2) && pointsByX.get(x2).contains(y1)) {
                    int area = Math.abs(x1 - x2) * Math.abs(y1 - y2);
                    minArea = Math.min(minArea, area);
                }
            }
        }
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }

}
