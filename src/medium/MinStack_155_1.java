package medium;

import java.util.Stack;

public class MinStack_155_1 {
    private Stack<Integer> stack;
    private Stack<Integer> max;

    public MinStack_155_1() {
        stack = new Stack<>();
        max = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (max.isEmpty() || val <= max.peek()) {
            max.push(val);
        }
    }

    public void pop() {
        if (stack.pop().equals(max.peek())) {
            max.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return max.peek();
    }
}
