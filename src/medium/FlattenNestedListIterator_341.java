package medium;

import utils.NestedInteger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
}
