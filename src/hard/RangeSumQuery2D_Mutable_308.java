package hard;

public class RangeSumQuery2D_Mutable_308 {
    // https://leetcode.com/problems/range-sum-query-2d-mutable/description/
    class NumMatrix {
        int[][] trees;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0) throw new RuntimeException("");
            trees = new int[matrix.length + 1][matrix[0].length + 1];
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    trees[row + 1][col + 1] = trees[row + 1][col] + matrix[row][col];
                }
            }
        }

        public void update(int row, int col, int val) {
            int was = sumRegion(row, col, row, col);
            int diff = val - was;
            for (int i = col + 1; i < trees[row].length; i++) {
                trees[row + 1][i] += diff;
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int row = row1 + 1; row <= row2 + 1; row++) {
                sum += trees[row][col2 + 1] - trees[row][col1];
            }
            return sum;
        }

        /**
         6 3  6 9
         2 0  8 9
         21 - 14 + 6 = 7 + 6

         [3, 2, 1],      3  3  4  8  10
         [5, 6, 3],      8  14 18 24 27  (5  11 14 16 17 )
         [1, 2, 0],      9  17 21 28 36   (1  3  3  4  9)
         */
    }

}
