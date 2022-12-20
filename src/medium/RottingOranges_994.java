package medium;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges_994 {
    // https://leetcode.com/problems/rotting-oranges/description/?envType=study-plan&id=level-2

    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        int fresh = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(i);
                    queue.add(j);
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        queue.add(-1);
        while (!queue.isEmpty()) {
            int i = queue.poll();
            if (i == -1) {
                minutes++;
                if (queue.isEmpty()) {
                    break;
                } else {
                    i = queue.poll();
                    queue.add(-1);
                }
            }
            int j = queue.poll();
            for (int[] dir : dirs) {
                int nextI = i + dir[0];
                int nextJ = j + dir[1];
                if (nextI >= grid.length ||
                        nextI < 0 ||
                        nextJ >= grid[i].length ||
                        nextJ < 0
                ) continue;
                if (grid[nextI][nextJ] == 1) {
                    grid[nextI][nextJ] = 2;
                    queue.add(nextI);
                    queue.add(nextJ);
                    fresh--;
                }
            }
        }
        if (fresh != 0) return -1;
        return --minutes;
    }
}
