package medium;

public class ValidSudoku_36 {
    // https://leetcode.com/problems/valid-sudoku/description/

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][10];
        int[][] columns = new int[9][10];
        int[][] boxes = new int[9][10];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char symbol = board[row][col];
                if (symbol == '.') continue;
                int current = symbol - '0';
                if (rows[row][current]++ != 0) return false;
                if (columns[col][current]++ != 0) return false;
                int boxNumber = (row / 3) * 3 + col / 3;
                if (boxes[boxNumber][current]++ != 0) return false;
            }
        }
        return true;
    }
}
