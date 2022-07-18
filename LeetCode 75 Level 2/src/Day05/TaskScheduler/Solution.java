package Day05.TaskScheduler;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] hash = new int[26];

        for (char task : tasks) {
            hash[(int)(task - 'A')]++;
        }

        int max = 0;
        int sum = 0;

        for (int val : hash) {
            sum += val;

            if (max < val) {
                max = val;
            }
        }

        if (n == 0) return sum;

        int maxQty = 0;
        for (int val : hash) {
            if (val == max) maxQty++;
        }

        int temp = ((n + 1) - maxQty) * (max - 1);

        int idleLeft = (temp > 0 ? temp : 0);

        int tmax = idleLeft + max * maxQty;

        return (sum > tmax ? sum : tmax);
    }
}
