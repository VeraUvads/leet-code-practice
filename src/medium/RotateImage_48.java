package medium;

public class RotateImage_48 {
    // https://leetcode.com/problems/rotate-image/description/

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int start = 0;
        int end = n - 1;
        while (start < end){
            for (int i = start; i < end; i++) {
                int top = matrix[start][i];

                int right = matrix[i][end];
                matrix[i][end] = top;

                int bottom = matrix[end][n - i - 1];
                matrix[end][n - i - 1] = right;

                int left = matrix[n - i - 1][start];
                matrix[n - i - 1][start] = bottom;

                matrix[start][i] = left;
            }
            start++;
            end--;
        }
    }

    // SECOND APPROACH

    public void rotateWithTransposeReflect(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }

    private void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++)  {
            for (int j = i + 1; j < matrix.length; j++) {  // 0 1 <-> 1 0
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++)  { // строка
            for (int j = 0; j < n / 2; j++) { // столбец
                int temp = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
