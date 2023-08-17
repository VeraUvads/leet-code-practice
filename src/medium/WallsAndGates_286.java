package medium;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates_286 {
    // https://leetcode.com/problems/walls-and-gates/description/
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) queue.add(new int[]{i,j});
            }
        }
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                int[] curr = queue.poll();
                for (int[] dir : dirs) {
                    int newRow = curr[0] + dir[0];
                    int newCol = curr[1] + dir[1];
                    if (newRow < 0 ||
                            newCol < 0 ||
                            newRow == rooms.length ||
                            newCol == rooms[newRow].length ||
                            rooms[newRow][newCol] != Integer.MAX_VALUE) continue;
                    rooms[newRow][newCol]  = level + 1;
                    queue.add(new int[]{newRow, newCol});
                }
                size--;
            }
            level++;
        }
    }
}
