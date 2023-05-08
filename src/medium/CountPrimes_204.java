package medium;

public class CountPrimes_204 {
    // https://leetcode.com/problems/count-primes/description/

    public int countPrimes(int n) {
        if (n < 2) return 0;
        boolean[] numbers = new boolean[n + 1];
        numbers[0] = true;
        numbers[1] = true;
        int counter = 0;
        for (int i = 2; i < n; i++) {
            if (!numbers[i]) {
                counter++;
                int a = i;
                while (a + i <= n) {
                    numbers[a + i] = true;
                    a+=i;
                }
            }
        }
        return counter;
    }
}
