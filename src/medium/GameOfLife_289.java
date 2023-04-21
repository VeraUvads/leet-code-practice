package medium;

public class GameOfLife_289 {
    // https://leetcode.com/problems/game-of-life/

    int[][] dirs = {{0,1},{1,0},{1,1},{0,-1},{-1,0}, {-1,-1}, {-1, 1}, {1,-1}};
    public void gameOfLife(int[][] board) {
        if (board.length == 0) return;
        int m = board.length, n = board[0].length;
        int[][] answer = new int[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int live = 0;
                int dead = 0;
                for (int[] dir : dirs) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (inBounds(board, newRow, newCol)) {
                        if (board[newRow][newCol] == 0) {
                            dead++;
                        } else {
                            live++;
                        }
                    }
                }
                if (board[row][col] == 1 && (live < 2 || live > 3)) {
                    answer[row][col] = 0;
                } else if (board[row][col] == 0 && live == 3) {
                    answer[row][col] = 1;
                } else {
                    answer[row][col] = board[row][col];
                }
            }
        }
        for (int row = 0; row < m; row++) {
            System.arraycopy(answer[row], 0, board[row], 0, n);
        }
    }

    boolean inBounds(int[][] board, int row, int col) {
        return row < board.length && row >= 0 && col >= 0 && col < board[row].length;
    }
}
