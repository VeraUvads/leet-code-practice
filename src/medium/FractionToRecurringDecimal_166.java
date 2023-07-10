package medium;

import java.util.HashMap;

public class FractionToRecurringDecimal_166 {
    // https://leetcode.com/problems/fraction-to-recurring-decimal/description/?envType=featured-list&envId=top-interview-questions
    public String fractionToDecimal(int dividend, int divisor) {
        if (dividend == 0 || divisor == 1) return String.valueOf(dividend);
        StringBuilder builder = new StringBuilder();
        if (dividend < 0 ^ divisor < 0) {
            builder.append("-");
        }
        long numerator = Math.abs(Long.valueOf(dividend));
        long denominator = Math.abs(Long.valueOf(divisor));
        long total = numerator / denominator;
        long remainder =  numerator % denominator;
        builder.append(total);
        if (remainder == 0) return builder.toString();
        builder.append(".");
        HashMap<Long, Integer> numbers = new HashMap<>();
        while (remainder != 0) {
            if (numbers.containsKey(remainder)) {
                builder.insert(numbers.get(remainder), "(");
                builder.append(")");
                break;
            }
            numbers.put(remainder, builder.length());
            remainder *= 10;
            builder.append(remainder / denominator);
            remainder %= denominator;
        }
        return builder.toString();
    }
}
