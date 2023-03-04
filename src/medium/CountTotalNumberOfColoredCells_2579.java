package medium;

public class CountTotalNumberOfColoredCells_2579 {
    // https://leetcode.com/problems/count-total-number-of-colored-cells/

    public long coloredCells(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        long prev = 1;
        long counter = 4;
        for (int i = 1; i < n; i++) {
            prev += counter;
            counter += 4;
        }
        return prev;
    }
}
