package medium;

public class CountSubmatricesWithAllOnes_1504 {
    // https://leetcode.com/problems/count-submatrices-with-all-ones/description/

    public int numSubmat(int[][] mat) {
        int counter = 0;
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[row].length; col++) {
                if (mat[row][col] == 0) continue;
                counter += helper(mat, row, col);
            }
        }
        return counter;
    }

    private int helper(int[][] mat, int startRow, int startCol) {
        int rows = mat.length, cols = mat[startRow].length;
        int bound = cols;
        int count = 0;
        for (int row = startRow; row < rows; row++) {
            for (int col = startCol; col < bound; col++) {
                if (mat[row][col] == 1) count++;
                else bound = col;
            }
        }
        return count;
    }

}
