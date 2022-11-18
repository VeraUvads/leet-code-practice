package medium.not_finshed;

public class SuperPow_372 {
    // not finished

    static int MOD = 1337;

//    public static int superPow(int a, int[] b) {
//        if (a == 1 || a == 0) return a;
//        int result = 1;
//        a %= MOD;
//        for (int i = 0; i < b.length; i++) {
//            int digit = b.length - 1 - i;
//            int pow = (int) ((long) b[i] * Math.pow(10, digit)) % MOD;
//            int inPow = (int) (((long) Math.pow(a, pow)) % MOD);
//            result = (result * inPow) % MOD;
//        }
//        return result;
//    }

    public static int superPow(int a, int[] b) {
        if (a == 1 || a == 0) return a;
        int result = 1;
        a %= MOD;
        int pow = 0;
        for (int i = 0; i < b.length; i++) {
            int digit = b.length - 1 - i;
            pow += (int) (((long) b[i] * (Math.pow(10, digit) % MOD)) % MOD);
        }

        int inPow = (int) (((long) Math.pow(a, pow)) % MOD);
        result = (result * inPow) % MOD;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(superPow(2147483647, new int[]{2, 0, 0}));
    }
}
