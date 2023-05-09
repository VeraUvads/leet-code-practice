package medium;

import java.util.*;

public class UglyNumberII_264 {
    // https://leetcode.com/problems/ugly-number-ii/description/
    public int nthUglyNumberDP(int n) {
        int[] dp = new int[n];
        int p2 = 0, p3 = 0, p5 = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int mult2 = dp[p2] * 2;
            int mult3 = dp[p3] * 3;
            int mult5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(mult2, mult3), mult5);
            if (dp[i] == mult2) p2++;
            if (dp[i] == mult3) p3++;
            if (dp[i] == mult5) p5++;
        }
        return dp[n - 1];
    }

    public int nthUglyNumberNotOptimal(int n) {
        List<Long> primes = Arrays.asList(1L, 2L, 3L, 5L);
        int counter = 0;
        PriorityQueue<Long> queue = new PriorityQueue<>(primes);
        Set<Long> visited = new HashSet<>(primes);
        while (true) {
            long ugly = queue.poll();
            counter++;
            if (counter == n) return (int) ugly;
            System.out.println(ugly);
            for (long prime : primes) {
                long newUgly = prime * ugly;
                if (!visited.add(newUgly)) continue;
                queue.add(newUgly);
                if (counter == n) return (int) newUgly;
            }
        }
    }
}
