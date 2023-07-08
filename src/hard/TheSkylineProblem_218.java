package hard;

import java.util.*;

public class TheSkylineProblem_218 {
    // https://leetcode.com/problems/the-skyline-problem/description/

    class SolutionBF {
        public List<List<Integer>> getSkyline(int[][] buildings) {
            SortedSet<Integer> positions = new TreeSet<>();
            for (int[] building : buildings) {
                int left = building[0];
                int right = building[1];
                positions.add(left);
                positions.add(right);
            }
            HashMap<Integer, Integer> indexes = new HashMap<>();
            int index = 0;
            for (int position : positions) {
                indexes.put(position, index++);
            }
            int[] heights = new int[positions.size()];
            for (int[] building : buildings) {
                int left = building[0], right = building[1];
                int height = building[2];
                int leftIndex = indexes.get(left), rightIndex = indexes.get(right);
                while (leftIndex < rightIndex) {
                    heights[leftIndex] = Math.max(heights[leftIndex++], height);
                }
            }
            ArrayList<List<Integer>> result = new ArrayList<>();

            for (int position : positions) {
                int indexPos = indexes.get(position);
                int height = heights[indexPos];
                if (result.isEmpty() || result.get(result.size() - 1).get(1) != height) {
                    result.add(Arrays.asList(position, height));
                }
            }
            return result;
        }
    }

    class Solution {
        public List<List<Integer>> getSkyline(int[][] buildings) {
            SortedSet<Integer> positions = new TreeSet<>();
            for (int[] building : buildings) {
                int left = building[0];
                int right = building[1];
                positions.add(left);
                positions.add(right);
            }
            ArrayList<List<Integer>> result = new ArrayList<>();
            for (int position : positions)  {
                int maxHeight = 0;
                for (int[] building: buildings) {
                    int left = building[0], right = building[1], height = building[2];
                    if (position >= left && position < right) {
                        maxHeight = Math.max(maxHeight, height);
                    }
                }
                if (result.isEmpty() || result.get(result.size() - 1).get(1) != maxHeight) {
                    result.add(Arrays.asList(position, maxHeight));
                }
            }
            return result;
        }
        class SolutionPQ {
            public List<List<Integer>> getSkyline(int[][] buildings) {
                ArrayList<int[]> list = new ArrayList<>();
                for (int i = 0; i < buildings.length; i++) {
                    int[] building = buildings[i];
                    int left = building[0], right = building[1], height = building[2];
                    list.add(new int[]{left, i});
                    list.add(new int[]{right, i});
                }
                Collections.sort(list, Comparator.comparingInt(a->a[0]));
                PriorityQueue<int[]> live = new PriorityQueue<>(Comparator.comparingInt(a->-a[1]));
                ArrayList<List<Integer>> result = new ArrayList<>();
                int index = 0;
                while (index < list.size()) {
                    int currX = list.get(index)[0];
                    while (index < list.size() && list.get(index)[0] == currX) {
                        int b = list.get(index)[1];
                        if (buildings[b][0] == currX) {
                            live.add(new int[]{buildings[b][1], buildings[b][2]});
                        }
                        index++;
                    }
                    while (!live.isEmpty() && live.peek()[0] <= currX)
                        live.poll();
                    int currHeight = live.isEmpty() ? 0 : live.peek()[1];
                    if (result.isEmpty() || result.get(result.size() - 1).get(1) != currHeight) {
                        result.add(Arrays.asList(currX, currHeight));
                    }

                }

                return result;
            }
        }


    }
}
