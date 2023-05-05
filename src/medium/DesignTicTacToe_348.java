package medium;

public class DesignTicTacToe_348 {
    // https://leetcode.com/problems/design-tic-tac-toe/description/

    private int[] rows;
    private int[] columns;
    private int[] diagonal;
    private int n;

    public DesignTicTacToe_348(int n) {
        rows = new int[n];
        columns = new int[n];
        diagonal = new int[2];
        this.n = n;
    }
    /**
     0 1 2
     3 4 5
     6 7 8

     0  1  2  3
     4  5  6  7
     8  9  10 11
     12 13 14 15
     */

    public int move(int row, int col, int player) {
        int sign = 1;
        if (player == 2) {
            sign *= -1;
        }

        rows[row] += sign;
        columns[col]+= sign;
        if (row == col) {
            diagonal[0] += sign;
            System.out.println(diagonal[0]);
        }
        if (row == n - col - 1) { // 0 2 // 1 1
            diagonal[1] += sign;
        }
        boolean isWinner = Math.abs(rows[row]) == n ||
                Math.abs(columns[col]) == n ||
                Math.abs(diagonal[0]) == n ||
                Math.abs(diagonal[1]) == n;
        return isWinner ? player : 0;
    }
}
