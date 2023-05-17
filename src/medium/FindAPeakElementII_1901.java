package medium;

public class FindAPeakElementII_1901 {
    // https://leetcode.com/problems/find-a-peak-element-ii/description/

    int[][] dirs = {{0,1}, {1, 0}, {-1, 0}, {0, -1}};
    int[][] matrix;

    public int[] findPeakGrid(int[][] mat) {
        this.matrix = mat;
        return dfs(0, 0);
    }

    private int[] dfs(int row, int col) {
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            boolean isInBound = newRow < matrix.length && newRow >=0 &&
                    newCol < matrix[newRow].length && newCol >= 0;
            if (!isInBound) continue;
            if (matrix[row][col] < matrix[newRow][newCol]) {
                int[] result = dfs(newRow, newCol);
                if (result != null) return result;
            }
        }
        return new int[]{row, col};
    }
}
