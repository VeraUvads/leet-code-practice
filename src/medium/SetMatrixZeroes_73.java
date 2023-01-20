package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes_73 {
    // https://leetcode.com/problems/set-matrix-zeroes/description/

    public static void setZeroes(int[][] matrix) {
        boolean isFirstColumn = false;
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                isFirstColumn = true;
            }
            for (int column = 1; column < matrix[row].length; column++) {
                if (matrix[row][column] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][column] = 0;
                }
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            for (int column = 1; column < matrix[row].length; column++) {
                if (matrix[row][0] == 0 || matrix[0][column] == 0) {
                    matrix[row][column] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            Arrays.fill(matrix[0], 0);
        }
        if (isFirstColumn) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }
    }

    public static void setZeroesNotOptimal(int[][] matrix) {
        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroColumns = new HashSet<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == 0) {
                    zeroRows.add(row);
                    zeroColumns.add(column);
                }
            }
        }
        for (int row : zeroRows) {
            Arrays.fill(matrix[row], 0);
        }
        if (zeroRows.size() == matrix.length) return;
        for (int column : zeroColumns) {
            for (int[] row : matrix) {
                row[column] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
