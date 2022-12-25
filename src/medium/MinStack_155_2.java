package medium;

import javafx.util.Pair;

import java.util.Stack;

public class MinStack_155_2 {
    private final Stack<Pair<Integer, Integer>> stack;

    public MinStack_155_2() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty() || stack.peek().getValue() > val) {
            stack.push(new Pair<>(val, val));
        } else {
            stack.push(new Pair<>(val, stack.peek().getValue()));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().getKey();
    }

    public int getMin() {
        return stack.peek().getValue();
    }
}
