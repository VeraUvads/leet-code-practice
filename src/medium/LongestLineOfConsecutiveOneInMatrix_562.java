package medium;

public class LongestLineOfConsecutiveOneInMatrix_562 {
    // https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/description/

    int[][] dirs = {{0,1}, {1,0}, {1,1}, {1, -1}};
    int[][] mat;

    public int longestLine(int[][] mat) {
        this.mat = mat;
        int max = 0;
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[row].length; col++) {
                if (mat[row][col] == 0) continue;
                for (int dirIndex = 0; dirIndex < dirs.length; dirIndex++) {
                    int[] dir = dirs[dirIndex];
                    int prevRow = row - dir[0];
                    int prevCol = col -  dir[1];
                    if (!isInBound(prevRow, prevCol) || mat[prevRow][prevCol] == 0) {
                        max = Math.max(dfs(row, col, dirIndex) + 1, max);
                    }
                }
            }
        }
        return max;
    }

    private int dfs(int row, int col, int dirIndex) {
        int nextRow = row + dirs[dirIndex][0];
        int nextCol = col + dirs[dirIndex][1];
        if (isInBound(nextRow, nextCol) && mat[nextRow][nextCol] == 1) {
            return dfs(nextRow, nextCol, dirIndex) + 1;
        }
        return 0;
    }

    private boolean isInBound(int row, int col) {
        return row >= 0 && row < mat.length && col >= 0 && col < mat[row].length;
    }
}
