package easy;

import utils.Reader4;

public class ReadNCharactersGivenRead4_157 extends Reader4 {

    public int read(char[] buf, int n) {
        int pointer = 0;
        char[] internalBuf = new char[4];
        while (pointer < n) {
            int readed = read4(internalBuf);
            for (int i = 0; i < readed; i++) {
                buf[pointer++] = internalBuf[i];
                if (pointer == n) break;
            }
            if (readed < 4) break;
        }

        return pointer;
    }

}
