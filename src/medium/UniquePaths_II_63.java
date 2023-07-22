package medium;

public class UniquePaths_II_63 {
    public int uniquePathsWithObstaclesDP(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        if (grid[n - 1][m - 1] == 1 || grid[0][0] == 1) return 0;
        grid[0][0] = 1;
        for (int col = 1; col < m; col++) {
            if (grid[0][col] == 1) grid[0][col] = 0;
            else grid[0][col] = grid[0][col - 1];
        }
        for (int row = 1; row < n; row++) {
            if (grid[row][0] == 1) grid[row][0] = 0;
            else grid[row][0] = grid[row - 1][0];
        }
        for (int row = 1; row < n; row++) {
            for (int col = 1; col < m; col++) {
                if (grid[row][col] == 1) grid[row][col] = 0;
                else grid[row][col] = grid[row - 1][col] + grid[row][col - 1];
            }
        }
        return grid[n - 1][m  - 1];
    }

    class Solution {
        int[][] grid;
        Integer[][] memo;
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            this.grid = obstacleGrid;
            int n = grid.length, m = grid[0].length;
            this.memo = new Integer[n][m];
            if (grid[n - 1][m - 1] == 1) return 0;
            int result = backTrack(0, 0);
            return memo[0][0] == null ? result : memo[0][0];
        }

        private int backTrack(int row, int col) {
            if (row == grid.length - 1 && col == grid[row].length - 1) {
                return 1;
            }
            if (row < 0 || row == grid.length || col < 0 || col == grid[row].length) {
                return 0;
            }
            if (grid[row][col] == 1) return 0;
            if (memo[row][col] != null) return memo[row][col];
            grid[row][col] = 1;
            int toLeft = backTrack(row + 1, col);
            int toRight = backTrack(row, col + 1);
            grid[row][col] = 0;
            memo[row][col] = toLeft + toRight;
            return memo[row][col];
        }
    }

}
