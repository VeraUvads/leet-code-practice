package medium;

public class MaximumNumberOfFisInAGrid_2658 {
    // https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/

    int[][] grid;
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int findMaxFish(int[][] grid) {
        this.grid = grid;
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                max = Math.max(max, dfs(row, col));
            }
        }
        return max;
    }

    private int dfs(int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length) return 0;
        if (grid[row][col] == 0) return 0;
        int count = grid[row][col];
        grid[row][col] = 0;
        for (int[] dir: dirs) {
            count += dfs(row + dir[0], col + dir[1]);
        }
        return count;
    }
}
