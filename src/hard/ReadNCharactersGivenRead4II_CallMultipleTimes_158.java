package hard;

import utils.Reader4;

public class ReadNCharactersGivenRead4II_CallMultipleTimes_158 extends Reader4 {
    // https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/description/

    private char[] internalBuf = new char[4];
    private int start = 0;
    private int end = 0;

    public int read(char[] buf, int n) {
        int pointer = 0;
        while (pointer < n && start < end) {
            buf[pointer++] = internalBuf[start++];
        }
        while (pointer < n) {
            int readed = read4(internalBuf);
            start = 0;
            end = readed;
            while (start < end && pointer < n) {
                buf[pointer++] = internalBuf[start++];
            }
            if (readed < 4) break;
        }
        return pointer;
    }
}
