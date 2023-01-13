package medium;

import java.util.ArrayList;

//  https://leetcode.com/problems/divide-two-integers/description/
public class DivideTwoIntegers_29 {


    // 3 APPROACH
    public int divide(int dividend, int divisor) { // O(log(n))
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int sign = 1;
        if (divisor > 0) {
            sign *= -1;
            divisor = -divisor;
        }
        if (dividend > 0) {
            sign *= -1;
            dividend = -dividend;
        }
        if (dividend > divisor) return 0;
        ArrayList<Integer> counters = new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();

        int halfMin = Integer.MIN_VALUE / 2;

        int value = divisor;
        int counter = 1;
        counters.add(counter);
        values.add(value);
        while (value >= halfMin && value + value >= dividend) {
            counter += counter;
            value += value;
            counters.add(counter);
            values.add(value);
        }
        dividend -= value;

        for (int i = counters.size() - 1; i >= 0; i--) {
            value = values.get(i);
            if (value >= dividend) {
                dividend -= value;
                counter += counters.get(i);
            }
            if (dividend >= 0) break;
        }
        return counter * sign;
    }

    // 2 APPROACH
    public int divideExponential(int dividend, int divisor) {   // O(log^2(n))
        int ans = 0;
        int sign = 1;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (divisor > 0) {
            sign *= -1;
            divisor = -divisor;
        }
        if (dividend > 0) {
            sign *= -1;
            dividend = -dividend;
        }

        int halfMin = Integer.MIN_VALUE / 2;

        while (divisor >= dividend)  { // O(log(n))
            int value = divisor;
            int counter = 1;
            while (value >= halfMin && value + value >= dividend) {    // O(log(n))
                counter *= 2;
                value += value;
            }
            ans += counter;
            dividend -= value;
        }
        return ans * sign;
    }

    // 1 APPROACH
    // will not pass Big tests
    public int divideLinear(int dividend, int divisor) {
        int ans = 0;
        int sign = 1;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (divisor > 0) {
            sign *= -1;
            divisor = -divisor;
        }
        if (dividend > 0) {
            sign *= -1;
            dividend = -dividend;
        }

        while (dividend - divisor <= 0)  {
            ans++;
            dividend -= divisor;
        }
        return ans * sign;
    }

    public static void main(String[] args) {
        System.out.println(-2147483648 - -2147483648);
    }
}
