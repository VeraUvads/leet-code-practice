package hard;

import java.util.*;

public class JumpGameIV_1345 {
    // https://leetcode.com/problems/jump-game-iv/description/

    public int minJumps(int[] arr) {
        int size = arr.length;
        if (size <= 1) return 0;
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = size - 1; i >= 0; i--) {
            adj.putIfAbsent(arr[i], new ArrayList<>());
            adj.get(arr[i]).add(i);
        }
        boolean[] visited = new boolean[size];
        int result = size - 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int index = curr[0];
            int steps = curr[1];
            if (index == result) return steps;
            List<Integer> dups = adj.get(arr[index]);
            for (int dup : dups) {
                if (dup == result) return steps + 1;
                if (!visited[dup]) {
                    queue.add(new int[]{dup, steps + 1});
                    visited[dup] = true;
                }
            }
            adj.get(arr[index]).clear();
            if (index > 0 && !visited[index - 1]) {
                queue.add(new int[]{index - 1, steps + 1});
                visited[index - 1] = true;
            }
            if (index < size - 1 && !visited[index + 1]) {
                if (index + 1 == result) return steps + 1;
                queue.add(new int[]{index + 1, steps + 1});
                visited[index + 1] = true;
            }
        }
        return 0;
    }

}
