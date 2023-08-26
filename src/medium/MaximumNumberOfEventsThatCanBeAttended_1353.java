package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended_1353 {
    // https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/description/

    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, Comparator.comparingInt(a-> a[0]));
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a-> a[1]));
        int day = 0;
        int attended = 0;
        int i = 0;
        while (i < n || !queue.isEmpty()) {
            if (queue.isEmpty()) day = events[i][0];
            while (i < n && day == events[i][0]) {
                queue.add(events[i]);
                i++;
            }
            day++;
            attended++;
            queue.poll();
            while (!queue.isEmpty() && queue.peek()[1] < day) {
                queue.poll();
            }
        }
        return attended;
    }
}
