package medium;

import java.util.Arrays;

public class MeetingRoomsII_253 {
    // https://leetcode.com/problems/meeting-rooms-ii/description/

    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        int[] starts = new int[len];
        int[] ends = new int[len];
        for (int i = 0; i < len; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int ans = 0, counter = 0;
        int startPointer = 0;
        int endPointer = 0;
        while (endPointer < len && startPointer < len) {
            if (starts[startPointer] < ends[endPointer]) {
                startPointer++;
                counter++;
            } else {
                endPointer++;
                counter--;
            }
            ans = Math.max(ans, counter);
        }

        return ans;
    }
}
