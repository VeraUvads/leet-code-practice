package easy;

public class DetermineWhetherMatrixCanBeObtainedByRotation_1886 {
    // https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/description/

    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            rotate(mat);
            if (compare(mat, target)) return true;
        }
        return false;
    }

    private void rotate(int[][] mat) {
        transpose(mat);
        reflect(mat);
    }

    private void transpose(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = i + 1; j < mat.length; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }

    private void reflect(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][n - j - 1];
                mat[i][n - j - 1] = temp;
            }
        }
    }

    private boolean compare(int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j] != target[i][j]) return false;
            }
        }
        return true;
    }
}
