package Day12.HouseRobber;

public class Solution {
    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }  else if (nums.length == 2) {
            return compareMemo(nums);
        }

        int[] memo = new int[nums.length];

        memo[0] = nums[0];
        memo[1] = nums[1];
        memo[2] = nums[0] + nums[2];

        for (int i = 3; i < nums.length; i++) {
            appendMemo(memo, nums, i);
        }

        return compareMemo(memo);
    }

    private void appendMemo(int[] memo, int[] nums, int i) {
        int val = Math.max(memo[i - 3], memo[i - 2]);
        memo[i] = nums[i] + val;
    }

    private int compareMemo(int[] memo) {
        int n = memo.length;
        return Math.max(memo[n - 2], memo[n - 1]);
    }
}
