package medium;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInMaze_1926 {

    // https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/




    public static int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        if (rows == 0) return -1;
        int columns = maze[0].length;
        if (columns == 0) return -1;

        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]] = '+';

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int distance = current[2];

            for (int[] dirrection : directions) {
                int currentRow = current[0] + dirrection[0];
                int currentColumn = current[1] + dirrection[1];
                if (isAvailable(currentRow, currentColumn, maze)) {
                    if (isOnBounds(currentRow, currentColumn, maze)) {
                        return distance + 1;
                    }

                    queue.add(new int[]{currentRow, currentColumn, distance + 1});
                    maze[currentRow][currentColumn] = '+';
                }
            }
        }
        return -1;
    }

    private static boolean isOnBounds(int row, int column, char[][] maze) {
        return row == 0 ||
                row == maze.length - 1 ||
                column == 0 ||
                column == maze[0].length - 1;
    }

    private static boolean isAvailable(int row, int column, char[][] maze) {
        return isInBounds(row, column, maze) && maze[row][column] == '.';
    }

    private static boolean isInBounds(int row, int column, char[][] maze) {
        return row >= 0 && row < maze.length &&
                column >= 0 && column < maze[0].length;
    }

    public static void main(String[] args) {
        System.out.println(nearestExit(
                new char[][]{
                        new char[]{'+', '+', '.', '+'},
                        new char[]{'.', '.', '.', '+'},
                        new char[]{'+', '+', '+', '.'}
                }, new int[]{1, 2}
        ));
    }
}
