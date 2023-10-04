package hard;

public class MaximalRectangle_85 {
    // https://leetcode.com/problems/maximal-rectangle/
    Integer[][] memo;
    char[][] matrix;
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        this.memo = new Integer[m][n];
        this.matrix = matrix;

        int max = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int result = countRectAreaFromThisPoint(row, col);
                max = Math.max(max, result);
            }
        }
        return max;
    }

    private int countRectAreaFromThisPoint(int row, int startCol) {
        int currentRows = Integer.MAX_VALUE;
        int currentCols = 0;
        int max = 0;
        for (int col = startCol; col < matrix[0].length; col++) {
            if (matrix[row][col] == '0') return max;
            currentCols++;
            currentRows = Math.min(currentRows, countRows(row, col));
            max = Math.max(currentCols * currentRows, max);
        }
        return max;
    }

    private int countRows(int row, int col) {
        if (row < 0 || col < 0 || row == matrix.length || col == matrix[0].length) return 0;
        if (matrix[row][col] == '0') return 0;
        if (memo[row][col] != null) return memo[row][col];
        int result = countRows(row + 1, col) + 1;
        memo[row][col]= result;
        return result;
    }
}
