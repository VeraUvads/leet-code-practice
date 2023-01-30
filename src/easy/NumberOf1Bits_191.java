package easy;

public class NumberOf1Bits_191 {
    // https://leetcode.com/problems/number-of-1-bits/description/

    public int hammingWeight(int n) {
        int counter = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((mask & n) != 0) {
                counter++;
            }
            // n = n >> 1; // так тоже можно
            mask = mask << 1;
        }
        return counter;
    }

    public int hammingWeightOptimized(int n) {
        int counter = 0;
        while (n != 0) {
            counter++;
            n = (n - 1) & n;
        }
        return counter;
    }
}
