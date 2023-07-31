package medium;

public class SpiralMatrixII_59 {
    // https://leetcode.com/problems/spiral-matrix-ii/
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int number = 1;
    int dirNum = 0;
    int[][] answer;

    public int[][] generateMatrix(int n) {
        answer = new int[n][n];
        dfs(0, 0);
        return answer;
    }

    private void dfs(int row, int col) {
        if (isOutOfBounds(row, col)) return;
        if (answer[row][col] != 0) return;
        answer[row][col] = number++;
        int nextRow = row + dirs[dirNum][0], nextCol = col + dirs[dirNum][1];
        if (isOutOfBounds(nextRow, nextCol) || answer[nextRow][nextCol] != 0) {
            dirNum = (dirNum + 1) % 4;
            nextRow = row + dirs[dirNum][0];
            nextCol = col + dirs[dirNum][1];
        }
        dfs(nextRow, nextCol);
    }


    private boolean isOutOfBounds(int row, int col) {
        return row == answer.length || row < 0 || answer[row].length == col || col < 0;
    }
}
