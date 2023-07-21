package hard;

import java.util.LinkedList;

public class IntegerToEnglishWords_273 {
    // https://leetcode.com/problems/integer-to-english-words/description/
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int divider = 1000000000;
        LinkedList<Integer> queue = new LinkedList<>();
        while (num != 0) {
            queue.add(num / divider);
            num %= divider;
            divider /= 1000;
        }
        StringBuilder builder = new StringBuilder();
        int order = 4;
        while (!queue.isEmpty()) {
            order--;
            int curr = queue.removeFirst();
            if (curr == 0) continue;
            int hundred = curr / 100;
            curr %= 100;
            int ten = curr / 10;
            int one = curr % 10;
            if (hundred != 0) {
                builder.append(" ");
                builder.append(ones(hundred));
                builder.append(" Hundred");
            }
            if (ten != 0 && curr < 20) {
                builder.append(" ");
                builder.append(fromTenToNineteen(curr));
            } else {
                if (ten != 0) {
                    builder.append(" ");
                    builder.append(tens(ten));
                }
                if (one != 0) {
                    builder.append(" ");
                    builder.append(ones(one));
                }
            }
            builder.append(" ");
            builder.append(getOrder(order));
        }
        return builder.toString().trim();
    }

    public String ones(int num) {
        switch (num) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
        }
        return "";
    }

    public String fromTenToNineteen(int num) {
        switch (num) {
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
        }
        return "";
    }

    public String tens(int num) {
        switch (num) {
            case 2:
                return "Twenty";
            case 3:
                return "Thirty";
            case 4:
                return "Forty";
            case 5:
                return "Fifty";
            case 6:
                return "Sixty";
            case 7:
                return "Seventy";
            case 8:
                return "Eighty";
            case 9:
                return "Ninety";
        }
        return "";
    }

    private String getOrder(int n) {
        switch (n) {
            case 1:
                return "Thousand";
            case 2:
                return "Million";
            case 3:
                return "Billion";
        }
        return "";
    }
}
