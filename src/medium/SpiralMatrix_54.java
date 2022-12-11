package medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {
    // https://leetcode.com/problems/spiral-matrix/description/

    public static List<Integer> spiralOrderWithDirs(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) return list;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int left = -1, up = -1,  bottom = matrix.length, right = matrix[0].length;
        int row = 0, column = 0;
        int currentDir = 0;
        while (row != up && row != bottom && column != left && column != right) {
            list.add(matrix[row][column]);

            row += dirs[currentDir][0];
            column += dirs[currentDir][1];

            if (row == up || row == bottom || column == left || column == right) {

                row -= dirs[currentDir][0];
                column -= dirs[currentDir][1];

                if (currentDir == 0) {
                    up = row;
                    currentDir++;
                } else if (currentDir == 1) {
                    right = column;
                    currentDir++;
                } else if (currentDir == 2) {
                    bottom = row;
                    currentDir++;
                } else {
                    left = column;
                    currentDir = 0;
                }

                row += dirs[currentDir][0];
                column += dirs[currentDir][1];
            }
        }
        return list;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rowLen = matrix.length;
        if (rowLen == 0) return list;
        int columnLen = matrix[0].length;
        int row = 0, column = -1;
        int direction = 1;
        while (columnLen !=  0 && rowLen != 0) {
            for (int i = 0; i < columnLen; i++) {
                column += direction;
                list.add(matrix[row][column]);
            }
            rowLen--;
            for (int i = 0; i < rowLen; i++) {
                row += direction;
                list.add(matrix[row][column]);
            }
            columnLen--;
            direction *= -1;
        }
        return list;
    }

    public static void main(String[] args) {
        spiralOrder(new int[][]{{1, 2, 3,4}, {5,6,7,8}, {9,10,11,12}});
    }
}
