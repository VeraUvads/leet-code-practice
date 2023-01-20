package medium;


import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference_539 {
    // https://leetcode.com/problems/minimum-time-difference/description/

    public static int findMinDifference(List<String> timePoints) {
        int len = timePoints.size();
        int[] times = new int[len];
        for (int i = 0; i < len; i++) {
            times[i] = toTime(timePoints.get(i));
        }
        Arrays.sort(times);
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            answer = Math.min(times[i] - times[i - 1], answer);
        }
        // на случай если различие во времени между первым и последним минимально,
        // а это разные дни, нужно к первому времени добавить 24 часа
        answer = Math.min(answer, Math.abs((24  * 60 + times[0]) - times[len - 1]));
        return answer;
    }

    private static int toTime(String string) {
        int time = ((string.charAt(0) - '0') * 10 + (string.charAt(1) - '0')) * 60;
        time += (string.charAt(3) - '0') * 10 + (string.charAt(4) - '0');
        return time;
    }

    public static void main(String[] args) {
        System.out.print(findMinDifference(Arrays.asList("23:59", "23:59", "00:00", "23:58", "23:30", "23:33", "00:01")));
    }
}
