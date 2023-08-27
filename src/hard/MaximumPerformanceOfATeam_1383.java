package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumPerformanceOfATeam_1383 {
    // https://leetcode.com/problems/maximum-performance-of-a-team/description/

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int mod = (int) Math.pow(10, 9) + 7;
        int[][] nodes = new int[n][2];
        for (int i = 0; i < n; i++) {
            nodes[i][0] = speed[i];
            nodes[i][1] = efficiency[i];
        }
        Arrays.sort(nodes, Comparator.comparingInt(a-> -a[1]));
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a-> a[0]));
        long sum = 0;
        long max = 0;
        for (int[] node : nodes) {
            if (queue.size() == k) {
                sum -= queue.poll()[0];
            }
            queue.add(node);
            sum += node[0];
            long curr = sum *  node[1];
            max = Math.max(max, curr);
        }
        return (int) (max % mod);
    }
}
