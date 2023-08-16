package medium;

public class SortAnArray_912 {
    // https://leetcode.com/problems/sort-an-array/
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
        return nums;
    }



    private void mergeSort(int[] nums, int left, int end, int[] tempArray) {
        if (end <= left) return;

        int mid = (left + end) / 2;
        mergeSort(nums, left,  mid,  tempArray);
        mergeSort(nums, mid + 1, end, tempArray);
        merge(nums, left, mid, end, tempArray);
    }
    // 2 4 3 3

    private void merge(int[] nums, int left, int mid, int end, int[] tempArray) {
        int start1 = left;
        int start2 = mid + 1;
        for (int i = start1; i <= mid; i++) {
            tempArray[i] = nums[i];
        }
        for (int i = start2; i <= end; i++) {
            tempArray[i] = nums[i];
        }
        int i = start1;
        while (start1 <= mid && start2 <= end) {
            if (tempArray[start1] > tempArray[start2]) {
                nums[i++] = tempArray[start2++];
            } else {
                nums[i++] = tempArray[start1++];
            }
        }

        while (start1 <= mid) {
            nums[i++] = tempArray[start1++];
        }
        while (start2 <= end) {
            nums[i++] = tempArray[start2++];
        }
    }

    public int[] sortArray2(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int p = partition(nums, low, high);
            System.out.println(p);
            quickSort(nums, low, p - 1);
            quickSort(nums, p + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int smalest = low - 1;
        for (int j = low; j <= high; j++) {
            if (nums[j] < pivot) {
                swap(nums, ++smalest, j);
            }
        }
        swap(nums, smalest + 1, high);
        return smalest + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    public int[] heapSort(int[] nums) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, i, n);
        }

        for (int i = n - 1; i >= 0;  i--) {
            swap(nums, i, 0);
            heapify(nums, 0, i);
        }
        return nums;
    }

    private void heapify(int[] nums, int index, int size) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        if (left < size && nums[left] >  nums[largest]) {
            largest = left;
        }
        if (right < size && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != index)  {
            swap(nums, largest, index);
            heapify(nums, largest, size);
        }

    }

}
