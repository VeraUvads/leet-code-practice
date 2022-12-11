package easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight_1046 {
    // https://leetcode.com/problems/last-stone-weight/description/
    public static int lastStoneWeight(int[] stones) {
        int len = stones.length;
        if (len == 0) return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            queue.add(stone);
        }
        while (queue.size() > 1) {
            int first = queue.remove();
            int second = queue.remove();
            int result = Math.abs(first - second);
            if (result != 0) queue.add(result);
        }
        return queue.isEmpty() ? 0 : queue.remove();
    }

    public int lastStoneWeightBucket(int[] stones) {
        int len = stones.length;
        int max = 0;
        for (int stone : stones) {
            max = Math.max(max,  stone);
        }
        int[] bucket = new int[max + 1];
        for (int stone : stones) {
            bucket[stone]++;
        }
        int previous = 0;
        int currentWeight = max;
        while (currentWeight > 0) {
            if (bucket[currentWeight] == 0) {
                currentWeight--;
            } else if (previous == 0) {
                bucket[currentWeight] = bucket[currentWeight] % 2;
                if (bucket[currentWeight] == 1) {
                    bucket[currentWeight]--;
                    previous = currentWeight;
                }
                currentWeight--;
            } else {
                bucket[currentWeight]--;
                int result = Math.abs(previous - currentWeight);
                if (result > currentWeight) {
                    previous = result;
                } else {
                    bucket[result]++;
                    previous = 0;
                }
            }
        }

        return previous;
    }

    public static void main(String[] args) {
        lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1});
    }
}
