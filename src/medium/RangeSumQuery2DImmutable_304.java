package medium;

public class RangeSumQuery2DImmutable_304 {
    // https://leetcode.com/problems/range-sum-query-2d-immutable/description/

    class NumMatrix { //O (MN) + O(1)
        /**
         1 2 3     1 3  6    1 3  6
         4 5 6``   4 9  15   5 12 21
         7 8 9     7 15 24  12 27 45
         */
        int[][] memo;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            if (m == 0) return;
            int n = matrix[0].length;
            memo = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    memo[i+1][j +1] = memo[i + 1][j] + memo[i][j + 1] + matrix[i][j] - memo[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return memo[row2 + 1][col2 + 1] - memo[row2 + 1][col1] - memo[row1][col2 + 1]+memo[row1][col1];
        }
    }
    class NumMatrix2 { // O(MN) + O(m)
        int[][] memo;

        public NumMatrix2(int[][] matrix) {
            int m = matrix.length;
            if (m == 0) return;
            int n = matrix[0].length;
            memo = new int[m][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    memo[i][j + 1] = memo[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int row = row1; row <= row2; row++) {
                sum += memo[row][col2 + 1] - memo[row][col1];
            }
            return sum;
        }
    }

}
