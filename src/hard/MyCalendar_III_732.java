package hard;

import java.util.TreeMap;

public class MyCalendar_III_732 {
    // https://leetcode.com/problems/my-calendar-iii/description/
    class MyCalendarThree {
        TreeMap<Integer, Integer> delta;

        public MyCalendarThree() {
            delta = new TreeMap<>();
        }

        public int book(int startTime, int endTime) {
            delta.put(startTime, delta.getOrDefault(startTime, 0) + 1);
            delta.put(endTime, delta.getOrDefault(endTime, 0) - 1);
            int max = 0;
            int active = 0;
            for (int d : delta.values()) {
                active += d;
                max = Math.max(active, max);
            }
            return max;
        }
    }
}
