package medium;

public class Reverse_Integer_7 {
    // https://leetcode.com/problems/reverse-integer/description/

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (
                    result > Integer.MAX_VALUE / 10 ||
                            (result == Integer.MAX_VALUE / 10 && pop > 7) ||
                            result < Integer.MIN_VALUE / 10 ||
                            (result == Integer.MIN_VALUE / 10 && pop < -8)
            ) return 0;
            result = result * 10 + pop;
        }
        return result;
    }
}
