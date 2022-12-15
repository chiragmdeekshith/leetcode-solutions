package easy;

import common.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isBalanced(root.left) && isBalanced(root.right)) {
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            int difference = leftHeight - rightHeight;
            if (difference >= -1 && difference <= 1) {
                return true;
            }
        }
        return false;
    }

    private int getHeight(TreeNode current) {
        if(current == null){
            return -1;
        }
        int left = 1 + getHeight(current.left);
        int right = 1 + getHeight(current.right);
        return Math.max(left, right);
    }
}
