package hard;

import kotlin.Pair;
import utils.Master;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class GuessTheWord_843 {
    // https://leetcode.com/problems/guess-the-word/description/
    HashSet<String> tried;
    Master master;
    String[] words;

    public void findSecretWord(String[] words, Master master) {
        this.tried = new HashSet<>();
        this.words = words;
        this.master = master;
        bfs();
    }

    private void bfs() {
        PriorityQueue<Pair<String, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.getSecond()));
        queue.add(new Pair<>(words[0], 0));
        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String word = pair.getFirst();
            if (!tried.add(word)) continue;
            int same = master.guess(word);
            if (same == 6) return;

            for (String next : words) {
                if (tried.contains(next)) continue;
                int correct = count(word, next);
                if (correct == same) {
                    queue.add(new Pair<>(next, same));
                } else {
                    tried.add(next);
                }
            }
        }
    }

    private int count(String word1, String word2) {
        int same = 0;
        for (int i = 0; i < word2.length(); i++) {
            if (word1.charAt(i) == word2.charAt(i)) same++;
        }
        return same;
    }
}
