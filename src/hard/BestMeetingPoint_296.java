package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestMeetingPoint_296 {
    // https://leetcode.com/problems/best-meeting-point/description/

    public int minTotalDistanceSort(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    rows.add(row);
                    cols.add(col);
                }
            }
        }
        Collections.sort(cols);
        int row = rows.get(rows.size() / 2);
        int col = cols.get(cols.size() / 2);
        int result = 0;
        for (int source : rows) {
            result += Math.abs(row - source);
        }
        for (int source : cols) {
            result += Math.abs(col - source);
        }
        return result;
    }

    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    rows.add(row);
                }
            }
        }

        for (int col = 0; col < grid[0].length; col++) {
            for (int row = 0; row < grid.length; row++) {
                if (grid[row][col] == 1) {
                    cols.add(col);
                }
            }
        }
        Collections.sort(cols);
        int row = rows.get(rows.size() / 2);
        int col = cols.get(cols.size() / 2);
        int result = 0;
        for (int source : rows) {
            result += Math.abs(row - source);
        }
        for (int source : cols) {
            result += Math.abs(col - source);
        }
        return result;
    }
}
