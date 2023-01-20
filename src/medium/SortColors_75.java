package medium;

public class SortColors_75 {
    // https://leetcode.com/problems/sort-colors/description/

    public void sortColors(int[] nums) {
        int left = 0;
        int i = 0;
        int right = nums.length - 1;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left++, i++);
            } else if (nums[i] == 2) {
                swap(nums, right--, i);
            } else {
                i++;
            }
        }
    }


    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public void sortColorsBucket(int[] nums) {
        int[] colors = new int[3];
        for (int num : nums) {
            colors[num]++;
        }
        int index = 0;
        for (int i = 0; i < colors.length; i++) {
            while (colors[i] > 0) {
                if (index >= nums.length) break;
                nums[index] = i;
                colors[i]--;
                index++;
            }
        }
    }

}
