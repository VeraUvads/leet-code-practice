package medium;

import java.util.*;

public class PacificAtlanticWaterFlow_417 {
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int rows = heights.length;
        if (rows == 0) return result;
        int columns = heights[0].length;

        Queue<Integer> pacific = new LinkedList<>();
        Queue<Integer> atlantic = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == 0 || j == 0) {
                    pacific.add(i);
                    pacific.add(j);
                }
                if (j == columns - 1 || i == rows - 1) {
                    atlantic.add(i);
                    atlantic.add(j);
                }
            }
        }

        boolean[][] pacificReachable = bfs(pacific, heights);
        boolean[][] atlanticReachable = bfs(atlantic, heights);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private boolean[][] bfs(Queue<Integer> queue, int[][] heights) {
        boolean[][] reachable = new boolean[heights.length][heights[0].length];
        while (!queue.isEmpty()) {
            int row = queue.poll();
            int column = queue.poll();
            reachable[row][column] = true;
            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newColumn = column + dir[1];
                if (newRow < 0 ||
                        newColumn < 0 ||
                        newRow == heights.length ||
                        newColumn == heights[0].length ||
                        reachable[newRow][newColumn]) continue;
                if (heights[newRow][newColumn] >= heights[row][column]) {
                    queue.add(newRow);
                    queue.add(newColumn);
                    reachable[newRow][newColumn] = true;
                }
            }
        }
        return reachable;
    }

}
