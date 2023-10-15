package medium;

import java.util.ArrayList;

public class MyCalendar_II_731 {
    // https://leetcode.com/problems/my-calendar-ii/
    class MyCalendarTwo {
        private ArrayList<int[]> booked;
        private ArrayList<int[]> overlaps;

        public MyCalendarTwo() {
            this.booked = new ArrayList<>();
            this.overlaps = new ArrayList<>();
        }

        private boolean hasIntersection(int[] first, int[] second) {
            return Math.min(first[1], second[1]) - Math.max(first[0], second[0]) > 0;
        }

        public boolean book(int start, int end) {
            int[] current = new int[]{start, end};

            for (int[] overlapped : overlaps) { // [2,3] add [0,1]
                if (hasIntersection(current, overlapped)) {
                    return false;
                }
            }
            for (int[] old : booked) { // [2,3] add [0,1]
                if (hasIntersection(current, old)) {
                    int[] overlapped = new int[]{Math.max(current[0], old[0]), Math.min(current[1], old[1])};
                    overlaps.add(overlapped);
                }
            }

            booked.add(current);
            return true;
        }
    }
}
