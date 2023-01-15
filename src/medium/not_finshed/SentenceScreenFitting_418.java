package medium.not_finshed;

public class SentenceScreenFitting_418 {
    // https://leetcode.com/problems/sentence-screen-fitting/description/
    public int wordsTyping(String[] sentence, int rows, int cols) {
        if (sentence.length == 0) return 0;
        int res = 0;
        int pointer = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (sentence[pointer].length() > cols) return 0;
                if (sentence[pointer].length() > cols - col) break;
                col += sentence[pointer].length();
                pointer++;
                if (pointer == sentence.length) {
                    pointer = 0;
                    res++;
                }
            }
        }
        return res;
    }
}
