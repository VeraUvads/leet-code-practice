package medium;

public class NumberOfClosedIslands_1254 {
    // https://leetcode.com/problems/number-of-closed-islands/description/
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][] grid;
    public int closedIsland(int[][] grid) {
        this.grid = grid;
        int n = grid.length, m = grid[0].length;
        for (int row = 0; row < n; row++) {
            dfs(row, 0);
            dfs(row, m - 1);
        }
        for (int col = 0; col < m; col++) {
            dfs(0, col);
            dfs(n - 1, col);
        }
        int count = 0;
        for (int row = 0; row < n;  row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 0) {
                    count++;
                    dfs(row, col);
                }
            }
        }


        return count;
    }

    private void dfs(int row, int col) {
        if (isOutOfBounds(row,col)) return;
        if (grid[row][col] == 0) {
            grid[row][col] = 1;
            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                dfs(newRow, newCol);
            }
        }
    }

    boolean isOutOfBounds(int row, int col){
        return row == grid.length || row < 0 || col < 0 || col == grid[row].length;
    }
}
