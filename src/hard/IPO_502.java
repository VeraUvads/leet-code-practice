package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO_502 {
    // https://leetcode.com/problems/ipo/description/?envType=study-plan-v2&envId=top-interview-150
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = profits[i];
            projects[i][1] = capital[i];
        }
        Arrays.sort(projects, Comparator.comparingInt(a-> a[1]));

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a-> -a[0]));
        int lastAdded = 0;
        while (k != 0) {
            k--;
            while (lastAdded < n && projects[lastAdded][1] <= w) {
                queue.add(projects[lastAdded++]);
            }
            if (queue.isEmpty()) break;
            w += queue.poll()[0];
        }
        return w;
    }
}
