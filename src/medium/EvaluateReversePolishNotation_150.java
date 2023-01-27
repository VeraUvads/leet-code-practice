package medium;

import java.util.Stack;

public class EvaluateReversePolishNotation_150 {
    // https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                int result = evaluate(numbers.pop(), numbers.pop(), token);
                numbers.add(result);
            } else {
                numbers.add(Integer.valueOf(token));
            }
        }
        return numbers.pop();
    }

    private int evaluate(int first, int second, String operator) {
        switch (operator) {
            case "+":
                return first + second;
            case "-":
                return second - first;
            case "*":
                return second * first;
            default:
                return second / first;
        }
    }

    private boolean isOperator(String token) {
        switch (token) {
            case "+":
            case "-":
            case "*":
            case "/":
                return true;
        }
        return false;
    }
}
