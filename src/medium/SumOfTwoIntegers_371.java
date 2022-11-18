package medium;

public class SumOfTwoIntegers_371 {
    // https://leetcode.com/problems/sum-of-two-integers/submissions/844431068/

    // Если мы хотим знать где может пройти ситуация 1+1, нам нужно использовать побитовое И (&);
    // Чтобы сохранить это в уме (нужно увеличить все значения слева, если такое произошло), делаем побитовый сдвиг на << 1;
    // Теперь нам нужно определить второе слагаемое. Для 1+1 мы должны записать 0. Для 1+0=1. Для 0+0=0; Значитет используем исключающее ИЛИ ^.
    // Теперь сложим эти два слагаемых. Но у нас опять может случиться ситуация 1+1 и нужно будет держать в уме; Поэтому складываем до тех пор,
    // пока не нужно будет сохранять carry;
    public static int getSum(int a, int b) {
        int carry = (a & b) << 1;
        int second = a ^ b;
        return carry == 0 ? second : getSum(second, carry);
    }

    public static void main(String[] args) {
        System.out.println(getSum(20, 30));
    }
}
