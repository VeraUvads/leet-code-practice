package medium;

public class ValidateIPAddress_468 {
    // https://leetcode.com/problems/validate-ip-address/description/
    // "2001:0db8:85a3:0:0:8A2E:0370:7334:"
    public String validIPAddress(String queryIP) {
        String[] IPv4 = queryIP.split("\\.", -1);
        String[] IPv6 = queryIP.split(":", -1);
        boolean isIPv4 = IPv4.length == 4;
        boolean isIPv6 = IPv6.length == 8;
        if (!isIPv4 && !isIPv6) return "Neither";
        for (String item  : IPv4) {
            if (!isIPv4) break;
            isIPv4 = isValidIPv4Item(item);
        }
        if (isIPv4) return "IPv4";
        for (String item : IPv6) {
            if (!isIPv6) break;
            isIPv6 = isValidIPv6Item(item);
        }
        if (isIPv6) return "IPv6";
        return "Neither";
    }

    private boolean isValidIPv4Item(String string) {
        if (string.length() > 3 || string.length() < 1) return false;
        if (string.length() != 1 && string.charAt(0) == '0') return false;
        int builder = 0;
        for (int i = 0; i < string.length(); i++) {
            char symbol = string.charAt(i);
            if (!Character.isDigit(symbol)) return false;
            builder = builder * 10 + (symbol - '0');
        }
        return builder >= 0 && builder <= 255;
    }

    private boolean isValidIPv6Item(String string) {
        if (string.length() > 4 || string.length() < 1) return false;
        for (int i = 0; i < string.length(); i++) {
            char symbol = string.charAt(i);
            if (!(Character.isDigit(symbol) || isAllowedLetter(symbol))) return false;
        }
        return true;
    }

    private boolean isAllowedLetter(char symbol) {
        return symbol >= 'a' && symbol <= 'f' || symbol >= 'A' && symbol <='F';
    }
}
