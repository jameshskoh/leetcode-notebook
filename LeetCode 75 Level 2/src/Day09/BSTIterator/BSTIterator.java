package Day09.BSTIterator;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        stack.push(root);

        TreeNode curr = root;
        while (curr.left != null) {
            stack.push(curr.left);
            curr = curr.left;
        }
    }

    public int next() {
        TreeNode curr = stack.pop();

        if (curr.right != null) {
            TreeNode child = curr.right;
            stack.push(child);

            while (child.left != null) {
                stack.push(child.left);
                child = child.left;
            }
        }

        return curr.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}