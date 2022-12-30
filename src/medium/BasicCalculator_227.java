package medium;

import java.util.Stack;


public class BasicCalculator_227 {
    public int calculate(String s) {
        char operation = '+';
        int current = 0, lastNumber = 0, result = 0;
        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            if (Character.isDigit(symbol)) {
                current = current * 10 + symbol - '0';
            }
            if (!Character.isDigit(symbol) && symbol != ' ' || i == s.length() - 1) {
                if (operation == '-' || operation == '+') {
                    result += lastNumber;
                    lastNumber = operation == '-' ? -current : current;
                } else if (operation == '*') {
                    lastNumber = lastNumber * current;
                } else {
                    lastNumber = lastNumber / current;
                }
                operation = symbol;
                current = 0;
            }
        }
        result += lastNumber;
        return result;
    }

    public int calculateStack(String s) {
        Stack<Integer> numbers = new Stack<>();
        int current = 0;
        char prevOperand = '+';
        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            if (Character.isDigit(symbol)) {
                current = current * 10 + symbol - '0';
            }
            if (!Character.isDigit(symbol) && symbol != ' ' || i == s.length() - 1) {
                if (prevOperand == '-') {
                    numbers.add(-current);
                } else if (prevOperand == '+') {
                    numbers.add(current);
                } else if (prevOperand == '*') {
                    numbers.add(numbers.pop() * current);
                } else {
                    numbers.add(numbers.pop() / current);
                }
                current = 0;
                prevOperand = symbol;
            }
        }

        while (numbers.size() > 1) {
            int a = numbers.pop();
            int b = numbers.pop();
            numbers.add(b + a);
        }

        return numbers.pop();
    }
}
