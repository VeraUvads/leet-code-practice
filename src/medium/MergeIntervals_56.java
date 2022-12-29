package medium;

import java.util.*;

public class MergeIntervals_56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> answer = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            while (i < intervals.length && isOverlap(interval, intervals[i])) {
                interval = new int[]{
                        Math.min(interval[0], intervals[i][0]),
                        Math.max(interval[1], intervals[i][1])
                };
                i++;
            }
            i--;
            answer.add(interval);
        }

        return answer.toArray(new int[answer.size()][2]);
    }

    private boolean isOverlap(int[] a, int[] b) {
        return Math.min(a[1], b[1]) - Math.max(a[0], b[0]) >= 0;
    }

    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> answer = new LinkedList<>();

        for (int[] interval : intervals) {
            if (!answer.isEmpty() && isOverlap(interval, answer.getLast())) {
                int[] prev = answer.pollLast();
                interval = new int[]{
                        Math.min(prev[0], interval[0]),
                        Math.max(prev[1], interval[1])
                };
            }
            answer.add(interval);
        }
        return answer.toArray(new int[answer.size()][2]);
    }

}
