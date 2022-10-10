package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sublist = new ArrayList<>();
        subproblem(result, sublist, candidates, 0, target);
        return result;
    }

    private void subproblem(List<List<Integer>> result, List<Integer> sublist, int[] candidates, int ptr, int target) {

        int len = candidates.length;

        for (int i = ptr; i < len; i++) {
            int newTarget = target - candidates[i];

            if (newTarget == 0) {
                List<Integer> list = new ArrayList<>(sublist);
                list.add(candidates[i]);
                result.add(list);
            } else if (newTarget > 0) {
                sublist.add(candidates[i]);
                subproblem(result, sublist, candidates, i, newTarget);
                sublist.remove(sublist.size() - 1);
            }
        }
    }
}
