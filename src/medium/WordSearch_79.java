package medium;

public class WordSearch_79 {
    // https://leetcode.com/problems/word-search/description/
    private final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private char[][] board;
    private String word;
    private boolean possible = false;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (possible) return true;
                dfs(0, row, column);
            }
        }
        return possible;
    }

    private void dfs(int index, int row, int column) {  // with backTracking
        if (row < 0 || row >= board.length || column < 0 || column >= board[row].length) return;
        if (word.charAt(index) != board[row][column]) return;
        if (index == word.length() - 1) possible = true;
        if (possible) return;
        board[row][column] = '#';
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = column + dir[1];
            dfs(index + 1, newRow, newCol);
        }
        board[row][column] = word.charAt(index);
    }
}
