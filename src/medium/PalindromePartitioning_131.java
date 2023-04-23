package medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {
    // https://leetcode.com/problems/palindrome-partitioning/description/
    List<List<String>> answer = new ArrayList<>();
    String s;

    public List<List<String>> partition(String s) {
        this.s = s;
        backTrack(0, new ArrayList<>());
        return answer;
    }

    private void backTrack(int position, List<String> list) {
        if (position == s.length()) {
            answer.add(new ArrayList<>(list));
        }
        for (int end = position + 1; end <= s.length(); end++) {
            String substring = s.substring(position, end);
            if (isPalindrom(substring)) {
                list.add(substring);
                backTrack(end, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrom(String string) {
        int start = 0;
        int end =  string.length() - 1;
        while (start < end) {
            if (string.charAt(start++) != string.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

}
