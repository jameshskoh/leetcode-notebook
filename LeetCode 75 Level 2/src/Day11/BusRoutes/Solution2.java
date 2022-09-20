package Day11.BusRoutes;

import java.util.*;

public class Solution2 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        Map<Integer, Set<Integer>> buses = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            Set<Integer> bus = new HashSet<>();
            buses.put(i, bus);

            for (int j = 0; j < routes[i].length; j++) {
                bus.add(routes[i][j]);
            }
        }

        int depth = 0;
        Set<Integer> visited = new HashSet<>();

        Queue<Integer> currQueue;
        Queue<Integer> nextQueue = new LinkedList<>();

        addNextBuses(nextQueue, buses, source, visited);

        while (!nextQueue.isEmpty()) {
            currQueue = nextQueue;
            nextQueue = new LinkedList<>();
            depth++;

            for (int bus : currQueue) {
                if (buses.get(bus).contains(target)) return depth;
            }

            while (!currQueue.isEmpty()) {
                int bus = currQueue.poll();

                for (int stop : buses.get(bus)) {
                    addNextBuses(nextQueue, buses, stop, visited);
                }
            }
        }

        return -1;
    }

    private void addNextBuses(Queue<Integer> nextQueue, Map<Integer, Set<Integer>> buses, int currStop, Set<Integer> visited) {
        for (int bus : buses.keySet()) {
            if (visited.contains(bus)) continue;

            if (buses.get(bus).contains(currStop)) {
                nextQueue.add(bus);
                visited.add(bus);
            }
        }
    }
}
