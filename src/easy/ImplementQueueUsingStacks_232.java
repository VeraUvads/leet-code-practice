package easy;

import java.util.Stack;

public class ImplementQueueUsingStacks_232 {

    static class MyQueue {
        private final Stack<Integer> normalStack;
        private final Stack<Integer> revertStack;

        public MyQueue() {
            normalStack = new Stack<>();
            revertStack = new Stack<>();
        }

        public void push(int x) {
            normalStack.add(x);
        }

        public int pop() {
            if (revertStack.isEmpty()) {
                while (!normalStack.isEmpty()) {
                    revertStack.add(normalStack.pop());
                }
            }
            return revertStack.pop();
        }

        public int peek() {
            if (revertStack.isEmpty()) {
                while (!normalStack.isEmpty()) {
                    revertStack.add(normalStack.pop());
                }
            }
            return revertStack.peek();
        }

        public boolean empty() {
            return revertStack.isEmpty() && normalStack.isEmpty();
        }
    }
}
