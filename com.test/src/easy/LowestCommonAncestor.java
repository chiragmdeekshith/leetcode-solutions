package easy;

import common.TreeNode;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestorRecursive(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestorRecursive(root.right, p, q);
        }
        return root;
    }

    public TreeNode lowestCommonAncestorLoop(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        while (true) {
            if (p.val < current.val && q.val < current.val) {
                current = current.left;
            } else if (p.val > current.val && q.val > current.val) {
                current = current.right;
            } else {
                return current;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        //new LowestCommonAncestor().lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4));
    }
}
