package easy;

public class RomanToInteger13 {
    // 13. Roman to Integer
    public int romanToInt(String s) {
        if (s.length() == 0) return 0;
        int prev = getValue(s.charAt(0));
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            int curr = getValue(s.charAt(i));
            if (prev < curr) result -= prev;
            else result += prev;
            prev = curr;
        }
        return result + prev;
    }

    private int getValue(char symbol) {
        switch (symbol) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}
