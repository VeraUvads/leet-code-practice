package medium;

public class BestTimeToBuyAndSellStock_II_122 {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

    // Если покупаем - надо на следующий день продать, поэтому сразу видно.
    // Нет смысла покупить, если это не пойдет в прибыль,
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int balance = 0;
        for (int i = 0; i < len - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                balance += prices[i + 1] - prices[i];
            }
        }
        return balance;
    }

    public int maxProfitOptimized(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int balance = 0;
        for (int i = 0; i < len - 1; i++) {
            balance = Math.max(balance, balance - prices[i] + prices[i + 1]);
        }
        return balance;
    }


    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] - prices[i - 1] + prices[i], dp[i - 1]);
        }
        return Math.max(0, dp[len - 1]);
    }
}
