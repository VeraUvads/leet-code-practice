package easy;

public class Sqrtx_69 {
    // https://leetcode.com/problems/sqrtx/description/

    public static void main(String[] args) {
        System.out.println(mySqrt(3));
    }

    public static int mySqrt(int x) {
        if (x == 1 || x == 0) return x;
        int start = 0, end = x;
        while (start < end) {
            int mid = start + ((end - start) / 2);
            int divider = x / mid;
            if (mid > divider) {
                end = mid - 1;
            } else {
                start = mid + 1;
                if (start > x / start) {
                    return mid;
                }
            }
        }
        return start;
    }
}
