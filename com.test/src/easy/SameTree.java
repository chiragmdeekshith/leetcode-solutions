package easy;

import common.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q== null){
            return true;
        }
        else if (p == null || q == null){
            return false;
        }
        else if (p.val == q.val){
            boolean leftcompare = isSameTree(p.left, q.left);
            boolean rightcompare = isSameTree(p.right, q.right);
            return leftcompare && rightcompare;
        }
        return false;
    }
}
