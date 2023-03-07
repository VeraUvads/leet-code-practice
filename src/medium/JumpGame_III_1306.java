package medium;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame_III_1306 {
    // https://leetcode.com/problems/jump-game-iii/description/
    public boolean canReach(int[] arr, int start) {
        int size = arr.length;
        boolean[] visited = new boolean[size];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (arr[curr] == 0) return true;
            int next = curr + arr[curr];
            int prev = curr - arr[curr];
            if (next < size && !visited[next]) {
                queue.add(next);
                visited[next] = true;
            }
            if (prev >= 0 && !visited[prev]) {
                queue.add(prev);
                visited[prev] = true;
            }
        }
        return false;
    }
}
