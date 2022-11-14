package easy;

// https://leetcode.com/problems/remove-element/

public class RemoveElement_27 {

    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 3, 3};
        System.out.println(removeElement(array, 3));
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
}
