package hard;

import kotlin.Pair;

import java.util.*;

public class BusRoutes_815 {

    private Map<Integer, List<Integer>> map = new HashMap<>();

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        // 1) Creating map, where stop number is a key;
        // And value is a list of buses's number, which should visit this stop.
        // STOP_NUMBER -> [{BUS_NUMBER_1}, {BUS_NUMBER_2}]
        // BUS_NUMBER is a number of column;
        // STOP_NUMBER is a cell;
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                int stop = routes[i][j];
                List<Integer> buses = map.getOrDefault(stop, new ArrayList<>());
                buses.add(i);
                map.put(stop, buses);
            }
        }
        // We have to use BFS, for that we need a queue.
        // Queue will store pair STOP_NUMBER -> DEPTH
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();

        // To prevent a cycle, we shouldn't visit cells twice;
        // We are store every visited bus in the busVisited set, and stop in the stopVisited set;
        HashSet<Integer> stopVisited = new HashSet<>();
        HashSet<Integer> busVisited = new HashSet<>();
        int result = 0;

        // At the begining depth is 0
        queue.addLast(new Pair<>(source, 0));
        stopVisited.add(source);

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> node = queue.poll();
            int stop = node.getFirst();
            int depth = node.getSecond();
            if (stop == target) return depth;
            // Get the buses which visit this stop;
            List<Integer> buses = map.get(stop);
            for (int bus : buses) {
                // Check if we've already visited
                if (busVisited.contains(bus)) continue;
                // Take the route  for this bus
                int[] route = routes[bus];
                // Add every stop in this route to our graph
                for (int stopInRoute : route) {
                    // But don't add if we've already visited
                    if (stopVisited.contains(stopInRoute)) continue;
                    stopVisited.add(stopInRoute);
                    queue.add(new Pair<>(stopInRoute, depth + 1));
                }
                busVisited.add(bus);
            }
        }
        return -1;
    }

}
