package medium;

public class LargestTimeForGivenDigits_949 {
    // https://leetcode.com/problems/largest-time-for-given-digits/description/

    int max = Integer.MIN_VALUE;
    public String largestTimeFromDigits(int[] arr) {
        backTrack(arr, 0);
        return max == Integer.MIN_VALUE ? "" : String.format("%02d:%02d", max / 60, max % 60);
    }

    private void backTrack(int[] arr, int start) {
        if (start == arr.length) {
            int hours = arr[0] * 10 + arr[1];
            int minutes = arr[2] * 10 + arr[3];
            if (hours < 24 && minutes < 60) {
                max = Math.max(max, hours * 60 + minutes);
            }
        }
        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            backTrack(arr, start + 1);
            swap(arr, start, i);
        }

    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
