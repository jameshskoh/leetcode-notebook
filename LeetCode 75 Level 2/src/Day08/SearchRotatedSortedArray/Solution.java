package Day08.SearchRotatedSortedArray;

public class Solution {
    public int search(int[] nums, int target) {
        int lb = 0;
        int ub = nums.length - 1;
        int pivot = 0;

        if (nums[lb] > nums[ub]) {
            while (lb < ub - 1) {
                int mid = (lb + ub) / 2;

                if (nums[lb] < nums[mid]) {
                    lb = mid;
                } else if (nums[ub] > nums[mid]) {
                    ub = mid;
                }
            }

            pivot = ub;
        } else {
            pivot = 0;
        }


        lb = 0;
        ub = nums.length - 1;

        while (lb <= ub) {
            int mid = (lb + ub) / 2;
            int midShift = shift(mid, pivot, nums);

            if (nums[midShift] == target) {
                return midShift;
            } else if (nums[midShift] < target) {
                lb = mid + 1;
            } else {
                ub = mid - 1;
            }
        }

        return -1;
    }

    private int shift(int index, int pivot, int[] nums) {
        return (index + nums.length + pivot) % nums.length;
    }
}
