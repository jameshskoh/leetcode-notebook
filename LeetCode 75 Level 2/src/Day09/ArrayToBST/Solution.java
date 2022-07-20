package Day09.ArrayToBST;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return appendChild(nums, 0, nums.length - 1);
    }

    private TreeNode appendChild(int[] nums, int start, int end) {
        // handle special cases
        if (start == end) {
            TreeNode par = new TreeNode(nums[start]);
            return par;
        }

        if (start == end - 1) {
            TreeNode par = new TreeNode(nums[start]);
            par.right = new TreeNode(nums[end]);
            return par;
        }

        int mid = (start + end) / 2;
        TreeNode par = new TreeNode(nums[mid]);

        // special cases here?
        par.left = appendChild(nums, start, mid - 1);
        par.right = appendChild(nums, mid + 1, end);

        return par;
    }
}
