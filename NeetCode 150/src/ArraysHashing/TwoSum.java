package ArraysHashing;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == complement) return new int[]{i, j};
            }
        }

        // shouldn't happen
        return new int[]{};
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> complement = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (complement.containsKey(nums[i])) return new int[]{i, complement.get(nums[i])};

            complement.put(target - nums[i], i);
        }

        // shouldn't happen
        return null;
    }
}
