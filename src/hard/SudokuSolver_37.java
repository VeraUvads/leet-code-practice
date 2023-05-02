package hard;

public class SudokuSolver_37 {
    // https://leetcode.com/problems/sudoku-solver/description/

    int[][] rows = new int[9][10];
    int[][] columns = new int[9][10];
    int[][] boxes = new int[9][10];
    char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;
        fill(board);
        backTrack(0, 0);
    }

    private boolean backTrack(int row, int col) {
        if (row == 9 && col == 0) return true;
        int nextCol = (col + 1) % 9;
        int nextRow = row;
        if (nextCol == 0) nextRow++;
        if (board[row][col] != '.') {
            return backTrack(nextRow, nextCol);
        }
        for (int i = 1; i < 10; i++) {
            if (couldPlace(row, col, i)) {
                place(row, col, i);
                if (backTrack(nextRow, nextCol)) return true;
                remove(row, col, i);
            }
        }
        return false;
    }


    private void place(int row, int col, int number) {
        rows[row][number]++;
        columns[col][number]++;
        boxes[row / 3 * 3 + col / 3][number]++;
        board[row][col] = Character.forDigit(number, 10);
    }

    private void remove(int row, int col, int number) {
        rows[row][number]--;
        columns[col][number]--;
        boxes[row / 3 * 3 + col / 3][number]--;
        board[row][col] = '.';
    }

    private boolean couldPlace(int row, int col, int number) {
        return rows[row][number] == 0 &&
                columns[col][number] == 0 &&
                boxes[row / 3 * 3 + col / 3][number] == 0;
    }


    private void fill(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char symbol = board[row][col];
                if (symbol == '.') continue;
                int current = symbol - '0';
                place(row, col, current);
            }
        }
    }
}
