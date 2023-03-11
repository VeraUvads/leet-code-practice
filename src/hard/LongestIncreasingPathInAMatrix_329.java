package hard;

import java.util.Arrays;

public class LongestIncreasingPathInAMatrix_329 {
    // https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/
    int[][] dirs = {{1, 0},  {-1, 0}, {0, 1}, {0, -1}};
    int[][] memo;
    int[][] matrix;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int rows =  matrix.length, columns = matrix[0].length;
        this.memo = new int[rows][columns];
        this.matrix = matrix;
        int answer = 0;

        for (int row = 0; row < rows; row++) {
            Arrays.fill(memo[row], -1);
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++)  {
                if (memo[row][col] == -1) {
                    memo[row][col] = 1;
                    answer = Math.max(dfs(row, col), answer);
                }

            }
        }

        return answer;
    }
    /*
    [9,9,4],
    [6,6,8],
    [2,1,1]


    [ 1, 1, 2],
    [-1,-1, 1],
    [-1,-1,-1]
    */
    private int dfs (int row, int col) {
        // answer = Math.max(answer, deep);
        int maxDeep = 1;
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (isInBound(newRow, newCol) && matrix[row][col] < matrix[newRow][newCol]) {
                if (memo[newRow][newCol] == -1) {
                    maxDeep = Math.max(maxDeep, dfs(newRow, newCol) + 1);
                } else {
                    maxDeep = Math.max(maxDeep, memo[newRow][newCol] + 1);
                }
            }
        }
        memo[row][col] = maxDeep;
        return maxDeep;
    }

    private boolean isInBound(int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
