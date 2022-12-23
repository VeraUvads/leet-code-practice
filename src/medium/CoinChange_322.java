package medium;

import java.util.Arrays;

public class CoinChange_322 {

    public static int coinChange(int[] coins, int amount) {
        if (coins.length == 0) return 0;
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i < max; i++) {
            for (int coin : coins) {
                if (coin > i) continue;
                int ifWeTake = dp[i - coin] + 1; // складываем сколько монеток было если мы возьмем эту монетку
                // тоесть, то сколько нужно было монет, пока мы ее не взяли + 1 (так как взяли
                dp[i] = Math.min(dp[i], ifWeTake);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        coinChange(new int[]{1, 2, 5}, 11);
    }
}
