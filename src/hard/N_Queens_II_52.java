package hard;

import java.util.HashSet;

public class N_Queens_II_52 {
    // https://leetcode.com/problems/n-queens-ii/description/?envType=study-plan-v2&envId=top-interview-150

    class Solution {
        int size = 0;
        int n;
        boolean[] rows;
        boolean[] cols;
        HashSet<Integer> diagonal;
        HashSet<Integer> antiDiagonal;

        public int totalNQueens(int n) {
            this.n = n;
            this.rows = new boolean[n];
            this.cols = new boolean[n];
            this.diagonal = new HashSet<>();
            this.antiDiagonal = new HashSet<>();
            backTracking(0);
            return size;
        }

        private void backTracking( int row) {
            if (row == n) {
                size++;
                return;
            }
            for (int col = 0; col < n; col++) {
                if (couldPlace(row, col)) {
                    place(row, col);
                    backTracking(row + 1);
                    remove(row, col);
                }
            }
        }

        private boolean couldPlace(int row, int col) {
            return !rows[row] && !cols[col] && !diagonal.contains(row - col)
                    && !antiDiagonal.contains(col + row); // and diagonal
        }

        private void place(int row, int col) {
            rows[row] = true;
            cols[col] = true;
            diagonal.add(row - col);
            antiDiagonal.add(col + row);
        }

        private void remove(int row, int col) {
            rows[row] = false;
            cols[col] = false;
            diagonal.remove(row - col);
            antiDiagonal.remove(col + row);
        }
    }
}
