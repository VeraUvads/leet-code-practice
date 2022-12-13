package medium;

public class WhereWillTheBallFall_1706 {
    // https://leetcode.com/problems/where-will-the-ball-fall/?envType=study-plan&id=level-2

    public static int[] findBall(int[][] grid) {
        if (grid.length == 0) return new int[0];
        int[] result = new int[grid[0].length];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }
        for (int column = 0; column < grid[0].length; column++) {
            int curColumn = column;
            for (int[] row : grid) {
                int next = curColumn + row[curColumn];
                if (next < 0 || next > row.length - 1 || row[curColumn] != row[next]) {
                    curColumn = -1;
                    break;
                } else {
                    curColumn = next;
                }
            }
            result[column] = curColumn;
        }
        return result;
    }

}
