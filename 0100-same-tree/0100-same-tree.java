class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // both null
        if (p == null && q == null) {
            return true;
        }

        // one null
        if (p == null || q == null) {
            return false;
        }

        // value mismatch
        if (p.val != q.val) {
            return false;
        }

        // check left & right
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}