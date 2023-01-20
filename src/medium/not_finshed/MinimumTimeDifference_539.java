package medium.not_finshed;


import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference_539 {
    public static int findMinDifference(List<String> timePoints) {
        int minDiff = Integer.MAX_VALUE;

        timePoints.sort((a, b) -> {
            return toTime(a) - toTime(b);
        });
        for (int i = 1; i < timePoints.size(); i++) {
            minDiff = Math.min(Math.abs(toTime(timePoints.get(i)) - toTime(timePoints.get(i-1))), minDiff);
        }
//        for (String point : timePoints) {
//            System.out.print(" " + point);
//        }
        return minDiff;
    }

    private static int toTime(String string) {
        int time;
        if (string.charAt(0) == '0' && string.charAt(1) == '0') {
            time = 24 * 60;
        } else {
            time = ((string.charAt(0) - '0') * 10 + (string.charAt(1) - '0')) * 60;
        }
        time += (string.charAt(3) - '0') * 10 + (string.charAt(4) - '0');
        return time;
    }

    public static void main(String[] args) {
        System.out.print(findMinDifference(Arrays.asList("23:59", "23:59", "00:00", "23:58", "23:30", "23:33", "00:01")));
    }
}
