package medium;

import javafx.util.Pair;

import java.util.*;

public class SnakesAndLadders_909 {
    // https://leetcode.com/problems/snakes-and-ladders/description/?envType=study-plan-v2&envId=top-interview-150
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        if (n == 0 || n == 1) return 0;
        int last = n * n;
        Pair<Integer, Integer>[] cells = new Pair[n * n + 1];
        int label = 1;
        Integer[] columns = new Integer[n];
        for (int i = 0; i < n; i++) {
            columns[i] = i;
        }
        for (int row = n - 1; row >= 0; row--) {
            for (int column : columns) {
                cells[label++] = new Pair<>(row, column);
            }
            Collections.reverse(Arrays.asList(columns));
        }
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.add(1);
        visited.add(1);
        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                int curr = queue.poll();
                if (curr == last) {
                    return moves;
                }
                for (int i = 1; i <= 6; i++) {
                    int next = curr + i;
                    if (next > last) break;
                    if (visited.add(next)) {
                        int row = cells[next].getKey(), col = cells[next].getValue();
                        if (board[row][col] != -1 ) {
                            queue.add(board[row][col]);
                        } else {
                            queue.add(next);
                        }
                    }
                }
                size--;
            }
            moves++;
        }
        return -1;
    }

}
