package easy;

public class AddBinary_67 {
    // https://leetcode.com/problems/add-binary/description/


    // Добавлять все элементы слева направо
    // Каждый круг добавляем число в памяти + цифру из первой строки + цифру из второй;
    // Для сложения char вычитаем '0', и это позволит нам преобразовать char в int;
    // В память сохраняем целое от деления на два.
    // В результат идет остаток от деления на два.

    public static String addBinary(String a, String b) {
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int inMemory = 0;
        StringBuilder builder = new StringBuilder();
        while (aIndex >= 0 || bIndex >= 0) {
            int sum = inMemory;
            if (aIndex >= 0) {
                sum += a.charAt(aIndex) - '0';
                aIndex--;
            }
            if (bIndex >= 0) {
                sum += b.charAt(bIndex) - '0';
                bIndex--;
            }
            inMemory = sum / 2;
            builder.append(sum % 2);
        }
        if (inMemory != 0) builder.append(inMemory);

        return builder.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }
}
