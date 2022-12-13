package medium;

public class MultiplyStrings_43 {
    // https://leetcode.com/problems/multiply-strings/description/
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))  return "0";
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < num1.length() + num2.length(); ++i) {
            answer.append(0);
        }
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        for (int i = 0; i < num1.length(); i++) {
            int first = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int second = num2.charAt(j) - '0';
                int position = i + j;
                int carry  = answer.charAt(position) - '0';
                int multiply = first * second + carry;
                int temp = multiply % 10;
                int value = (answer.charAt(position + 1) - '0') + multiply / 10;
                answer.setCharAt(position, (char) (temp + '0'));
                answer.setCharAt(position + 1, (char) (value + '0'));
            }
        }
        if (answer.charAt(answer.length() - 1) == '0') {
            answer.deleteCharAt(answer.length() - 1);
        }
        return answer.reverse().toString();
    }
}
