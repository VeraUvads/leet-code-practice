package medium;

public class KthSmallestElementInASortedMatrix_378 {
    // https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int min = matrix[0][0];
        int max = matrix[n - 1][n - 1];
        while (min < max) {
            int mid = min + (max - min) / 2;
            int count = countLessOrEqual(matrix, mid);
            if (count < k) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    private int countLessOrEqual(int[][] matrix, int mid) {
        int column = matrix.length - 1;
        int row = 0;
        int count = 0;
        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] <= mid) {
                row++;
                count += column + 1;
            } else {
                column--;
            }

        }
        return count;
    }
}
