package hard;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings_317 {
    // https://leetcode.com/problems/shortest-distance-from-all-buildings/description/

    class Solution {
        int[][] dirs = {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};
        int[][] grid;
        int[][] total;

        public int shortestDistance(int[][] grid) {
            this.grid = grid;
            this.total = new int[grid.length][grid[0].length];
            int counter = 0;
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[row].length; col++) {
                    if (grid[row][col] == 1) {
                        bfs(row, col);
                        counter++;
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for (int row = 0; row < total.length; row++) {
                for (int col = 0; col < total[row].length; col++) {
                    if (grid[row][col] != -counter) continue;
                    min = Math.min(min, total[row][col]);
                }
            }
            return min == Integer.MAX_VALUE ? -1 : min;
        }

        private void bfs(int row, int col) {
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            visited[row][col] = true;
            queue.add(new int[]{row, col, 0});
            int level = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size != 0) {
                    int[] curr = queue.poll();
                    row = curr[0];
                    col = curr[1];
                    total[row][col] += level;
                    for (int[] dir : dirs) {
                        int newRow = row + dir[0], newCol = col + dir[1];
                        if (newRow >= 0 && newRow < grid.length
                                && newCol >= 0 && newCol < grid[0].length
                                && !visited[newRow][newCol]
                                && grid[newRow][newCol] <= 0
                        ) {
                            visited[newRow][newCol] = true;
                            grid[newRow][newCol]--;
                            queue.add(new int[]{newRow, newCol});
                        }
                    }
                    size--;
                }
                level++;
            }
        }
    }
}
