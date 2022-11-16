package medium;

public class SumOfTwoIntegers_371 {
    public static int getSum(int a, int b) {
        int carry = (a & b) << 1;
        int second = a ^ b;
        return b == 0 ? a : getSum(second, carry);
    }

    public static void main(String[] args) {
        System.out.println(getSum(20, 30));
    }
}
