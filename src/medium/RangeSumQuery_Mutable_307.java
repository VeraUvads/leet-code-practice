package medium;

public class RangeSumQuery_Mutable_307 {
    // https://leetcode.com/problems/range-sum-query-mutable/
    class NumArrayRecursive {
        private int[] tree;
        private int n;

        public NumArrayRecursive(int[] nums) {
            this.n = nums.length;
            tree = new int[n * 4];
            buildSegmentTree(1, 0, n - 1, nums);
        }

        private void buildSegmentTree(int index, int left, int right, int[] nums) {
            if (left == right) {
                tree[index] = nums[left];
                return;
            }
            int mid = left + (right - left) / 2;
            buildSegmentTree(index * 2, left, mid, nums);
            buildSegmentTree(index * 2 + 1, mid + 1, right, nums);
            tree[index] = tree[index * 2] + tree[index * 2 + 1];
        }


        public void update(int index, int val) {
            updateRecursive(1, index, 0, n - 1, val);
        }

        private void updateRecursive(int treeIndex, int arrIndex, int left, int right, int val) {
            if (left == right) {
                tree[treeIndex] = val;
                return;
            }
            int mid = left + (right - left) / 2;
            if (arrIndex <= mid) {
                updateRecursive(treeIndex * 2, arrIndex, left, mid, val);
            } else {
                updateRecursive(treeIndex * 2 + 1, arrIndex, mid + 1, right, val);
            }
            tree[treeIndex] = tree[treeIndex * 2] + tree[treeIndex * 2 + 1];
        }

        public int sumRange(int l, int r) {
            return getFromRangeRecursive(l, r, 1, 0, n - 1);
        }


        /**
         * 9 (1)
         * 0-2
         * 8(2)       1(3)
         * 1-2         0-0
         * 3(4)   5(5)
         * 1-1     2-2
         */

        private int getFromRangeRecursive(int left, int right, int index, int mutableLeft, int mutableRight) {
            if (mutableLeft > right || mutableRight < left) {
                return 0;
            }
            if (left <= mutableLeft && right >= mutableRight) {
                return tree[index];
            }
            int mid = mutableLeft + (mutableRight - mutableLeft) / 2;
            int inLeft = getFromRangeRecursive(left, right, index * 2, mutableLeft, mid); // todo
            int inRight = getFromRangeRecursive(left, right, index * 2 + 1, mid + 1, mutableRight);
            return inLeft + inRight;
        }
    }


    class NumArrayBIT {
        private int[] tree;
        private int[] nums;
        private int n;

        public NumArrayBIT(int[] nums) {
            this.n = nums.length;
            this.nums = nums;
            this.tree = new int[n + 1];
            for (int i = 0; i < nums.length; i++) {
                put(i, nums[i]);
            }
        }

        public void put(int index, int val) {
            index++;
            while (index <= n) {
                tree[index] += val;
                index += (index) & (-index);
            }
        }

        public void update(int index, int val) {
            int dif = val - nums[index];
            nums[index] = val;
            put(index, dif);
        }


        public int sumRange(int l, int r) {
            return getSum(r + 1) - getSum(l);
        }

        private int getSum(int index) {
            int sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= (index) & (-index);
            }
            return sum;
        }


        /**
         9 (1)
         0-2
         8(2)       1(3)
         1-2         0-0
         3(4)   5(5)
         1-1     2-2
         */

    }
}
