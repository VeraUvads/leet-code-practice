package medium;

public class FactorialTrailingZeroes_172 {
    // https://leetcode.com/problems/factorial-trailing-zeroes/description/

    public int trailingZeroesMostEfficient(int n) { // log5(O)
        int zeroes = 0;
        while (n > 0) {
            n /= 5;
            zeroes += n;
        }
        return zeroes;
    }

    public int trailingZeroes(int n) { // O(n)
        int powerOfFive = 0;
        int zeroes = 0;
        for (int i = 5; i <= n; i += 5) {
            zeroes++;
            powerOfFive++;
            int currentPower = powerOfFive;
            while (currentPower >= 5 && currentPower % 5 == 0) {
                currentPower /= 5;
                zeroes++;
            }
        }
        return zeroes;
    }
}
