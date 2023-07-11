package medium;

public class H_Index_II_275 {
    // https://leetcode.com/problems/h-index-ii/description/

    public int hIndex(int[] citations) {
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
