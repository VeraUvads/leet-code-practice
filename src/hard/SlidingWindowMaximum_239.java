package hard;

import java.util.ArrayDeque;

public class SlidingWindowMaximum_239 {
    // https://leetcode.com/problems/sliding-window-maximum/description/

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1 || nums.length == 0) return nums;
        int[] max = new int[nums.length - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            add(deque, nums[i]);
        }
        max[0] = deque.getFirst();
        for (int i = 1, j = k; j < nums.length; j++) {
            if (nums[i - 1] == deque.getFirst()){
                deque.poll();
            }
            add(deque, nums[j]);
            max[i] = deque.getFirst();
            i++;
        }
        return max;
    }

    private void add(ArrayDeque<Integer> deque, int num) {
        while(!deque.isEmpty() && deque.getLast() < num) {
            deque.removeLast();
        }
        deque.add(num);
    }

}
