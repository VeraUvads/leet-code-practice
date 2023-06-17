package medium;

public class Pow_x_n_50 {
    //  https://leetcode.com/problems/powx-n/description/?envType=featured-list&envId=top-interview-questions

    /**
     2^100=(2*2)^50
     4^50=(4*4)^25
     16^25=16*(16)^24
     */
    public double myPow(double x, long n) {
        if (x == 0 || x == 1) return x;
        double result = 1;
        if (n < 0) {
            n *=- 1;
            x = 1.0 / x;
        }
        while (n != 0) {
            if (n % 2 == 1) {
                result *= x;
                n--;
            }
            x *= x;
            n /= 2;
        }
        return result;
    }
}

