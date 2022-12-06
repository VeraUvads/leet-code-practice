package medium;

import java.util.Arrays;

public class UniquePaths_62 {
    // https://leetcode.com/problems/unique-paths/description/?envType=study-plan&id=level-1

    public static int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for (int[] row : grid){
            Arrays.fill(row, 1);
        }

        for (int row = 1; row < grid.length; row++) {
            for (int column = 1; column < grid[row].length; column++) {
                grid[row][column] = grid[row - 1][column] + grid[row][column - 1];
            }
        }

        return grid[m - 1][n - 1];
    }


    public static int uniquePathsRecursive(int m, int n) {
        if (m == 1 || n == 1) return 1;
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }


    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }
}
