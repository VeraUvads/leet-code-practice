package easy;

public class ReverseBits_190 {
    // https://leetcode.com/problems/reverse-bits/description/
    public int reverseBits(int n) {
        int answer = 0;
        for (int i = 0; i < 32; i++) {
            answer += (n & 1) << (31 - i);
            n = n >> 1; // ?
        }
        return answer;
    }
}
