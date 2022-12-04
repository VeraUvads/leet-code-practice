package medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands_200 {
    // https://leetcode.com/problems/number-of-islands/?envType=study-plan&id=level-1
    public static int numIslands(char[][] grid) {
        Queue<Integer> queue = new LinkedList<>();
        int counter = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    queue.add(i);
                    queue.add(j);
                    grid[i][j] = '0';
                    counter++;
                }
                while (!queue.isEmpty()) {
                    int first = queue.poll();
                    int second = queue.poll();
                    for (int[] direction : directions) {
                        int newFirst = first + direction[0];
                        int newSecond = second + direction[1];
                        if (isLand(newFirst, newSecond, grid)) {
                            queue.add(newFirst);
                            queue.add(newSecond);
                            grid[newFirst][newSecond] = '0';
                        }
                    }
                }
            }
        }
        return counter;
    }

    public static boolean isLand(int first, int second, char[][] grid) {
        boolean isInBorder = first >= 0 && first < grid.length && second >= 0 && second < grid[first].length;
        return isInBorder && grid[first][second] == '1';
    }

    public static void main(String[] args) {
        char[][] array = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {
                '0', '0', '0', '0', '0'}};
        System.out.println(numIslands(array));

        for (char[] first : array) {
            for (char second : first) {
                System.out.print(second + " ");
            }
            System.out.println();
        }
    }
}
