package easy;

public class ExcelSheetColumnNumber_171 {
    // https://leetcode.com/problems/excel-sheet-column-number/description/

    public int titleToNumber(String columnTitle) {
        int answer = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            answer = answer * 26 + (columnTitle.charAt(i) - 'A' + 1) ;
        }
        return answer;
    }
}
