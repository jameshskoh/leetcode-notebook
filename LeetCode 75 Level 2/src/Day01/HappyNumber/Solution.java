package Day01.HappyNumber;

import java.util.HashSet;

public class Solution {
    public boolean isHappy(int n) {
        int currNumber = n;

        HashSet<Integer> history = new HashSet<>();

        while (true) {
            currNumber = digitSquareSum(currNumber);

            if (currNumber == 1) {
                return true;
            } else if (history.contains(currNumber)) {
                return false;
            }

            history.add(currNumber);
        }
    }

    private int digitSquareSum(int number) {
        int currNumber = number;
        int sum = 0;

        while (currNumber != 0) {
            int rem = currNumber % 10;
            sum += rem * rem;

            currNumber = currNumber / 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] vals = new int[]{19, 2, 34};

        for (int val : vals) {
            System.out.println(val + ": " + s.isHappy(val));
        }
    }
}