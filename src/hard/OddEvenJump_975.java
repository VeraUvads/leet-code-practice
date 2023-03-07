package hard;

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJump_975 {
    // https://leetcode.com/problems/odd-even-jump/description/

    public int oddEvenJumps(int[] arr) {
        int size = arr.length;
        if (size == 0) return 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        boolean[] canJumpToSmaller = new boolean[size];
        boolean[] canJumpToLargest = new boolean[size];
        canJumpToSmaller[size - 1] = true;
        canJumpToLargest[size - 1] = true;
        int answer = 1;
        map.put(arr[size - 1], size - 1);
        for (int i = size - 2; i >= 0; i--) {
            Map.Entry<Integer, Integer> largestElement = map.ceilingEntry(arr[i]);
            if (largestElement != null) {
                canJumpToLargest[i] = canJumpToSmaller[largestElement.getValue()];
            }

            Map.Entry<Integer, Integer> smallerElement = map.floorEntry(arr[i]);
            if (smallerElement != null) {
                canJumpToSmaller[i] = canJumpToLargest[smallerElement.getValue()];
            }
            map.put(arr[i], i);
            if (canJumpToLargest[i]) {
                answer++;
            }
        }
        return answer;
    }
}
