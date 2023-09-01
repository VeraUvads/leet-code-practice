package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCostToHireKWorkers_857 {
    // https://leetcode.com/problems/minimum-cost-to-hire-k-workers/
    public double mincostToHireWorkers(int[] qualities, int[] wages, int max) {
        if (max == 0) return 0.0;
        if (max == 1) return Arrays.stream(wages).min().getAsInt();
        int n = qualities.length;
        double[][] sorted = new double[n][3];
        for (int i = 0; i < n; i++) {
            sorted[i][1] = (double) wages[i];
            sorted[i][2] = (double) qualities[i];
            sorted[i][0] = sorted[i][1] / sorted[i][2];
        }
        Arrays.sort(sorted, Comparator.comparingDouble(a-> a[0]));
        PriorityQueue<Double> queue = new PriorityQueue<>();
        double sum = 0.0;
        double answer = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            double[] curr = sorted[i];
            double k = curr[0], wage = curr[1], quality = curr[2];
            sum += quality;
            queue.add(-quality);
            if (queue.size() == max) {
                answer = Math.min(answer, sum * k);
                sum += queue.poll();
            }
        }
        return answer;
    }
}
