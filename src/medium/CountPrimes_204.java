package medium;

public class CountPrimes_204 {
    // https://leetcode.com/problems/count-primes/description/

    public int countPrimes(int n) {
        if (n < 2) return 0;
        boolean[] numbers = new boolean[n + 1];
        int counter = 0;
        for (int i = 2; i < n; i++) {
            if (!numbers[i]) {
                counter++;
                for (int j = i * 2; j < n; j= j + i) {
                    numbers[j] = true;
                }
            }
        }
        return counter;
    }

    public int countPrimesOptimal(int n) {
        if (n < 2) return 0;
        boolean[] numbers = new boolean[n + 1];
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (!numbers[i]) {
                for (int j = i * 2; j < n; j= j + i) {
                    numbers[j] = true;
                }
            }
        }

        int numberOfPrimes = 0;
        for (int i = 2; i < n; i++) {
            if (!numbers[i]) {
                ++numberOfPrimes;
            }
        }
        return numberOfPrimes;
    }
}
