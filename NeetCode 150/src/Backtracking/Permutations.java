package Backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> remain = new HashSet<>();

        for (int num : nums) {
            remain.add(num);
        }

        subproblem(result, new ArrayList<>(), remain);

        return result;
    }

    private void subproblem(List<List<Integer>> result, List<Integer> sublist, Set<Integer> remain) {
        if (remain.isEmpty()) {
            List<Integer> list = new ArrayList<>(sublist);
            result.add(list);
        } else {
            Set<Integer> newRemain = new HashSet<>(remain);

            for (int next : remain) {
                sublist.add(next);
                newRemain.remove(next);

                subproblem(result, sublist, newRemain);

                sublist.remove(sublist.size() - 1);
                newRemain.add(next);
            }
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        swapSubproblem(result, nums, 0);

        return result;
    }

    private void swapSubproblem(List<List<Integer>> result, int[] nums, int pt) {
        if (pt == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) list.add(num);
            result.add(list);
        } else {
            for (int i = pt; i < nums.length; i++) {
                swap(nums, pt, i);
                swapSubproblem(result, nums, pt + 1);
                swap(nums, pt, i);
            }
        }
    }

    private void swap(int[] nums, int pt1, int pt2) {
        int temp = nums[pt1];
        nums[pt1] = nums[pt2];
        nums[pt2] = temp;
    }
}
