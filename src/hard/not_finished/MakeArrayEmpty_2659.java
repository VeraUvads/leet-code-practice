package hard.not_finished;

public class MakeArrayEmpty_2659 {

    public long countOperationsToEmptyArray(int[] nums) {
        int n = nums.length;
        int deleted = 0;
        int start = 0;
        long operations = n;
        while (deleted != n){
            int smallest = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] < nums[smallest]) {
                    smallest = i;
                }
            }
            int notDeleted = 0;
            for (int i = start; i != smallest; i = (i + 1) % nums.length) {
                if (nums[i] != Integer.MAX_VALUE) {
                    notDeleted++;
                }
            }
            operations += notDeleted;
            nums[smallest] = Integer.MAX_VALUE;
            start = (smallest + 1) % n;
            deleted++;
        }
        return operations;
    }
}
