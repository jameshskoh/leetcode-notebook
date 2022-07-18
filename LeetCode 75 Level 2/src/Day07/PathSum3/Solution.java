package Day07.PathSum3;

import java.util.LinkedList;

public class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        LinkedList<Long> mySumList = new LinkedList<>();

        return subpathSum(root, targetSum, mySumList);
    }

    private int subpathSum(TreeNode node, long targetSum, LinkedList<Long> parentSumList) {
        LinkedList<Long> mySumList = new LinkedList<>();
        int counter = 0;

        mySumList.add((long)(node.val));

        if (node.val == targetSum) counter++;

        for (long sum : parentSumList) {
            long newSum = sum + node.val;

            if (newSum == targetSum) counter++;

            mySumList.add(newSum);
        }

        if (node.left != null) {
            counter += subpathSum(node.left, targetSum, mySumList);
        }

        if (node.right != null) {
            counter += subpathSum(node.right, targetSum, mySumList);
        }

        return counter;
    }
}
