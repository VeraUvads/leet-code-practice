package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class N_Queens_51 {
    // https://leetcode.com/problems/n-queens/description/

    class Solution {
        StringBuilder builder;
        List<List<String>> result;
        int n;
        boolean[] rows;
        boolean[] cols;
        HashSet<Integer> diagonal;
        HashSet<Integer> antiDiagonal;

        public List<List<String>> solveNQueens(int n) {
            this.builder = new StringBuilder();
            this.n = n;
            this.result = new ArrayList<>();
            this.rows = new boolean[n];
            this.cols = new boolean[n];
            this.diagonal = new HashSet<>();
            this.antiDiagonal = new HashSet<>();
            backTracking(new ArrayList<>());
            return result;
        }

        private void backTracking(ArrayList<String> variant) {
            int row = variant.size();
            if (row == n) {
                result.add(new ArrayList<>(variant));
                return;
            }
            for (int col = 0; col < n; col++) {
                if (couldPlace(row, col)) {
                    place(row, col, variant);
                    backTracking(variant);
                    remove(row, col, variant);
                }
            }
        }

        private boolean couldPlace(int row, int col) {
            return !rows[row] && !cols[col] && !diagonal.contains(row - col)
                    && !antiDiagonal.contains(col + row); // and diagonal
        }

        private void place(int row, int col, ArrayList<String> variant) {
            builder.setLength(0);
            for (int answerCol = 0; answerCol < n; answerCol++) {
                if (answerCol == col) {
                    builder.append("Q");
                } else {
                    builder.append(".");
                }
            }
            variant.add(builder.toString());
            rows[row] = true;
            cols[col] = true;
            diagonal.add(row - col);
            antiDiagonal.add(col + row);
        }

        private void remove(int row, int col, ArrayList<String> variant) {
            variant.remove(variant.size() - 1);
            rows[row] = false;
            cols[col] = false;
            diagonal.remove(row - col);
            antiDiagonal.remove(col + row);
        }
    }
}
