package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms_III_2402 {
    // https://leetcode.com/problems/meeting-rooms-iii/description/
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a-> a[0]));
        int[] booked = new int[n];
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) rooms.add(i);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        for (int[] meeting : meetings) {
            while (!queue.isEmpty() && queue.peek()[1] <= meeting[0]) {
                int[] freed = queue.poll();
                rooms.add(freed[2]);
            }
            if (rooms.size() == 0) {
                int[] freed = queue.poll();
                rooms.add(freed[2]);
                int dur = meeting[1] - meeting[0];
                meeting[0] = freed[1];
                meeting[1] = meeting[0] + dur;
            }
            int nextRoom = rooms.poll();
            booked[nextRoom]++;
            queue.add(new int[]{meeting[0], meeting[1], nextRoom});
        }
        int max = 0;
        for (int i = 0; i < booked.length; i++) {
            if (booked[max] < booked[i]) max = i;
        }
        return max;
    }
}
