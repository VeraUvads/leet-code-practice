package medium;

public class MinimumPathSum_64 {
    // https://leetcode.com/problems/minimum-path-sum/description/

    // Space O (1)
    public int minPathSum3(int[][] grid) {
        if (grid.length == 0) return 0;
        int rows = grid.length;
        int columns = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (row == 0 && column == 0) {
                    continue;
                }
                if (row == 0) {
                    grid[row][column] = grid[row][column - 1] + grid[row][column];
                    continue;
                }
                if (column == 0) {
                    grid[row][column] = grid[row - 1][column] + grid[row][column];
                    continue;
                }

                grid[row][column] = Math.min(
                        grid[row][column - 1] + grid[row][column],
                        grid[row - 1][column] + grid[row][column]
                );
            }
        }
        return grid[rows - 1][columns - 1];
    }

    // Space O (M) (M - columns count)
    public int minPathSum2(int[][] grid) {
        if (grid.length == 0) return 0;
        int rows = grid.length;
        int columns = grid[0].length;
        int[] dp = new int[columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (row == 0 && column == 0) {
                    dp[column] = grid[row][column];
                    continue;
                }
                if (row == 0) {
                    dp[column] = dp[column - 1] + grid[row][column];
                    continue;
                }
                if (column == 0) {
                    dp[column] = dp[column] + grid[row][column];
                    continue;
                }

                dp[column] = Math.min(
                        dp[column - 1] + grid[row][column],
                        dp[column] + grid[row][column]
                );
            }
        }
        return dp[columns - 1];
    }

    // Space O (NM)
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) return 0;
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (row == 0 && column == 0) {
                    dp[row][column] = grid[row][column];
                    continue;
                }
                if (row == 0) {
                    dp[row][column] = dp[row][column - 1] + grid[row][column];
                    continue;
                }
                if (column == 0) {
                    dp[row][column] = dp[row - 1][column] + grid[row][column];
                    continue;
                }

                dp[row][column] = Math.min(
                        dp[row][column - 1] + grid[row][column],
                        dp[row - 1][column] + grid[row][column]
                );
            }
        }
        return dp[rows - 1][columns - 1];
    }
}
