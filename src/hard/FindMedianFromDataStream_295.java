package hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream_295 {
    // https://leetcode.com/problems/find-median-from-data-stream/description/
    private PriorityQueue<Integer> largeHeap;
    private PriorityQueue<Integer> minHeap;
    private boolean even = true;

    public FindMedianFromDataStream_295() {
        this.largeHeap = new PriorityQueue<>(Comparator.reverseOrder());
        this.minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (even) {
            largeHeap.add(num);
            minHeap.add(largeHeap.poll());
        } else {
            minHeap.add(num);
            largeHeap.add(minHeap.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if (largeHeap.size() == minHeap.size()){
            return (largeHeap.peek() + minHeap.peek()) / 2.0;
        } else if (largeHeap.size() < minHeap.size()) {
            return minHeap.peek();
        } else {
            return largeHeap.peek();
        }
    }
}
