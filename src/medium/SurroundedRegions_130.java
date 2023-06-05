package medium;

public class SurroundedRegions_130 {
    //https://leetcode.com/problems/surrounded-regions/description/
    char[][] board;
    int[][] dirs = {{0,1},{1,0}, {-1,0},{0,-1}};

    public void solve(char[][] board) {
        int n = board.length;
        if (n == 0) return;
        int m = board[0].length;
        this.board = board;

        for (int row = 0; row < n; row++) {
            markNonFlipped(row, 0);
            markNonFlipped(row, m - 1);
        }
        for (int col = 0; col < m; col++) {
            markNonFlipped(0, col);
            markNonFlipped(n - 1, col);
        }
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (board[row][col] == 'O') board[row][col] = 'X';
                if (board[row][col] == 'T') board[row][col] = 'O';
            }
        }
    }

    private void markNonFlipped(int row, int col) {
        if (isOutOfBounds(row,col)) return;
        if (board[row][col] == 'O') {
            board[row][col] = 'T';
            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                markNonFlipped(newRow, newCol);
            }
        }
    }


    boolean isOutOfBounds(int row, int col){
        return row == board.length || row < 0 || col < 0 || col == board[row].length;
    }
}
