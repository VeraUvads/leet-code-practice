package medium;

public class RotateArray_189 {
    //  https://leetcode.com/problems/rotate-array/description/

    // Original List                   : 1 2 3 4 5 6 7
    // After reversing all numbers     : 7 6 5 4 3 2 1
    // After reversing first k numbers : 5 6 7 4 3 2 1
    // After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
    public void rotateWithReverse(int[] nums, int k) {
        if (k == 0) return;
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public void rotateOptimized(int[] nums, int k) {
        if (k == 0) return;
        int len = nums.length;
        k = k % len;
        int count = 0;
        for (int i = 0; i < k; i++)  {
            if (count == len) break;
            int prev = nums[i];
            int index = i;
            do {
                index = (index + k) % len;
                int temp = nums[index];
                nums[index] = prev;
                prev = temp;
                count++;
            } while (i != index);
        }
    }

    public void rotate(int[] nums, int k) {
        if (k == 0) return;
        int len = nums.length;
        k = k % len;
        boolean[] visited = new boolean[len];
        for (int i = 0; i < k; i++) {
            if (visited[i]) continue;
            int prev = nums[i];
            int index = i;

            while (!visited[index]) {
                visited[index] = true;
                int temp = nums[index];
                nums[index] = prev;
                prev = temp;
                index = (index + k) % len;
            }
            nums[i] = prev;
        }
    }
}
