package medium;

public class AndroidUnlockPatterns_351 {

    int passwords = 0;

    public int numberOfPatterns(int m, int n) {
        backTrack(new boolean[3][3], m, n, 0, -1);
        return passwords;
    }

    private void backTrack(boolean[][] grid, int m, int n, int count, int prev) {
        if (count > n) return;
        if (count >= m) {
            passwords++;
        }
        for (int i = 0; i < 9; i++) {
            boolean res = couldUse(grid, i, prev);

            if (res) {
                grid[i / 3][i % 3] = true;
                backTrack(grid, m, n, count + 1, i);
                grid[i / 3][i % 3] = false;
            }
        }
    }

    private boolean couldUse(boolean[][] grid, int number, int prev) {
        int curRow = number / 3;
        int curCol = number % 3;
        if (grid[curRow][curCol]) return false;
        if (prev == -1) return true;
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
