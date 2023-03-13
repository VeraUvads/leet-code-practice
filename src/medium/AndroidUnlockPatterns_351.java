package medium;

public class AndroidUnlockPatterns_351 {
    // https://leetcode.com/problems/android-unlock-patterns/description/

    public int numberOfPatterns(int m, int n) {
        int passwords = 0;
        boolean[][] grid = new boolean[3][3];
        for(int i = m; i <= n; i++) {
            passwords += backTrack(grid, i - 1, 0) * 4;
            passwords += backTrack(grid, i - 1, 1) * 4;
            passwords += backTrack(grid, i - 1, 4);
        }
        return passwords;
    }

    private int backTrack(boolean[][] grid, int left, int prev) {
        if (left < 0) return 0;
        if (left == 0) return 1;

        grid[prev / 3][prev % 3] = true;
        int passwords = 0;
        for (int i = 0; i < 9; i++) {
            if (couldUse(grid, i, prev)) {
                passwords += backTrack(grid, left - 1, i);
            }
        }
        grid[prev / 3][prev % 3] = false;
        return passwords;
    }

    private boolean couldUse(boolean[][] grid, int number, int prev) {
        int curRow = number / 3;
        int curCol = number % 3;
        if (grid[curRow][curCol]) return false;
        int prevRow = prev / 3;
        int prevCol = prev % 3;


        int diffRow = Math.abs(curRow - prevRow);
        int diffCol = Math.abs(curCol - prevCol);


        if (diffRow <=1 && diffCol <= 1) return true;
        boolean isDiametrical = diffRow == 2 && diffCol == 2;
        boolean isOneColumn = diffRow == 2 && prevCol == curCol;
        boolean isOneRow = diffCol == 2 && prevRow == curRow;

        if (isDiametrical || isOneColumn || isOneRow){
            int newRow = (curRow + prevRow) / 2;
            int newCol = (curCol + prevCol) / 2;
            return grid[newRow][newCol];
        }

        return true;
    }



}
