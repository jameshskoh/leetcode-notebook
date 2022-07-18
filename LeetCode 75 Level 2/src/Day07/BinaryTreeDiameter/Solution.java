package Day07.BinaryTreeDiameter;

public class Solution {
    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        recursion(root);

        return max;
    }

    private int recursion(TreeNode node) {
        if (node == null) return 0;

        int leftMax = recursion(node.left);
        int rightMax = recursion(node.right);

        int myDiameter = leftMax + rightMax;
        max = (myDiameter > max) ? myDiameter : max;

        return (leftMax > rightMax) ? leftMax + 1 : rightMax + 1;
    }
}
