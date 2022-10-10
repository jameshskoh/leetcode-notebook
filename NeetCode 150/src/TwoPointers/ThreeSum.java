package TwoPointers;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        // guarantee to have at least 3 elements, these pointers are valid
        int pt1 = 0;

        while (pt1 < len) {
            if (pt1 > 0 && nums[pt1] == nums[pt1 - 1]) {
                pt1++;
                continue;
            }

            int target = -nums[pt1];
            int pt2 = pt1 + 1;
            int pt3 = len - 1;

            while (pt2 < pt3) {
                if (pt2 > pt1 + 1 && nums[pt2] == nums[pt2 - 1]) {
                    pt2++;
                    continue;
                }

                int sum = nums[pt2] + nums[pt3];

                if (sum > target) {
                    pt3--;
                } else if (sum < target) {
                    pt2++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[pt1]);
                    list.add(nums[pt2]);
                    list.add(nums[pt3]);
                    result.add(list);

                    pt2++;
                }
            }

            pt1++;
        }

        return result;
    }
}
