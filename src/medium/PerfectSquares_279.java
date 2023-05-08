package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares_279 {
    // https://leetcode.com/problems/perfect-squares/description/

    public int numSquares(int n) {
        int counter = 1;
        LinkedList<Integer> squares = new LinkedList<>();
        for (int i = 1; i * i <= n; ++i) {
            int square = i * i;
            if (square == n) return counter;
            squares.add(square);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size != 0) {
                int remainder = queue.poll();
                for (int square : squares) {
                    int newRemainder = remainder - square;
                    if (newRemainder == 0) return counter;
                    if (newRemainder > 0) queue.add(newRemainder);
                }
                size--;
            }
            counter++;
        }

        return counter;
    }

    public int numSquaresDP(int n) {
        int[] dp = new int[n + 1];
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            if (square == n) return 1;
            squares.add(square);
            dp[square] = 1;
        }
        for (int i = 1; i <= n; i++) {
            if (dp[i] != 0) {
                for (int square : squares) {
                    if (i + square > n) break;
                    if (dp[i + square] == 0) {
                        dp[i + square] = dp[i] + 1;
                    } else {
                        dp[i + square] = Math.min(dp[i] + 1, dp[i + square]);
                    }
                }
            }
        }
        return dp[n];
    }
}
