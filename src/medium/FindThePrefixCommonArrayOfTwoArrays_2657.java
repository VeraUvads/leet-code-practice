package medium;

import java.util.HashSet;

public class FindThePrefixCommonArrayOfTwoArrays_2657 {
    // https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        HashSet<Integer> set = new HashSet<>();
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            set.add(A[i]);
            for (int j = 0; j <= i; j++) {
                if (set.contains(B[j])) count++;
            }
            answer[i] = count;
        }
        return answer;
    }
}
