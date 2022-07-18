package Day06.InvertBinaryTree;

import java.util.LinkedList;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return null;
        }

        queue.add(root);

        while (! queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left == null && node.right == null) {
                continue;
            } else if (node.left == null) {
                queue.add(node.right);
                node.left = node.right;
                node.right = null;
            } else if (node.right == null) {
                queue.add(node.left);
                node.right = node.left;
                node.left = null;
            } else {
                queue.add(node.left);
                queue.add(node.right);
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
        }

        return root;
    }
}