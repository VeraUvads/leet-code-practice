package hard;

import java.util.Stack;

public class BasicCalculator_224 {
    // https://leetcode.com/problems/basic-calculator/description/?envType=study-plan-v2&envId=top-interview-150

    public int calculate(String s) {
        Stack<Integer> numbers = new Stack();
        int builder = 0;
        int result = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            if (Character.isDigit(symbol)) {
                builder = builder * 10 + symbol - '0';
            } else if (symbol == '+') {
                result += sign * builder;
                builder = 0;
                sign = 1;
            } else if (symbol == '-') {
                result += sign * builder;
                builder = 0;
                sign = -1;
            } else if (symbol == '(') {
                numbers.add(result);
                numbers.add(sign);
                sign = 1;
                result = 0;
            } else if (symbol == ')') {
                result += builder * sign;
                builder = 0;
                result *= numbers.pop();
                result += numbers.pop();
            }
        }
        return result + sign * builder;
    }
}
