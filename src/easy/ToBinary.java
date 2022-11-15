package easy;

public class ToBinary {


    public static String toBinary(int result) {
        StringBuilder builder = new StringBuilder();
        int divider = result;
        while(divider / 2 != 1) {
            int remainder = divider % 2;
            divider = divider / 2;
            builder.append(remainder);
        }
        builder.append(1);
        return builder.reverse().toString();
    }
}
