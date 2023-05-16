package medium;

public class GasStation_134 {
    // https://leetcode.com/problems/gas-station/description/
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = 0;
        int cur = 0;
        int deficit = 0;
        for (int i = 0; i < n; i++) {
            int curProfit = gas[i] - cost[i];
            cur += curProfit;
            if (cur < 0) {
                deficit += cur;
                start = i + 1;
                cur = 0;
            }
        }
        if (deficit + cur >= 0) return start;
        return -1;
    }
}
