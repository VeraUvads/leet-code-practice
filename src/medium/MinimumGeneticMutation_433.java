package medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumGeneticMutation_433 {
    // https://leetcode.com/problems/minimum-genetic-mutation/description/?envType=study-plan-v2&envId=top-interview-150
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        int level = 0;
        while (!queue.isEmpty())  {
            int size = queue.size();
            while (size != 0) {
                String curr = queue.poll();
                if (curr.equals(endGene)) return level;
                for (int i = 0; i < bank.length; i++) {
                    String gene = bank[i];
                    if (visited.contains(i)) continue;
                    if (isSingleChange(gene, curr)) {
                        visited.add(i);
                        queue.add(gene);
                    }
                }
                size--;
            }
            level++;
        }
        return -1;
    }

    private boolean isSingleChange(String gene, String current) {
        int counter = 0;
        for (int i = 0; i < 8; i++) {
            if (gene.charAt(i) !=  current.charAt(i)) counter++;
            if (counter > 1) return false;
        }
        return true;
    }
}
