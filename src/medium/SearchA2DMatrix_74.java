package medium;

public class SearchA2DMatrix_74 {
    // https://leetcode.com/problems/search-a-2d-matrix/description/

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int columnLength = matrix[0].length;
        int start = 0;
        int end = matrix.length * columnLength - 1;

        while (start <= end) {
            int pivot = (start + end) / 2;
            int row = pivot / columnLength;
            int column = pivot % columnLength;
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] > target) {
                end = pivot - 1;
            } else if (matrix[row][column] < target) {
                start = pivot + 1;
            }
        }
        return false;
    }
}
