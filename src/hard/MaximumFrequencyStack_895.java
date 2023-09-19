package hard;

import java.util.HashMap;
import java.util.Stack;

public class MaximumFrequencyStack_895 {
    // https://leetcode.com/problems/maximum-frequency-stack/description/
    class FreqStack {
        HashMap<Integer, Stack<Integer>> frequency;
        HashMap<Integer, Integer> map;
        int maxFreq = 0;

        public FreqStack() {
            this.frequency = new HashMap<>();
            this.map = new HashMap<>();
        }

        public void push(int val) {
            int currFreq = map.getOrDefault(val, 0) + 1;
            map.put(val, currFreq);
            frequency.putIfAbsent(currFreq, new Stack<>());
            frequency.get(currFreq).add(val);
            maxFreq = Math.max(maxFreq, currFreq);
        }

        public int pop() {
            Stack<Integer> stack = frequency.get(maxFreq);
            int popped = stack.pop();
            if (stack.isEmpty()) {
                maxFreq--;
            }

            int currFreq = map.getOrDefault(popped, 0) - 1;
            map.put(popped, currFreq);
            return popped;
        }
    }
}
