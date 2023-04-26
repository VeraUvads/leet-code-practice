package medium;

import utils.NestedInteger;

import java.util.*;

public class FlattenNestedListIterator_341 {
    // https://leetcode.com/problems/flatten-nested-list-iterator/description/
    public class NestedIterator implements Iterator<Integer> {
        private Queue<Integer> queue;

        public NestedIterator(List<NestedInteger> nestedList) {
            queue = new LinkedList<>();
            fillQueue(nestedList);
        }

        private void fillQueue(List<NestedInteger> nestedList) {
            for (NestedInteger nestedInt : nestedList) {
                if (nestedInt.isInteger()) {
                    queue.add(nestedInt.getInteger());
                } else {
                    fillQueue(nestedInt.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return queue.poll();
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }


    public class NestedIterator2 implements Iterator<Integer> {
        private Stack<NestedInteger> stack;

        public NestedIterator2(List<NestedInteger> nestedList) {
            this.stack = new Stack<>();
            add(nestedList);
        }

        private void add(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.add(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            if (stack.isEmpty()) return false;
            NestedInteger next = stack.peek();
            if (next.isInteger()) {
                return true;
            }
            add(stack.pop().getList());
            return hasNext();
        }
    }
}
