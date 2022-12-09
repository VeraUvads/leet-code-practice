package easy;

import java.util.ArrayList;
import java.util.List;

public class MovingAverage_346 {

    private final List<Integer> data;
    private final int windowSize;
    private int windowSum = 0;

    public MovingAverage_346(int size) {
        windowSize = size;
        data = new ArrayList<>();
    }

    public double next(int val) {
        data.add(val);
        if (data.size() <= windowSize) {
            windowSum += val;
        } else {
            windowSum = windowSum - data.get(data.size() - windowSize - 1) + val;
        }
        int divider = Math.min(windowSize, data.size());
        return (double) windowSum / divider;
    }

    public static void main(String[] args) {
        MovingAverage_346 movingAverage = new MovingAverage_346(3);
        movingAverage.next(1); // return 1.0 = 1 / 1
        movingAverage.next(10); // return 5.5 = (1 + 10) / 2
        movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
        movingAverage.next(5);
    }
}
