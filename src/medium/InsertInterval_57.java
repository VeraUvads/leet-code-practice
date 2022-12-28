package medium;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval_57 {
    // https://leetcode.com/problems/insert-interval/description/?envType=study-plan&id=level-2

    public int[][] insert(int[][] intervals, int[] newInterval) {
        intervals = insertInterval(intervals, newInterval);

        List<int[]> answer = new ArrayList<>();
        for (int pointer = 0; pointer < intervals.length; pointer++) {
            int[] interval = intervals[pointer];
            while (pointer < intervals.length && isOverlap(interval, intervals[pointer])) {
                interval = new int[] {
                        Math.min(interval[0], intervals[pointer][0]),
                        Math.max(interval[1], intervals[pointer][1])
                };
                pointer++;
            }
            pointer--;
            answer.add(interval);
        }
        return answer.toArray(new int[answer.size()][2]);
    }

    private int[][] insertInterval(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        boolean isInserted = false;
        for (int[] interval : intervals) {
            if (!isInserted && newInterval[0] < interval[0]) {
                list.add(newInterval);
                isInserted = true;
            }
            list.add(interval);
        }

        if (!isInserted) list.add(newInterval);
        return list.toArray(new int[list.size()][2]);
    }

    private boolean isOverlap(int[] a, int[] b) {
        return Math.min(a[1], b[1]) - Math.max(a[0], b[0]) >= 0;
    }
}
