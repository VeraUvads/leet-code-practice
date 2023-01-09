package hard;

public class MedianOfTwoSortedArrays_4 {

   // https://leetcode.com/problems/median-of-two-sorted-arrays/description/

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        if (length2 > length1) return findMedianSortedArrays(nums2, nums1);
        int total = length1 + length2, half = (total - 1) / 2;
        int left = 0;
        int right = Math.min(half, length2);
        while (left < right) {
            int mid2 = (left + right) / 2;
            int mid1 = half - mid2;
            if (nums2[mid2] < nums1[mid1]) {
                left = mid2 + 1;
            } else {
                right = mid2;
            }
        }
        int a = Math.max(
                left > 0 ? nums2[left - 1]: Integer.MIN_VALUE,
                half - left >= 0 ? nums1[half - left] : Integer.MIN_VALUE
        );
        if (total % 2 != 0) return a;
        int b = Math.min(right < length2 ? nums2[right]: Integer.MAX_VALUE,
                half - right + 1 < length1 ? nums1[half - right + 1] : Integer.MAX_VALUE
        );
        return (a + b)/2.0;
    }
}
