package medium.not_finshed;

public class Four_Keys_Keyboard_651 {
    // https://leetcode.com/problems/4-keys-keyboard/description/
    public int maxA(int n) {
        if (n < 4) return n;
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }

        for (int i = 0; i <= n - 3; i++) {
            for (int j = i + 3; j <= n; j++) {
                dp[j] = dp[i - 3] * 2;
            }
        }
        // dp[0] = 0;
        // dp[1] = 1;
        // int maxInBuffer = 0;
        // int copyFrom = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 0; j < i - 3; j++) {
                if (dp[j] * 2 > dp[i]) {
                    dp[i] = dp[j] * 2;
                }
            }
            // if (i <= 4) {
            //     dp[i] = dp[i - 1] + 1;
            //     System.out.print(" A ");
            // } else {
            //     // _ A  A   A   A
            //     // _ A (A) (C) (V) -> A A
            //     // 0 1  2   3   4
            //     int ctrlACV = dp[i - 3] * 2;
            //     int addA = dp[i - 1] + 1;
            //     if (dp[i - 3] > maxInBuffer) {
            //         copyFrom = i - 3;
            //         maxInBuffer = dp[i - 3];
            //         System.out.print(" CtrlACV ");
            //     } else {
            //         System.out.print(" CtrlV ");
            //     }
            //     int maxBuf = dp[i - 1] + maxInBuffer;
            //     // System.out.println("a "+ a + " ctrl "+ ctrl);

            //     dp[i] = Math.max(Math.max(ctrlACV, addA), maxBuf);
            //     System.out.print(" "+dp[i] +" ");

            // }
            // System.out.println(dp[i] + " ");
        }
        return dp[n];
    }
}
