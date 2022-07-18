package Day06.BalancedBinaryTree;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        int res = helper(root);

        if (res == -1) return false;

        return true;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = helper(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = helper(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
