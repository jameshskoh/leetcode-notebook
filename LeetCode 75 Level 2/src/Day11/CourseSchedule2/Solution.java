package Day11.CourseSchedule2;

import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer> notFirst = new HashSet<>();
        Map<Integer, Set<Integer>> prereq = new HashMap<>();
        Map<Integer, Set<Integer>> dep = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            notFirst.add(prerequisites[i][0]);
            putPrereq(prereq, prerequisites[i][0], prerequisites[i][1]);
            putDep(dep, prerequisites[i][0], prerequisites[i][1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        Set<Integer> added = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (!notFirst.contains(i)) {
                queue.add(i);
            }
        }

        Set<Integer> hold = new HashSet<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            added.add(node);

            hold.remove(node);

            if (dep.containsKey(node)) {
                outer: for (int child : dep.get(node)) {
                    for (int par : prereq.get(child)) {
                        if (!added.contains(par)) {
                            hold.add(child);
                            continue outer;
                        }
                    }

                    queue.add(child);
                }
            }
        }

        if (result.size() != numCourses) {
            return new int[0];
        } else {
            return result.stream().mapToInt(i -> i).toArray();
        }

        // loop through prerequisites, find starting points
        // put starting points into a queue
        // for each point in queue
            // if in holding list: remove from list
            // append to result

            // if its dependant has all prerequisites checked (in result, or a separate hash set): add to queue
            // if not: add to holding list

        // if queue empty
            // if holding list not empty, no answer: return []
            // if holding list empty: return result
    }

    private void putDep(Map<Integer, Set<Integer>> dep, int post, int pre) {
        if (dep.containsKey(pre)) {
            Set<Integer> set = dep.get(pre);
            set.add(post);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(post);
            dep.put(pre, set);
        }
    }

    private void putPrereq(Map<Integer, Set<Integer>> prereq, int post, int pre) {
        if (prereq.containsKey(post)) {
            Set<Integer> set = prereq.get(post);
            set.add(pre);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(pre);
            prereq.put(post, set);
        }
    }
}
