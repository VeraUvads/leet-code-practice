package medium;

import java.util.HashSet;

public class NextClosestTime_681 {
    // https://leetcode.com/problems/next-closest-time/description/

    private final int MOD = 60 * 24;

    public String nextClosestTime(String time) {
        int minutes = toMinutes(time);
        HashSet<Integer> digits = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            if (i == 2) continue;
            digits.add(time.charAt(i) - '0');
        }
        int[] nextTime = new int[4];
        while (true) {
            minutes = (minutes + 1) % MOD;
            nextTime[0] = minutes / 60 / 10;
            nextTime[1] = minutes / 60 % 10;
            nextTime[2] = minutes % 60 / 10;
            nextTime[3] = minutes % 60 % 10;
            boolean isValid = true;
            for (int i = 0; i < 4; i++) {
                if (!digits.contains(nextTime[i])) {
                    isValid = false;
                    break;
                }
            }
            if (isValid){
                return "" + nextTime[0] + nextTime[1] + ":" + nextTime[2] + nextTime[3];
            }
        }
    }


    int toMinutes(String time) {
        int hours = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
        int mins = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
        return hours * 60 + mins;
    }
}
