package easy;

public class FibonacciNumber_509 {
    // https://leetcode.com/problems/fibonacci-number/description/?envType=study-plan&id=level-1


    public int fib(int n) {
        if (n == 1 || n == 0) return n;
        return fib(n - 1) + fib(n - 2);
    }

    public int fibDP(int n) {
        if (n == 1 || n == 0) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int fibIterative(int n) {
        if (n == 1 || n == 0) return n;
        int first = 0;
        int second = 1;
        for (int i = 2; i < n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
