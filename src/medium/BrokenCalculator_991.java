package medium;

public class BrokenCalculator_991 {
    //https://leetcode.com/problems/broken-calculator/editorial/

    /**
     * Пока можно умножать надо умножать - это всегда быстрее чем добавлять 1.
     * Нужно идти с конца и жадно делить на 2, пока можем, а если target не делится нацело, то вычитаем
     *
     */
    public int brokenCalc(int startValue, int target) {
        int answer = 0;
        while (target > startValue) {
            if (target % 2 == 1) {
                target++;
            } else {
                target/=2;
            }
            answer++;
        }
        return answer + (startValue - target);
    }
}
