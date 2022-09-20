package Day11.BusRoutes;

import java.util.*;

public class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        int depth = 0;
        Queue<Integer> thisQueue;
        Queue<Integer> nextQueue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> usedRule = new HashSet<>();

        addNextStops(nextQueue, routes, source, usedRule);

        while (!nextQueue.isEmpty()) {
            thisQueue = nextQueue;
            nextQueue = new LinkedList<>();
            depth++;

            while (!thisQueue.isEmpty()) {
                int currNode = thisQueue.poll();
                if (currNode == target) return depth;
                if (visited.contains(currNode)) continue;

                visited.add(currNode);
                addNextStops(nextQueue, routes, currNode, usedRule);
            }
        }

        return -1;
    }

    private void addNextStops(Queue<Integer> nextQueue, int[][] routes, int currNode, Set<Integer> usedRule) {
        for (int routeNum = 0; routeNum < routes.length; routeNum++) {
            if (usedRule.contains(routeNum)) continue;

            for (int i = 0; i < routes[routeNum].length; i++) {
                if (routes[routeNum][i] != currNode) continue;

                usedRule.add(routeNum);
                for (int j = 0; j < routes[routeNum].length; j++) {
                    nextQueue.add(routes[routeNum][j]);
                }
            }
        }
    }
}
