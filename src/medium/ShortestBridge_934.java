package medium;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge_934 {
    // https://leetcode.com/problems/shortest-bridge/
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

    public int shortestBridge(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    markOneIsland(row, col, grid, queue);
                    return bfs(grid, queue);
                }
            }
        }
        return -1;
    }

    private void markOneIsland(int row, int col, int[][] grid, Queue<int[]> queue) {
        if (row < 0 || col < 0 || row  == grid.length || col == grid[row].length) return;
        if (grid[row][col] != 1) return;
        grid[row][col] = 2;
        queue.add(new int[]{row,col, 0});
        for (int[] dir : dirs) {
            markOneIsland(row + dir[0], col + dir[1], grid, queue);
        }
    }

    private int bfs(int[][] grid, Queue<int[]> queue)  {
        int level = 0;
        while (!queue.isEmpty())   {
            int size = queue.size();
            while (size != 0) {
                int[] curr = queue.poll();
                for (int[] dir : dirs) {
                    int newRow = curr[0] + dir[0];
                    int newCol = curr[1] + dir[1];
                    if (newRow < 0
                            || newRow == grid.length
                            || newCol < 0
                            || newCol == grid[newRow].length
                            || grid[newRow][newCol] == 2) continue;
                    if (grid[newRow][newCol] == 1) return level;
                    grid[newRow][newCol] = 2;
                    queue.add(new int[]{newRow, newCol});
                }
                size--;
            }
            level++;
        }
        return -1;
    }
}
