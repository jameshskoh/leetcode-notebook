package Day09.KthSmallestBST;

import java.util.HashSet;
import java.util.Stack;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int value = 0;
        int counter = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        HashSet<TreeNode> visited = new HashSet<TreeNode>();
        stack.push(root);

        while (counter != k && !stack.isEmpty()) {
            TreeNode curr = stack.peek();
            if (curr.left != null && !visited.contains(curr.left)) {
                stack.push(curr.left);
            } else {
                stack.pop();
                visited.add(curr);
                value = curr.val;
                counter++;

                if (curr.right != null) {
                    stack.push(curr.right);
                }
            }
        }

        return value;
    }
}
