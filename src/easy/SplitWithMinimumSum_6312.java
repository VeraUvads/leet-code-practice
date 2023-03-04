package easy;

public class SplitWithMinimumSum_6312 {
    public static void main(String[] args) {
        System.out.println(splitNum(100001));
    }

   public static int splitNum(int num) {
        String number = String.valueOf(num);
        int[] numbers = new int[10];
        for (int i = 0; i < number.length(); i++) {
            int cur = number.charAt(i) - '0';
            numbers[cur]++;
        }
        int first = 0;
        int second  = 0;
        boolean isFirst = true;
        int index = 1;
        while (index < numbers.length) {
                if (numbers[index] != 0) {
                if (isFirst)  {
                    first = first * 10  + index;
                } else {
                    second = second * 10 + index;
                }
                isFirst = !isFirst;
                numbers[index]--;
            } else {
                index++;
            }
        }
        System.out.println(first);
        System.out.println(second);
        return first  + second;
    }

}
