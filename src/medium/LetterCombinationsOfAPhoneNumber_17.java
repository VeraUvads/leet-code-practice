package medium;

import java.util.ArrayList;
import java.util.List;

class LetterCombinationsOfAPhoneNumber_17 {
//    https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

    List<String> answer = new ArrayList<String>();
    String phoneDigits;

    public List<String> letterCombinations(String digits) {
        phoneDigits = digits;
        backTrack(new StringBuilder(), 0);
        return answer;
    }

    private void backTrack(StringBuilder prev, int index) {
        if (index == phoneDigits.length()) {
            if (prev.length() != 0) answer.add(prev.toString());
            return;
        }
        String curr = get(phoneDigits.charAt(index));
        for (int i = 0; i < curr.length(); i++) {
            prev.append(curr.charAt(i));
            backTrack(prev, index + 1);
            prev.deleteCharAt(prev.length() - 1);
        }
    }

    private String get(char number) {
        switch (number)  {
            case '2': return "abc";
            case '3': return "def";
            case '4': return "ghi";
            case '5': return "jkl";
            case '6': return "mno";
            case '7': return "pqrs";
            case '8': return "tuv";
            case '9': return "wxyz";
        }
        return "";
    }

}
