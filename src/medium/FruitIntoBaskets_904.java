package medium;

import java.util.HashMap;

public class FruitIntoBaskets_904 {
    // https://leetcode.com/problems/fruit-into-baskets/description/

    public static int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>(); // Тип фрукта : Последнее вхождение
        int answer = 0;
        int startIndex = 0;
        for (int i = 0; i < fruits.length; i++) {
            map.put(fruits[i], i);
            if (map.size() > 2) {
                int earliestKey = 0;  //  Последнее вхождение самого раннего типа
                for (int key : map.keySet()) { // можно по другому, храня длинну, и последовательно удаляя по одному элементы из map по ключу
                                                // startIndex, пока map.size != 2, но так быстрее и поэтому мне больше нравится
                    if (map.get(key) < map.getOrDefault(earliestKey, Integer.MAX_VALUE)) {
                        earliestKey = key;
                    }
                }
                startIndex = map.get(earliestKey) + 1;
                map.remove(earliestKey);
            }
            answer = Math.max(answer, i - startIndex + 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        totalFruit(new int[]{0,1,2,2});
    }
}
