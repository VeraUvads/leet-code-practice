package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Hints {
    public static void main(String[] args) {
        int[][] arr = new int[2][];
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int[] arr2 = new int[2];
        int[] copied = Arrays.copyOf(arr2, arr2.length);
        int max = Arrays.stream(copied).max().getAsInt();
        int sum = Arrays.stream(copied).sum();
        List<Integer> list = Arrays.asList(1, 0);

        Arrays.stream(arr2).forEach((a) -> {
            System.out.print(a + " ");
        });
        String a = max == Integer.MIN_VALUE ? "" : String.format("%02d:%02d", max / 60, max % 60);

        StringBuilder builder = new StringBuilder();
        builder.append(0);
        builder.deleteCharAt(2);
        builder.delete(1, 2);
        builder.replace(2, 4, "to that string");
        builder.insert(2, 'a');
    }
}
