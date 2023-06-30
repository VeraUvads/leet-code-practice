package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf_315 {
    // https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/?envType=featured-list&envId=top-interview-questions

    class BIT {
        int offset = 10000;
        int size = offset * 2 + 1;
        public List<Integer> countSmaller(int[] nums) {
            if (nums.length == 0) return new ArrayList<>();
            ArrayList<Integer> result = new ArrayList<>();
            int[] tree = new int[size];
            for (int i = nums.length - 1; i >= 0; i--) {
                int smaller = query(nums[i] + offset, tree);
                result.add(smaller);
                update(nums[i] + offset, 1, tree);
            }
            Collections.reverse(result);
            return result;
        }


        private void update(int index, int value, int[] tree) {
            index++;
            while (index < size) {
                tree[index] += value;
                index += (index)&(-index);
            }
        }

        private int query(int index, int[] tree) {
            int result = 0;
            while (index > 0) {
                result += tree[index];
                index -= (index)&(-index);
            }
            return result;
        }

    }
}
