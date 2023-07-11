package medium;

import java.util.Arrays;

public class H_Index_274 {  // Same as H-Index II 275 - but sorted

    // https://leetcode.com/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150
    class Solution {
        public int hIndex(int[] citations) {
            int n = citations.length;
            Arrays.sort(citations);
            int index = 0;
            while (index < n && citations[n  - 1 - index] > index) {
                index++;
            }
            return index;
        }
    }
    class SolutionBinarySearch {
        /**
         A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each
         */
        public int hIndex(int[] citations) {
            Arrays.sort(citations);
            int n = citations.length;
            int start = 0, end = citations[n-1];
            int res = 0;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                int count = countMoreThan(mid, citations);
                if (mid > count) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                    res = mid;
                }
            }
            return res;
        }

        private int countMoreThan(int hIndex, int[] citations) {
            int start = 0, end = citations.length - 1;
            int res = 0;
            while (start <= end) {
                int midIndex = start + (end - start) / 2;
                if (citations[midIndex] < hIndex) {
                    start = midIndex + 1;
                } else {
                    end = midIndex - 1;
                    res = midIndex;
                }
            }
            return citations.length - res;
        }
    }
}
